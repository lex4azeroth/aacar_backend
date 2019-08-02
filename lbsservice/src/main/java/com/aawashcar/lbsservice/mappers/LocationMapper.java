package com.aawashcar.lbsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.lbsservice.entities.Location;

@Mapper
public interface LocationMapper {
	
	int addLocation(Location location);
	
	List<Location> findLocationByUserId(int userId);
	
	List<Location> findLocationByOpenId(String openId);
	
	int updateLocationByOpenId(Location location);
	
	int updateLocationByUserId(Location location);
	
	Location findLocationById(int id);
}
