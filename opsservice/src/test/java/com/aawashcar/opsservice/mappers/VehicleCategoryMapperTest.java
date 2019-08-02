package com.aawashcar.opsservice.mappers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.opsservice.entities.VehicleCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VehicleCategoryMapperTest {

	@Autowired
	private VehicleCategoryMapper vehicleCategoryMapper;

	@Test
	public void testAddVehicleBrand() {
		int result = vehicleCategoryMapper.addVehicleCategory(generateVehicleCategory());
		Assert.assertTrue(result == 1);
	}

	@Test
	public void testRemoveVehicle() {
		int id = vehicleCategoryMapper.listVehicleCategorys().get(0).getId();
		int result = vehicleCategoryMapper.deleteVehicleCategoryById(id);
		Assert.assertTrue(result == 1);
	}

	private VehicleCategory generateVehicleCategory() {
		VehicleCategory vehicleCategory = new VehicleCategory();
		vehicleCategory.setName("a");
		vehicleCategory.setDescription("bb");
		return vehicleCategory;
	}
}
