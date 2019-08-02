package com.aawashcar.omsservice.mappers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.omsservice.entities.OrderTransaction;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderTransactionMapperTest {

	@Autowired
	private OrderTransactionMapper orderTransactionMapper;

	@Test
	public void testAddOrderTransaction() {
		int result = orderTransactionMapper.addOrderTransaction(generateOrderTransaction());
		Assert.assertTrue(result == 1);
	}

	@Test
	public void testListOrderTransactions() {
		OrderTransaction orderTransaction = orderTransactionMapper.listOrderTransactions().get(0);
		Assert.assertTrue(1 == orderTransaction.getOrderId());
	}

	@Test
	public void testFindOrderTransactionByOrderId() {
		OrderTransaction orderTransaction = orderTransactionMapper.findOrderTransactionByOrderId(1);
		Assert.assertTrue(30 == orderTransaction.getAmount());
	}

	@Test
	public void testRemoveOrderTransactionByOrderId() {
		int result = orderTransactionMapper.disableOrderTransactionByOrderId(1);
		Assert.assertTrue(1 == result);
		int size = orderTransactionMapper.listOrderTransactions().size();
		Assert.assertTrue(0 == size);
	}

	private OrderTransaction generateOrderTransaction() {
		OrderTransaction orderTransaction = new OrderTransaction();
		orderTransaction.setAmount(30d);
		orderTransaction.setOrderId(1);
		return orderTransaction;
	}
}
