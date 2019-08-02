package com.aawashcar.opsservice.service;

import java.util.List;

import com.aawashcar.opsservice.entities.Vehicle;
import com.aawashcar.opsservice.entities.VehicleCategory;
import com.aawashcar.opsservice.entities.VehicleType;

public interface VehicleService {

	List<VehicleCategory> listCategories();
	
	VehicleCategory findVehicleCategoryById(int id);
	
	VehicleType findVehicleTypeById(int id);
	
	VehicleCategory findCategoryByVehicleId(int id);
	
	VehicleType findTypeByVehicleId(int id);
	
	List<VehicleType> listTypes();
	
	Vehicle findVehicle(int id);
	
	Vehicle findVehicleByLicense(String license);
	
	int newVehicle(Vehicle vehicle);
	
	int updateVehicle(Vehicle vehicle);
}
