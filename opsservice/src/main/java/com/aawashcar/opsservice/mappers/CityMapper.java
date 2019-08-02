package com.aawashcar.opsservice.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.opsservice.entities.City;

@Mapper
public interface CityMapper {
	
	int addCity(City city);
	
	int deleteCityById(int cityId);
	
	City findCityById(int cityId);
	
	City findCityByName(String name);
}
