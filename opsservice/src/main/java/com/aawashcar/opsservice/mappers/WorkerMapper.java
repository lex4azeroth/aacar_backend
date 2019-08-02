package com.aawashcar.opsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.opsservice.entities.WasherOrderSummary;
import com.aawashcar.opsservice.entities.Worker;

@Mapper
public interface WorkerMapper {
	
	Integer checkExists(@Param("phoneNumber") String phoneNumber);
	
	int deleteWorkerByIdentityId(String workerIdentityId);
	
	Worker findWorkerByIdentityId(String workerIdentityId);
	
	Worker findWorkerById(int id);
	
	int disableWorkerById(int id);
	
	void enableWorkerById(int id);
	
	int applyAsWorker(@Param("phoneNumber") String phoneNumber, @Param("validId") String validId);
	
	int findWorkerIdByPhone(@Param("phoneNumber") String phoneNumber);
	
	List<Worker> listWorkers();
	
	List<Worker> listBusyWorkers();
	
	List<Worker> listEveryOnes();
	
	Integer findAssingedOrder(int id);
	
	Integer findStatusByOrderIdAndWorkerId(@Param("workerId") int workerId, @Param("orderId") int orderId);
	
	void takeOrder(@Param("remarksId") int remarksId, 
	               @Param("orderId") int orderId, 
	               @Param("workerId") int workerId);
	
	int rushOrder(@Param("remarksId") int remarksId, 
            @Param("orderId") int orderId, 
            @Param("workerId") int workerId, 
            @Param("orderNumber") String orderNumber);
	
	void rejectOrder(@Param("remarksId") int remarksId, 
	               @Param("orderId") int orderId, 
	               @Param("workerId") int workerId);
	
	void completeOrder(@Param("remarksId") int remarksId, 
		               @Param("orderId") int orderId, 
		               @Param("workerId") int workerId);
	
	void arrivedOrder(@Param("remarksId") int remarksId, 
		               @Param("orderId") int orderId, 
		               @Param("workerId") int workerId);
	
	int cancelOrder(@Param("workerId") int workerId, @Param("orderId") int orderId);
	
	List<WasherOrderSummary> listCompletedWorkerOrderSummary(@Param("workerId") int workerId, 
	                                                @Param("size") int size);
	
	List<WasherOrderSummary> listUnCompletedWorkerOrderSummary(@Param("workerId") int workerId, 
            @Param("size") int size);
	
	List<WasherOrderSummary> listAvailableWorkerOrderSummary(@Param("workerId") int workerId, 
            @Param("size") int size);
	
	Worker findWorkerByOrderId(int id);
	
	int assignOrder(@Param("workerId") int workerId, 
	                @Param("orderId") int orderId, 
	                @Param("orderNumber") String orderNumber);
	
	int addWorker(Worker worker);
	
	int updateWorkerAsNewOne(Worker worker);
	
	int updateWorker(Worker worker);
	
	int updateWorkerWorkingStatus(@Param("workerId") int workerId, @Param("isBusy") int isBusy);
	
	String queryOpenIdByPhoneNumber(@Param("phoneNumber") String phoneNumber);
	
	Integer findExistingWorkerOrderR(@Param("orderId") int orderId);
	
	int assignRejectedOrder(@Param("workerId") int workerId, @Param("rId") int rId);
}
