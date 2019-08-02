package com.aawashcar.opsservice.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.aawashcar.opsservice.entities.WasherOrderSummary;
import com.aawashcar.opsservice.entities.Worker;
import com.aawashcar.opsservice.mappers.WorkerMapper;
import com.aawashcar.opsservice.model.OrderWorker;
import com.aawashcar.opsservice.model.User;
import com.aawashcar.opsservice.model.WorkerModel;
import com.aawashcar.opsservice.service.WorkerService;

@Service()
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	private WorkerMapper workerMapper;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${mcw.service.oms.url.prefix}")
	protected String omsUrlPrefix;

	@Value("${mcw.service.crm.url.prefix}")
	protected String crmUrlPrefix;

	@Override
	public Worker findWorkerById(int id) {
		return workerMapper.findWorkerById(id);
	}

	@Override
	public int findAssignedWorker(int id) {
		Integer orderId = workerMapper.findAssingedOrder(id);
		return orderId == null ? 0 : orderId.intValue();
	}

	@Override
	public List<Worker> listAll() {
		return workerMapper.listWorkers();
	}

	@Override
	@Transactional
	public int takeOrder(int workerId, int orderId, int remarksId) {
		workerMapper.takeOrder(remarksId, orderId, workerId);
		int status = workerMapper.findStatusByOrderIdAndWorkerId(workerId, orderId);
		syncOrderSatus(orderId, status);
		return status;
	}

	@Override
	@Transactional
	public int rushOrder(int workerId, int orderId, int remarksId, String orderNumber) {
		workerMapper.rushOrder(remarksId, orderId, workerId, orderNumber);

		workerMapper.updateWorkerWorkingStatus(workerId, 1);
		int status = workerMapper.findStatusByOrderIdAndWorkerId(workerId, orderId);
		syncOrderSatus(orderId, status);
		return status;
	}

	@Override
	@Transactional
	public int rejectOrder(int workerId, int orderId, int remarksId) {
		workerMapper.rejectOrder(remarksId, orderId, workerId);
		int status = workerMapper.findStatusByOrderIdAndWorkerId(workerId, orderId);

		workerMapper.updateWorkerWorkingStatus(workerId, 0);

		syncOrderSatus(orderId, status);
		return status;
	}

	@Override
	@Transactional
	public int arrivedOrder(int workerId, int orderId, int remarksId) {
		workerMapper.arrivedOrder(remarksId, orderId, workerId);
		int status = workerMapper.findStatusByOrderIdAndWorkerId(workerId, orderId);
		syncOrderSatus(orderId, status);
		return status;
	}

	@Override
	@Transactional
	public int completeOrder(int workerId, int orderId, int remarksId) {
		workerMapper.completeOrder(remarksId, orderId, workerId);
		int status = workerMapper.findStatusByOrderIdAndWorkerId(workerId, orderId);
		syncOrderSatus(orderId, status);
		workerMapper.updateWorkerWorkingStatus(workerId, 0);
		return status;
	}

	@Override
	public List<WasherOrderSummary> listCompletedWorkerOrderSummary(int workerId, int size) {
		return workerMapper.listCompletedWorkerOrderSummary(workerId, size);
	}

	private int syncOrderSatus(int orderId, int statusCode) {
		String url = omsUrlPrefix + "order/udpatestatus/" + String.valueOf(orderId) + "/" + String.valueOf(statusCode);
		return restTemplate.exchange(url, HttpMethod.PUT, null, Integer.class).getBody().intValue();
	}

	@Override
	@Transactional
	public int applyAsWorker(String phoneNumber, String validId) {
		if (workerMapper.checkExists(phoneNumber) == null) {
			workerMapper.applyAsWorker(phoneNumber, validId);
			return workerMapper.findWorkerIdByPhone(phoneNumber);
		} else {
			return -1;
		}
	}

	@Transactional
	@Override
	public boolean newWorker(WorkerModel model) {
		if (StringUtils.isEmpty(model.getPhoneNumber()) || StringUtils.isEmpty(model.getValidId())) {
			return false;
		}

		if ("null".equals(model.getPhoneNumber()) || "null".equals(model.getValidId())) {
			return false;
		}
		// update applied worker
		int affectedRow = workerMapper.updateWorkerAsNewOne(convertWorkerModelToNewWorker(model));

		if (affectedRow == 1) {
			Worker worker = workerMapper.findWorkerByIdentityId(model.getIdentityId());
			// add user in crm and update the ruseruuid
			// worker/new/{validid}, body is User
			String url = crmUrlPrefix + "worker/new/" + model.getValidId();
			User user = fillUser(model);
			user.setWorkerId(worker.getId());
			Boolean result = restTemplate.postForEntity(url, user, Boolean.class).getBody();

			return result;
		}

		return false;
	}

	private User fillUser(WorkerModel model) {
		User user = new User();
		user.setPhoneNumber(model.getPhoneNumber());
		user.setEnabled(true);
		user.setFirstName(model.getFirstName() != null ? model.getFirstName() : null);
		user.setLastName(model.getLastName() != null ? model.getLastName() : null);
		user.setNickName(model.getNickName() != null ? model.getNickName() : null);
		return user;
	}

	private Worker convertWorkerModelToNewWorker(WorkerModel model) {
		Worker worker = new Worker();
		worker.setIdentityId(model.getIdentityId());
		worker.setPhoneNumber(model.getPhoneNumber());
		worker.setEnabled(true);
		worker.setFirstName(model.getFirstName() != null ? model.getFirstName() : null);
		worker.setLastName(model.getLastName() != null ? model.getLastName() : null);
		worker.setGender(model.getGender() != null ? model.getGender() : null);
		worker.setNickName(model.getNickName() != null ? model.getNickName() : null);
		return worker;
	}

	@Override
	public Worker findWorkerByOrderId(int orderId) {
		return workerMapper.findWorkerByOrderId(orderId);
	}

	@Override
	@Transactional
	public boolean assignOrder(OrderWorker orderWorker) {
		Integer rId = workerMapper.findExistingWorkerOrderR(orderWorker.getOrderId());
		int result = 0;
		if (rId != null) {
			// rejected order exists
			result = workerMapper.assignRejectedOrder(orderWorker.getWorkerId(), rId.intValue());
		} else {
			// fresh order
			result = workerMapper.assignOrder(orderWorker.getWorkerId(), orderWorker.getOrderId(),
					orderWorker.getOrderNumber());
		}

		workerMapper.updateWorkerWorkingStatus(orderWorker.getWorkerId(), 1);

		if (result == 1) {
			syncOrderSatus(orderWorker.getOrderId(), 36);
		} else {
			return false;
		}

		return true;
	}

	@Override
	public String queryOpenIdByPhoneNumber(String phoneNumber) {
		return workerMapper.queryOpenIdByPhoneNumber(phoneNumber);
	}

	@Override
	public List<Worker> listBusyOnes() {
		return workerMapper.listBusyWorkers();
	}

	@Override
	public List<Worker> listEveryOnes() {
		return workerMapper.listEveryOnes();
	}

	@Transactional
	@Override
	public int cancelOrder(int workerId, int orderId) {
		int result = workerMapper.cancelOrder(workerId, orderId);

		if (result == 1) {
			// set worker to not busy
			result = workerMapper.updateWorkerWorkingStatus(workerId, 0);
		}
		return result;
	}

	@Override
	public int disableWorkerById(int id) {
		return workerMapper.disableWorkerById(id);
	}

	@Override
	public int updateWorker(Worker worker) {
		return workerMapper.updateWorker(worker);
	}

	@Override
	public List<WasherOrderSummary> listUnCompletedWorkerOrderSummary(int workerId, int size) {
		return workerMapper.listUnCompletedWorkerOrderSummary(workerId, size);
	}

	@Override
	public List<WasherOrderSummary> listAvailableWorkerOrderSummary(int workerId, int size) {
		return workerMapper.listAvailableWorkerOrderSummary(workerId, size);
	}
}
