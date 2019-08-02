package com.aawashcar.lbsservice.service;

import java.util.List;

import com.aawashcar.lbsservice.entities.Location;


public interface LbsService {
	
	int addLocation(Location location);
	
	List<Location> findLocationByUserId(int userId);
	
	List<Location> findLocationByOpenId(String openId);
	
	int updateLocation(Location location);
	
	Location findLocationById(int id);
}
