package com.aawashcar.opsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.opsservice.entities.Vehicle;

@Mapper
public interface VehicleMapper {
	
	int addVehicle(Vehicle vehicle);
	
	Vehicle findVehicleByLicense(String license);
	
	Vehicle findVehicleById(int id);
	
	List<Vehicle> listVehicles();
	
	int deleteVehicleByLicense(String license);
	
	int updateVehicle(Vehicle vehicle);
}
