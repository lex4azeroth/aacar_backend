package com.aawashcar.crmservice.mappers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.crmservice.entities.RUserUuid;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RUserUuidMapperTest {

	@Autowired
	private RUserUuidMapper rUserUuidMapper;

	@Test
	public void testAddUser() {
		int result = rUserUuidMapper.addUserUuidPair(generateRUserUuid());
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void testFindRUserUuidByUuid() {
		RUserUuid rUserUuid = rUserUuidMapper.findRUserUuidByUuid("uuid-test-2048");
		Assert.assertTrue(2048 == rUserUuid.getUserId());
	}

	private RUserUuid generateRUserUuid() {
		RUserUuid rUserUuid = new RUserUuid();
		rUserUuid.setUserId(2048);
		rUserUuid.setUuid("uuid-test-2048");
		return rUserUuid;
	}
}
