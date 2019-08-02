package com.aawashcar.opsservice.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.opsservice.entities.Location;

@Mapper
public interface LocationMapper {
	
	int addLocation(Location location);
	
	Location findLocationById(int id);
	
	void updateLocation(Location location);
}
