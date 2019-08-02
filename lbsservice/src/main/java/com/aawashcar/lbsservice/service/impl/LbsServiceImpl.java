package com.aawashcar.lbsservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aawashcar.lbsservice.entities.Location;
import com.aawashcar.lbsservice.mappers.LocationMapper;
import com.aawashcar.lbsservice.service.LbsService;

@Service
public class LbsServiceImpl implements LbsService {
	
	@Autowired
	private LocationMapper mapper;

	@Override
	public int addLocation(Location location) {
		mapper.addLocation(location);
		System.out.println("new location id " + location.getId());
		return location.getId();
	}

	@Override
	public List<Location> findLocationByUserId(int userId) {
		return mapper.findLocationByUserId(userId);
	}

	@Override
	public List<Location> findLocationByOpenId(String openId) {
		return mapper.findLocationByOpenId(openId);
	}

	@Override
	public int updateLocation(Location location) {
		int result = 0;
		if (location.getUserId() != null) {
			result = mapper.updateLocationByUserId(location);
		} else if (location.getOpenId() != null) {
			result = mapper.updateLocationByOpenId(location);
		}
		return result;
	}

	@Override
	public Location findLocationById(int id) {
		return mapper.findLocationById(id);
	}
}
