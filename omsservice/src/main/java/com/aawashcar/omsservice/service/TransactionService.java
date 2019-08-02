package com.aawashcar.omsservice.service;

import com.aawashcar.omsservice.entities.CouponTransaction;
import com.aawashcar.omsservice.entities.OrderTransaction;
import com.aawashcar.omsservice.entities.PointTransaction;
import com.aawashcar.omsservice.entities.PromotionTransaction;
import com.aawashcar.omsservice.entities.ServiceTransaction;

public interface TransactionService {
	
	int recordCouponTransaction(CouponTransaction couponTransaction);
	
	int recordOrderTransaction(OrderTransaction orderTransaction);
	
	int recordPointTransaction(PointTransaction pointTransaction);
	
	int recordServiceTransaction(ServiceTransaction serviceTransaction);
	
	int recordPromotionTransaction(PromotionTransaction promotionTransaction);
	
	int findOrderTransactionId(int orderId);
	
	int updateOrderTransactionAmount(int id, double amount);
	
	int updateOrderTransactionByOrderId(OrderTransaction orderTransaction);
}
