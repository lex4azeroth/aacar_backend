package com.aawashcar.promservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aawashcar.promservice.entities.Points;
import com.aawashcar.promservice.mappers.PointsMapper;
import com.aawashcar.promservice.service.PointsService;

@Service
public class PointsServiceImpl implements PointsService {

	@Autowired
	private PointsMapper pointsMapper;
	
	@Override
	public int findPointIdByUserId(int userId) {
		Points points = pointsMapper.findPointsByUserId(userId);
		if (points != null) {
			return points.getId();
		}
		
		return 0;
	}

	@Override
	public int updatePointsByUserId(int userId, double points) {
		return pointsMapper.updatePointsOnly(userId, points);
	}

	@Override
	public List<Points> listUserPoints() {
		return pointsMapper.listPoints();
	}

	@Override
	public int disableUserPoints(int userId) {
		return pointsMapper.disableUserPoints(userId);
	}

	@Override
	public int addUserPoints(Points points) {
		return pointsMapper.addPoints(points);
	}

	@Override
	public int plusPoints(int userId, double pointsToAdd) {
		return pointsMapper.plusPoints(userId, pointsToAdd);
	}
}
