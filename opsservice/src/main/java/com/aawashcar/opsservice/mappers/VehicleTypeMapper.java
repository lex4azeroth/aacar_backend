package com.aawashcar.opsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.opsservice.entities.VehicleType;

@Mapper
public interface VehicleTypeMapper {

	int addVehicleType(VehicleType type);

	int deleteVehicleTypeById(int typeId);
	
	VehicleType findVehicleTypeById(int id);
	
	VehicleType findTypeByVehicleId(@Param("vehicleId") int id);

	List<VehicleType> listVehicleTypes();
}
