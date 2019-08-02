package com.aawashcar.opsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.opsservice.entities.VehicleCategory;

@Mapper
public interface VehicleCategoryMapper {
	
	int addVehicleCategory(VehicleCategory category);
	
	int deleteVehicleCategoryById(int categoryId);
	
	VehicleCategory findVehicleCategoryById(int id);
	
	VehicleCategory findCategoryByVehicleId(@Param("vehicleId") int id);
	
	List<VehicleCategory> listVehicleCategorys();
}
