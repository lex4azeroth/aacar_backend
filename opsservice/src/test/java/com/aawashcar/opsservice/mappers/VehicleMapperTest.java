package com.aawashcar.opsservice.mappers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.opsservice.entities.Vehicle;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VehicleMapperTest {

	@Autowired
	private VehicleMapper vehicleMapper;

	@Test
	public void testAddService() {
		int result = vehicleMapper.addVehicle(generateVehicle());
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void testFindVehicleByLicense() {
		Vehicle vehicle = vehicleMapper.findVehicleByLicense("aaa");
		Assert.assertEquals("red", vehicle.getColor());
	}
	
	@Test
	public void testListVehicles() {
		int size = vehicleMapper.listVehicles().size();
		Assert.assertTrue(size > 0);
	}
	
	@Test
	public void testRemoveVehicle() {
		int result = vehicleMapper.deleteVehicleByLicense("aaa");
		Assert.assertTrue(result == 1);
		Vehicle vehicle = vehicleMapper.findVehicleByLicense("aaa");
		Assert.assertNull(vehicle);
	}

	private Vehicle generateVehicle() {
		Vehicle vehicle = new Vehicle();
		vehicle.setBrandId(1);
		vehicle.setCategoryId(1);
		vehicle.setColor("red");
		vehicle.setDefaultLocation("somewhere");
		vehicle.setLicense("aaa");
		return vehicle;
	}
}
