package com.aawashcar.omsservice.service;

import java.util.List;

import com.aawashcar.omsservice.entities.Order;
import com.aawashcar.omsservice.entities.OrderSummary;
import com.aawashcar.omsservice.model.OrderModel;

public interface OrderService {
	
	int newOrder(Order order);
	
	Order getLatestOrderByUser(int userId);
	
	List<OrderSummary> listMyOrderSummary(int userId, int limit);
	
	Order findOrderById(int orderId);
	
	String findStatusNameByCode(int code);
	
	void updateOrderStatus(int orderId, int orderStatus);
	
	int updateOrder(Order order);
	
	boolean updateOrder(OrderModel order);
	
	void deleteOrderById(int id);
	
	List<Order> listAllOrders();
	
	List<Order> listOrdersInDays(int days);
	
	List<Order> listAvailableOrders(int size);
}
