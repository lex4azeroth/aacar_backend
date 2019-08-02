package com.aawashcar.omsservice.mappers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.omsservice.entities.Balance;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BalanceMapperTest {

	@Autowired
	private BalanceMapper balanceMapper;

	@Test
	public void testAddBalance() {
		int result = balanceMapper.addBalance(generateBalance());
		Assert.assertTrue(result == 1);
	}

	@Test
	public void testFindBalanceByUserId() {
		Balance balance = balanceMapper.findBalanceByUserId(1);
		Assert.assertTrue(11.1 == balance.getBalance());
	}

	@Test
	public void testRemoveBalanceByUserId() {
		int result = balanceMapper.deleteBalanceByUserId(1);
		Assert.assertTrue(result == 1);
		Balance balance = balanceMapper.findBalanceByUserId(1);
		Assert.assertNull(balance);
	}

	private Balance generateBalance() {
		Balance balance = new Balance();
		balance.setBalance(11.1);
		balance.setUserId(1);
		return balance;
	}
}
