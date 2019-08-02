package com.aawashcar.omsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.omsservice.entities.OrderStatus;

@Mapper
public interface OrderStatusMapper {
	
	int addOrderStatus(OrderStatus orderStatus);
	
	int updateOrderStatusEnabledByCode(@Param("statusCode") int statusCode, @Param("enabled") boolean enabled);
	
	List<OrderStatus> listOrderStatus();
	
	String findOrderStatusNameByCode(@Param("statusCode") int statusCode);
	
	int deleteOrderStatusByCode(int statusCode);
}
