package com.aawashcar.opsservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aawashcar.opsservice.entities.Vehicle;
import com.aawashcar.opsservice.entities.VehicleCategory;
import com.aawashcar.opsservice.entities.VehicleType;
import com.aawashcar.opsservice.mappers.VehicleCategoryMapper;
import com.aawashcar.opsservice.mappers.VehicleMapper;
import com.aawashcar.opsservice.mappers.VehicleTypeMapper;
import com.aawashcar.opsservice.service.VehicleService;

@Service()
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleCategoryMapper vehicleCategoryMapper;

	@Autowired
	private VehicleTypeMapper vehicleTypeMapper;

	@Autowired
	private VehicleMapper vehicleMapper;

	@Override
	public List<VehicleCategory> listCategories() {
		return vehicleCategoryMapper.listVehicleCategorys();
	}

	@Override
	public List<VehicleType> listTypes() {
		return vehicleTypeMapper.listVehicleTypes();
	}

	@Override
	public Vehicle findVehicle(int id) {
		return vehicleMapper.findVehicleById(id);
	}

	@Override
	public int newVehicle(Vehicle vehicle) {
		vehicleMapper.addVehicle(vehicle);
		return vehicle.getId();
	}

	@Override
	public Vehicle findVehicleByLicense(String license) {
		return vehicleMapper.findVehicleByLicense(license);
	}

	@Override
	public VehicleCategory findVehicleCategoryById(int id) {
		return vehicleCategoryMapper.findVehicleCategoryById(id);
	}

	@Override
	public VehicleType findVehicleTypeById(int id) {
		return vehicleTypeMapper.findVehicleTypeById(id);
	}

	@Override
	public VehicleCategory findCategoryByVehicleId(int id) {
		return vehicleCategoryMapper.findCategoryByVehicleId(id);
	}

	@Override
	public VehicleType findTypeByVehicleId(int id) {
		return vehicleTypeMapper.findTypeByVehicleId(id);
	}

	@Override
	public int updateVehicle(Vehicle vehicle) {
		return vehicleMapper.updateVehicle(vehicle);
	}
}
