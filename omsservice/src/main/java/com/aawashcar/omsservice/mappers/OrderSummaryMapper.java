package com.aawashcar.omsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.omsservice.entities.Order;
import com.aawashcar.omsservice.entities.OrderSummary;

@Mapper
public interface OrderSummaryMapper {

	List<OrderSummary> listMyOrderSummary(@Param("userId") int userId, @Param("limit") int limit);
}
