package com.aawashcar.opsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.aawashcar.opsservice.entities.WasherOrderSummary;
import com.aawashcar.opsservice.entities.Worker;
import com.aawashcar.opsservice.entities.WorkerRemark;
import com.aawashcar.opsservice.model.OrderWorker;
import com.aawashcar.opsservice.model.WorkerModel;
import com.aawashcar.opsservice.service.RemarkService;
import com.aawashcar.opsservice.service.WorkerService;

@RequestMapping("worker/")
@ResponseBody
@Controller
public class WorkerController {

	@Autowired
	private WorkerService workerService;

	@Autowired
	private RemarkService remarkService;

	@Autowired
	protected RestTemplate restTemplate;

	@Value("${mcw.service.oms.url.prefix}")
	private String omsUrlPrefix;

	@RequestMapping(value = "assignorder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean assignOrderToWorker(@RequestBody OrderWorker orderWorker) {
		return workerService.assignOrder(orderWorker);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Worker getWorker(@PathVariable("id") int id) {
		return workerService.findWorkerById(id);
	}
	
	@RequestMapping(value = "disable/{id}", method = RequestMethod.GET)
	public boolean disableWorker(@PathVariable("id") int id) {
		return workerService.disableWorkerById(id) == 1;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean updateWorker(@RequestBody Worker worker) {
		return workerService.updateWorker(worker) == 1;
	}

	@RequestMapping(value = "washedorder/{orderid}", method = RequestMethod.GET)
	public Worker getWorkerByOrderId(@PathVariable("orderid") int id) {
		return workerService.findWorkerByOrderId(id);
	}

	@RequestMapping(value = "assignedorder/{id}", method = RequestMethod.GET)
	public int getAssingedOrder(@PathVariable("id") int id) {
		return workerService.findAssignedWorker(id);
	}

	@RequestMapping(value = "listall", method = RequestMethod.GET)
	public List<Worker> listWorkers() {
		return workerService.listAll();
	}

	@RequestMapping(value = "listbusyones", method = RequestMethod.GET)
	public List<Worker> listBusyOnes() {
		return workerService.listBusyOnes();
	}

	@RequestMapping(value = "listeveryworker", method = RequestMethod.GET)
	public List<Worker> listEveryOnes() {
		return workerService.listEveryOnes();
	}

	@RequestMapping(value = "takeorder/{orderid}/{remarksid}/{workerid}", method = RequestMethod.PUT)
	public int takeOrder(@PathVariable("orderid") int orderId, @PathVariable("remarksid") int remarksId,
			@PathVariable("workerid") int workerId) {
		return workerService.takeOrder(workerId, orderId, remarksId);
	}
	
	@RequestMapping(value = "rushorder/{orderid}/{remarksid}/{workerid}/{ordernumber}", method = RequestMethod.PUT)
	public int rushOrder(@PathVariable("orderid") int orderId, @PathVariable("remarksid") int remarksId,
			@PathVariable("workerid") int workerId, @PathVariable("ordernumber") String orderNumber) {
		return workerService.rushOrder(workerId, orderId, remarksId, orderNumber);
	}

	@RequestMapping(value = "rejectorder/{orderid}/{remarksid}/{workerid}", method = RequestMethod.PUT)
	public int rejectOrder(@PathVariable("orderid") int orderId, @PathVariable("remarksid") int remarksId,
			@PathVariable("workerid") int workerId) {
		return workerService.rejectOrder(workerId, orderId, remarksId);
	}

	@RequestMapping(value = "arrivedorder/{orderid}/{remarksid}/{workerid}", method = RequestMethod.PUT)
	public int arrivedOrder(@PathVariable("orderid") int orderId, @PathVariable("remarksid") int remarksId,
			@PathVariable("workerid") int workerId) {
		return workerService.arrivedOrder(workerId, orderId, remarksId);
	}

	@RequestMapping(value = "completeorder/{orderid}/{remarksid}/{workerid}", method = RequestMethod.PUT)
	public int completeOrder(@PathVariable("orderid") int orderId, @PathVariable("remarksid") int remarksId,
			@PathVariable("workerid") int workerId) {
		return workerService.completeOrder(workerId, orderId, remarksId);
	}

	@RequestMapping(value = "remarks/listall", method = RequestMethod.GET)
	public List<WorkerRemark> listRemarks() {
		return remarkService.listRemarks();
	}

	@RequestMapping(value = "remarks/accept/list", method = RequestMethod.GET)
	public List<WorkerRemark> listAcceptRemarks() {
		return remarkService.listAcceptRemarks();
	}

	@RequestMapping(value = "remarks/reject/list", method = RequestMethod.GET)
	public List<WorkerRemark> listRejectRemarks() {
		return remarkService.listRejectRemarks();
	}

	@RequestMapping(value = "remarks/complete/list", method = RequestMethod.GET)
	public List<WorkerRemark> listCompleteRemarks() {
		return remarkService.listCompleteRemarks();
	}

	@RequestMapping(value = "orders/completedorderlist/{workerid}/{size}", method = RequestMethod.GET)
	public List<WasherOrderSummary> listCompletedOrderSummary(@PathVariable("workerid") int workerId,
			@PathVariable("size") int size) {
		return workerService.listCompletedWorkerOrderSummary(workerId, size);
	}

	@RequestMapping(value = "apply/{phonenumber}/{validid}", method = RequestMethod.POST)
	public int apply(@PathVariable("phonenumber") String phoneNumber, @PathVariable("validid") String validId) {
		return workerService.applyAsWorker(phoneNumber, validId);
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public boolean newWorker(@RequestBody WorkerModel workerModel) {
		return workerService.newWorker(workerModel);
	}

	@RequestMapping(value = "openid/{phonenumber}", method = RequestMethod.GET)
	public String queryOpenIdByPhoneNumber(@PathVariable("phonenumber") String phoneNumber) {
		return workerService.queryOpenIdByPhoneNumber(phoneNumber);
	}

	@RequestMapping(value = "cancelorder/{workerid}/{orderid}", method = RequestMethod.PUT)
	public boolean cancelOrder(@PathVariable("workerid") int workerId, @PathVariable("orderid") int orderId) {
		if (workerId == 0) {
			return updateOrderStatus(orderId, -1) == -1;
		} else {
			int result = workerService.cancelOrder(workerId, orderId);
			if (result == 1) {
				// update orm_order table
				return updateOrderStatus(orderId, -1) == -1;
			} else {
				return false;
			}
		}
	}

	private int updateOrderStatus(int orderId, int statusCode) {
		String url = omsUrlPrefix + "order/udpatestatus/" + String.valueOf(orderId) + "/" + String.valueOf(statusCode);
		ResponseEntity<Integer> codeResponse = restTemplate.exchange(url, HttpMethod.PUT, null, Integer.class);

		return codeResponse.getBody().intValue();
	}
	
	@RequestMapping(value = "orders/uncompletedorderlist/{workerid}/{size}", method = RequestMethod.GET)
	public List<WasherOrderSummary> listUnCompletedOrderSummary(@PathVariable("workerid") int workerId,
			@PathVariable("size") int size) {
		return workerService.listUnCompletedWorkerOrderSummary(workerId, size);
	}
	
	@RequestMapping(value = "orders/availableorderlist/{workerid}/{size}", method = RequestMethod.GET)
	public List<WasherOrderSummary> listAvailableOrderSummary(@PathVariable("workerid") int workerId,
			@PathVariable("size") int size) {
		return workerService.listAvailableWorkerOrderSummary(workerId, size);
	}
}
