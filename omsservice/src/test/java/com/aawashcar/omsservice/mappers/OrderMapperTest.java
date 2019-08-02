package com.aawashcar.omsservice.mappers;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.omsservice.entities.Order;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderMapperTest {

	@Autowired
	private OrderMapper orderMapper;

	@Test
	public void testAddBalance() {
		int result = orderMapper.addOrder(generateOrder("order#1"));
		Assert.assertTrue(result == 1);
	}

	@Test
	public void testFindOrderByOrderNumber() {
		Order order = orderMapper.findOrderByOrderNumber("order#1");
		Assert.assertTrue(45 == order.getDiscountedPrice());
	}

	@Test
	public void testListOrdersByUserId() {
		int size = orderMapper.listOrdersByUserId(1).size();
		Assert.assertTrue(1 == size);
	}

	@Test
	public void testListLimitedOrdersForUser() {
		int size = orderMapper.listLimitedOrdersForUser(1, 5).size();
		Assert.assertTrue(1 == size);
	}

	@Test
	public void testListOrders() {
		int size = orderMapper.listOrders().size();
		Assert.assertTrue(1 == size);
	}

	@Test
	public void testModifyOrder() {
		Order order = orderMapper.listOrders().get(0);
		order.setDiscountedPrice(20d);
		int result = orderMapper.updateOrder(order);
		Assert.assertTrue(1 == result);
		Order updatedOrder = orderMapper.findOrderByOrderNumber("order#1");
		Assert.assertTrue(order.getDiscountedPrice() == updatedOrder.getDiscountedPrice());
	}

	@Test
	public void testRemoveOrderByOrderNumber() {
		int result = orderMapper.deleteOrderByOrderNumber("order#1");
		Assert.assertTrue(result == 1);
		Order order = orderMapper.findOrderByOrderNumber("order#1");
		Assert.assertNull(order);
	}

	private Order generateOrder(String orderNumber) {
		Order order = new Order();
		order.setBookTime(Timestamp.valueOf(LocalDateTime.now()));
		order.setCityId(1);
		order.setDiscountedPrice(45d);
		order.setDistrictId(1);
		order.setPrice(22d);
		order.setOrderNumber(orderNumber);
		order.setDetailLocation("aaa");
		order.setUserId(1);
		order.setServiceId("a");
		order.setVehicleId(1);
		order.setCompletedTime(Timestamp.valueOf(LocalDateTime.now()));
		order.setStatusCode(1);
		order.setResiQuartId(1);
		order.setRemarks("remarks");
		order.setInvoiceStatus(false);
		order.setCountyId(1);
		order.setProvinceId(1);
		return order;
	}
}
