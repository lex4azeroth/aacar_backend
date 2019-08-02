package com.aawashcar.omsservice.mappers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.omsservice.entities.OrderStatus;
import com.aawashcar.omsservice.entities.OrderStatusCode;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderStatuMapperTest {

	@Autowired
	private OrderStatusMapper orderStatusMapper;

	@Test
	public void testAddOrderStatus() {
		int result = orderStatusMapper.addOrderStatus(generateOrderStatus());
		Assert.assertTrue(result == 1);
	}

	@Test
	public void testListOrderStatus() {
		OrderStatus orderStatus = orderStatusMapper.listOrderStatus().get(0);
		Assert.assertTrue(30 == orderStatus.getStatusCode());
	}

	@Test
	public void testModifyOrderStatus() {
		int result = orderStatusMapper.updateOrderStatusEnabledByCode(OrderStatusCode.IN_PROGRESS.getStatus(), false);
		Assert.assertTrue(1 == result);
		OrderStatus orderStatus = orderStatusMapper.listOrderStatus().get(0);
		Assert.assertFalse(orderStatus.isEnabled());
	}

	@Test
	public void testRemoveOrderStatusByCode() {
		int result = orderStatusMapper.deleteOrderStatusByCode(OrderStatusCode.IN_PROGRESS.getStatus());
		Assert.assertTrue(1 == result);
		int size = orderStatusMapper.listOrderStatus().size();
		Assert.assertTrue(0 == size);
	}

	private OrderStatus generateOrderStatus() {
		OrderStatus orderStatus = new OrderStatus();
		orderStatus.setDescription("Order Status is In progress");
		orderStatus.setEnabled(true);
		orderStatus.setName(OrderStatusCode.IN_PROGRESS.name());
		orderStatus.setStatusCode(OrderStatusCode.IN_PROGRESS.getStatus());
		return orderStatus;
	}
}
