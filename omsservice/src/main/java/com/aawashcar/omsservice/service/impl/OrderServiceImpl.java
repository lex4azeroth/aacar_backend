package com.aawashcar.omsservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aawashcar.omsservice.entities.Order;
import com.aawashcar.omsservice.entities.OrderSummary;
import com.aawashcar.omsservice.mappers.OrderMapper;
import com.aawashcar.omsservice.mappers.OrderStatusMapper;
import com.aawashcar.omsservice.mappers.OrderSummaryMapper;
import com.aawashcar.omsservice.model.OrderModel;
import com.aawashcar.omsservice.service.OrderService;

@Service()
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private OrderSummaryMapper orderSummaryMapper;
	
	@Autowired
	private OrderStatusMapper orderStatusMapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${mcw.service.ops.url.prefix}")
	protected String opsUrlPrefix;

	@Override
	public int newOrder(Order order) {
		String[] serviceIds = order.getServiceId().split(",");
		int length = serviceIds.length;
		StringBuilder sb = new StringBuilder();
		for (int index = 0; index < length; index++) {
			sb.append(serviceIds[index]);
		}
		String orderNumber = String.format("U%dS%sB%d", order.getUserId(), sb.toString(), System.currentTimeMillis());
		order.setOrderNumber(orderNumber);
		order.setStatusCode(Integer.valueOf(10)); // 待支付，由客户支付成功推动到下一步
		orderMapper.addOrder(order);
		return order.getId();
	}

	@Override
	public Order getLatestOrderByUser(int userId) {
		return orderMapper.findLatestOrderByUserId(userId);
	}

	@Override
	public List<OrderSummary> listMyOrderSummary(int userId, int limit) {
		return orderSummaryMapper.listMyOrderSummary(userId, limit);
	}

	@Override
	public Order findOrderById(int orderId) {
		return orderMapper.findOrderById(orderId);
	}

	@Override
	public String findStatusNameByCode(int code) {
		return orderStatusMapper.findOrderStatusNameByCode(code);
	}

	@Override
	public void updateOrderStatus(int orderId, int orderStatus) {
		orderMapper.updateOrderStatus(orderStatus, orderId);
	}

	@Override
	public void deleteOrderById(int id) {
		orderMapper.disableOrderById(id);
	}

	@Override
	public int updateOrder(Order order) {
		return orderMapper.updateOrder(order);
	}

	@Override
	public List<Order> listAllOrders() {
		return orderMapper.listOrders();
	}
	
	@Override
	public List<Order> listOrdersInDays(int days) {
		return orderMapper.listOrdersInDays(days);
	}

	@Override
	public boolean updateOrder(OrderModel order) {
//		couponId:0
//		detailLocation:""
//		discountedPrice:"22"
//		id:211
//		operatorId:1
//		price:50
//		promotionId:0
//		remarks:null
//		statusCode:-10
		Order entity = new Order();
		entity.setId(order.getId());
		entity.setCountyId(order.getCouponId());
		entity.setDetailLocation(order.getDetailLocation() == null ? null : order.getDetailLocation());
		entity.setDiscountedPrice(order.getDiscountedPrice());
		entity.setOperatorId(order.getOperatorId());
		entity.setPrice(order.getPrice());
		entity.setPromotionId(order.getPromotionId());
		entity.setRemarks(order.getRemarks() == null ? null : order.getRemarks());
		entity.setStatusCode(order.getStatusCode());
		entity.setBookTime(order.getBookTime());
		entity.setServiceId(order.getServiceId());
		entity.setOrderPhoneNumber(order.getOrderPhoneNumber() == null ? null : order.getOrderPhoneNumber());
		entity.setPaymentType(order.getPaymentType());
		int impactedOrder = orderMapper.updateOrder(entity);
		
		return impactedOrder == 1;
//		int vehicleId = orderMapper.findOrderById(order.getId()).getVehicleId();
//		
//		String url = opsUrlPrefix + "/vehicle/updatelicense/" + vehicleId + "/" + order.getLicense();
//		int impactedVehicle = restTemplate.exchange(url, HttpMethod.PUT, null, Integer.class).getBody().intValue();
//		return impactedOrder == impactedVehicle;
	}

	@Override
	public List<Order> listAvailableOrders(int size) {
		return orderMapper.listAvailableOrders(size);
	}
}
