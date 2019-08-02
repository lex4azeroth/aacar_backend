package com.aawashcar.opsservice.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.opsservice.entities.County;

@Mapper
public interface CountyMapper {

	int addCounty(County county);

	County findCountyById(int countyId);
	
	County findCountyByName(String name);

	int deleteCountyById(int countyId);
}
