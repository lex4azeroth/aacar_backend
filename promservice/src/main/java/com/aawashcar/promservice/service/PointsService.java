package com.aawashcar.promservice.service;

import java.util.List;

import com.aawashcar.promservice.entities.Points;

public interface PointsService {
	
	int addUserPoints(Points points);
	
	int findPointIdByUserId(int userId);
	
	int updatePointsByUserId(int userId, double points);
	
	int plusPoints(int userId, double pointsToAdd);
	
	List<Points> listUserPoints();
	
	int disableUserPoints(int userId);

}
