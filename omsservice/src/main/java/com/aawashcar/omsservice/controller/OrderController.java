package com.aawashcar.omsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aawashcar.omsservice.entities.Order;
import com.aawashcar.omsservice.entities.OrderSummary;
import com.aawashcar.omsservice.model.OrderModel;
import com.aawashcar.omsservice.service.OrderService;

@RequestMapping("order/")
@Controller
@ResponseBody
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="new", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public int makeOrder(@RequestBody Order order) {
		orderService.newOrder(order);
		return order.getId();
	}
	
	@RequestMapping(value="latest/{userid}", method=RequestMethod.GET)
	public Order latestOrder(@PathVariable("userid") int userId) {
		return orderService.getLatestOrderByUser(userId);
	}
	
	@RequestMapping(value="myordersummaries/{userid}/{limit}", method=RequestMethod.GET)
	public List<OrderSummary> listMyOrderSummaries(@PathVariable("userid") int userId, 
	                                               @PathVariable("limit") int limit) {
		return orderService.listMyOrderSummary(userId, limit);
	}
	
	@RequestMapping(value="detail/{orderid}", method=RequestMethod.GET)
	public Order getOrderDetail(@PathVariable("orderid") int orderId) {
		return orderService.findOrderById(orderId);
	}
	
	@RequestMapping(value="status/{statuscode}", method=RequestMethod.GET)
	public String getStatusName(@PathVariable("statuscode") int statusCode) {
		return orderService.findStatusNameByCode(statusCode);
	}
	
	@RequestMapping(value="udpatestatus/{orderid}/{statuscode}", method=RequestMethod.PUT)
	public int updateOrderStatus(@PathVariable("orderid") int orderId, 
	                              @PathVariable("statuscode") int statusCode) {
		orderService.updateOrderStatus(orderId, statusCode);
		return statusCode;
	}
	
	@RequestMapping(value="updateorder", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean updateOrderDetail(@RequestBody OrderModel order) {
		return orderService.updateOrder(order);
	}
	
	@RequestMapping(value="delete/{orderid}", method=RequestMethod.PUT)
	public boolean deleteOrder(@PathVariable("orderid") int orderId) {
		orderService.deleteOrderById(orderId);
		return true;
	}
	
	@RequestMapping(value="listallorders", method = RequestMethod.GET)
	public List<Order> listAllOrders() {
		return orderService.listAllOrders();
	}
	
	@RequestMapping(value="listordersindays/{days}", method = RequestMethod.GET)
	public List<Order> listOrdersInDays(@PathVariable("days") int days) {
		return orderService.listOrdersInDays(days);
	}
	
	@RequestMapping(value="availableorderlist/{size}", method = RequestMethod.GET)
	public List<Order> listAvailableOrders(@PathVariable("size") int size) {
		return orderService.listAvailableOrders(size);
	}
}
