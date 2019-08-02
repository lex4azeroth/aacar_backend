package com.aawashcar.opsservice.mappers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.opsservice.entities.VehicleType;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VehicleTypeMapperTest {

	@Autowired
	private VehicleTypeMapper vehicleTypeMapper;

	@Test
	public void testAddVehicleBrand() {
		int result = vehicleTypeMapper.addVehicleType(generateVehicleType());
		Assert.assertTrue(result == 1);
	}

	@Test
	public void testRemoveVehicle() {
		int id = vehicleTypeMapper.listVehicleTypes().get(0).getId();
		int result = vehicleTypeMapper.deleteVehicleTypeById(id);
		Assert.assertTrue(result == 1);
	}

	private VehicleType generateVehicleType() {
		VehicleType vehicleType = new VehicleType();
		vehicleType.setName("a");
		vehicleType.setDescription("bb");
		return vehicleType;
	}
}
