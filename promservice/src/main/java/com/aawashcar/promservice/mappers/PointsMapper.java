package com.aawashcar.promservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.promservice.entities.Points;

@Mapper
public interface PointsMapper {
	
	int addPoints(Points points);
	
	int plusPoints(@Param("userId") int userId, @Param("pointsToAdd") double pointsToAdd);
	
	int updateUserPoints(Points points);
		
	List<Points> listPoints();
	
	Points findPointsById(int id);
	
	Points findPointsByUserId(int userId);
	
	int disableUserPoints(int userId);
	
	int updatePointsOnly(@Param("userId") int userId, @Param("points") double points);
}
