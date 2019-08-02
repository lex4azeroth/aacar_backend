package com.aawashcar.opsservice.service;

import java.util.List;

import com.aawashcar.opsservice.entities.WasherOrderSummary;
import com.aawashcar.opsservice.entities.Worker;
import com.aawashcar.opsservice.model.OrderWorker;
import com.aawashcar.opsservice.model.WorkerModel;

public interface WorkerService {
	
	Worker findWorkerById(int id);
	
	int disableWorkerById(int id);
	
	int updateWorker(Worker worker);
	
	int findAssignedWorker(int id);
	
	List<Worker> listAll();
	
	List<Worker> listBusyOnes();
	
	List<Worker> listEveryOnes();
	
	int rushOrder(int workerId, int orderId, int remarksId, String orderNumber);
	
	int takeOrder(int workerId, int orderId, int remarksId);
	
	int rejectOrder(int workerId, int orderId, int remarksId);
	
	int arrivedOrder(int workerId, int orderId, int remarksId);
	
	int completeOrder(int workerId, int orderId, int remarksId);
	
	int cancelOrder(int workerId, int orderId);
	
	int applyAsWorker(String phoneNumber, String validId);
	
	List<WasherOrderSummary> listCompletedWorkerOrderSummary(
	                                                         int workerId, 
	                                                         int size);
	List<WasherOrderSummary> listUnCompletedWorkerOrderSummary(
            int workerId, 
            int size);

	List<WasherOrderSummary> listAvailableWorkerOrderSummary(
            int workerId, 
            int size);
	
	boolean newWorker(WorkerModel model);
	
	Worker findWorkerByOrderId(int orderId);
	
	boolean assignOrder(OrderWorker orderWorker);
	
	String queryOpenIdByPhoneNumber(String phoneNumber);
}
