package com.aawashcar.opsservice.mappers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.opsservice.entities.VehicleBrand;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VehicleBrandMapperTest {

	@Autowired
	private VehicleBrandMapper vehicleBrandMapper;

	@Test
	public void testAddVehicleBrand() {
		int result = vehicleBrandMapper.addVehicleBrand(generateVehicleBrand());
		Assert.assertTrue(result == 1);
	}

	@Test
	public void testRemoveVehicle() {
		int id = vehicleBrandMapper.listVehicleBrands().get(0).getId();
		int result = vehicleBrandMapper.deleteVehicleBrandById(id);
		Assert.assertTrue(result == 1);
	}

	private VehicleBrand generateVehicleBrand() {
		VehicleBrand vehicleBrand = new VehicleBrand();
		vehicleBrand.setBrand("a");
		vehicleBrand.setDescription("bb");
		vehicleBrand.setNickName("cc");
		return vehicleBrand;
	}
}
