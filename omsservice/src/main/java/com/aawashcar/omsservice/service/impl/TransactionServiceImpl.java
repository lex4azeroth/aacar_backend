package com.aawashcar.omsservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aawashcar.omsservice.entities.CouponTransaction;
import com.aawashcar.omsservice.entities.OrderTransaction;
import com.aawashcar.omsservice.entities.PointTransaction;
import com.aawashcar.omsservice.entities.PromotionTransaction;
import com.aawashcar.omsservice.entities.ServiceTransaction;
import com.aawashcar.omsservice.mappers.CouponTransactionMapper;
import com.aawashcar.omsservice.mappers.OrderTransactionMapper;
import com.aawashcar.omsservice.mappers.PointTransactionMapper;
import com.aawashcar.omsservice.mappers.PromotionTransactionMapper;
import com.aawashcar.omsservice.mappers.ServiceTransactionMapper;
import com.aawashcar.omsservice.service.TransactionService;

@Service()
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private OrderTransactionMapper orderTransactionMapper;
	
	@Autowired
	private PointTransactionMapper pointTransactionMapper;
	
	@Autowired
	private CouponTransactionMapper couponTransactionMapper;
	
	@Autowired
	private ServiceTransactionMapper serviceTransactionMapper;
	
	@Autowired
	private PromotionTransactionMapper promotionTransactionMapper;
	
	@Override
	public int recordOrderTransaction(OrderTransaction orderTransaction) {
		return orderTransactionMapper.addOrderTransaction(orderTransaction);
	}

	@Override
	public int recordPointTransaction(PointTransaction pointTransaction) {
		return pointTransactionMapper.addPointTransaction(pointTransaction);
	}
	
	@Override
	public int recordCouponTransaction(CouponTransaction couponTransaction) {
		return couponTransactionMapper.addCouponTransaction(couponTransaction);
	}

	@Override
	public int recordServiceTransaction(ServiceTransaction serviceTransaction) {
		return serviceTransactionMapper.addServiceTransaction(serviceTransaction);
	}

	@Override
	public int recordPromotionTransaction(PromotionTransaction promotionTransaction) {
		return promotionTransactionMapper.addPromotionTransaction(promotionTransaction);
	}

	@Override
	public int findOrderTransactionId(int orderId) {
		Integer orderTxnId = orderTransactionMapper.findOrderTransactionId(orderId);
		return orderTxnId != null ? orderTxnId.intValue() : 0;
	}

	@Override
	public int updateOrderTransactionAmount(int id, double amount) {
		return orderTransactionMapper.updateOrderTransactionAmount(id, amount);
	}

	@Override
	public int updateOrderTransactionByOrderId(OrderTransaction orderTransaction) {
		return orderTransactionMapper.updateOrderTransactionByOrderId(orderTransaction);
	}
}
