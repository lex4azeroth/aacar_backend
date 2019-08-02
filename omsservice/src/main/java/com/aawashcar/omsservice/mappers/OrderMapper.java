package com.aawashcar.omsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.omsservice.entities.Order;

@Mapper
public interface OrderMapper {
	
	int addOrder(Order order);
	
	Order findOrderByOrderNumber(String orderNumber);
	
	Order findOrderById(int id);
	
	Order findLatestOrderByUserId(int userId);
	
	List<Order> listOrdersByUserId(int userId);
	
	List<Order> listLimitedOrdersForUser(@Param("userId") int userId, @Param("count") int count);
	
	List<Order> listOrders();
	
	List<Order> listAvailableOrders(int size);
	
	List<Order> listOrdersInDays(int days);
	
	int updateOrder(Order order); // Not allowed to update: userId, orderNumber, province_id, county_id, city_id,
	
	int deleteOrderByOrderNumber(String orderNumber);
	
	void disableOrderById(int id);
	
	void updateOrderStatus(@Param("statusCode") int statusCode, @Param("orderId") int orderId);
}
