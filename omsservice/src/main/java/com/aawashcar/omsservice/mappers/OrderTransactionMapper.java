package com.aawashcar.omsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.omsservice.entities.OrderTransaction;

@Mapper
public interface OrderTransactionMapper {
	
	int addOrderTransaction(OrderTransaction orderTransaction);
	
	OrderTransaction findOrderTransactionByOrderId(int orderId);
	
	List<OrderTransaction> listOrderTransactions();
	
	int disableOrderTransactionByOrderId(int orderId);
	
	int updateOrderTransactionByOrderId(OrderTransaction orderTransaction);
	
	Integer findOrderTransactionId(int orderId);
	
	int updateOrderTransactionAmount(@Param("id") int id, @Param("amount") double amount);
}
