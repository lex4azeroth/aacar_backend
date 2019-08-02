package com.aawashcar.opsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.opsservice.entities.VehicleBrand;

@Mapper
public interface VehicleBrandMapper {
	
	int addVehicleBrand(VehicleBrand brand);
	
	int deleteVehicleBrandById(int brandId);
	
	List<VehicleBrand> listVehicleBrands();
}
