package com.aawashcar.opsservice.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.opsservice.entities.Province;

@Mapper
public interface ProvinceMapper {
	
	int addProvince(Province province);
	
	Province findProvinceById(int provinceId);
	
	Province findProvinceByName(String name);
	
	int deleteProvinceById(int provinceId);
}
