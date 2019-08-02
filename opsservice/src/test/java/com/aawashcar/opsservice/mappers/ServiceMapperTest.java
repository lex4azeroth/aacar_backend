package com.aawashcar.opsservice.mappers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.opsservice.entities.WashCarService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceMapperTest {

	@Autowired
	private ServiceMapper serviceMapper;

	@Test
	public void testAddService() {
		serviceMapper.addService(generateService());
		serviceMapper.addService(generateService());
	}

	@Test
	public void testUpdateStatus() {
		int id = serviceMapper.listServices().get(0).getId();
		serviceMapper.updateServiceStatus(id, false);
		Assert.assertFalse(serviceMapper.listServices().get(0).isEnabled());
	}

	private WashCarService generateService() {
		WashCarService service = new WashCarService();
		service.setDescription("全车洗");
		service.setName("全车洗");
		service.setEnabled(true);
		return service;
	}
}
