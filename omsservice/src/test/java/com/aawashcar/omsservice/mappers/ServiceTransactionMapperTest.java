package com.aawashcar.omsservice.mappers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.omsservice.entities.ServiceTransaction;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceTransactionMapperTest {

	@Autowired
	private ServiceTransactionMapper serviceTransactionMapper;

	@Test
	public void testAddOrderTransaction() {
		int result = serviceTransactionMapper.addServiceTransaction(generateServiceTransaction());
		Assert.assertTrue(result == 1);
	}

	@Test
	public void testListServiceTransactions() {
		ServiceTransaction serviceTransaction = serviceTransactionMapper.listServiceTransactions().get(0);
		Assert.assertTrue(1 == serviceTransaction.getServiceId());
	}

	@Test
	public void testRemoveOrderTransactionByOrderId() {
		int id = serviceTransactionMapper.listServiceTransactions().get(0).getId();
		int result = serviceTransactionMapper.disableServiceTransactionById(id);
		Assert.assertTrue(1 == result);
		int size = serviceTransactionMapper.listServiceTransactions().size();
		Assert.assertTrue(0 == size);
	}

	private ServiceTransaction generateServiceTransaction() {
		ServiceTransaction serviceTransaction = new ServiceTransaction();
		serviceTransaction.setServiceId(1);
		serviceTransaction.setUserId(1);
		return serviceTransaction;
	}
}
