package com.aawashcar.opsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.opsservice.entities.District;

@Mapper
public interface DistrictMapper {

	int addDistrict(District district);
	
	District findDistrictById(int districtId);
	
	District findDistrictByName(String name);
	
	List<District> listDistricts(@Param("provinceId") int provinceId, @Param("cityId") int cityId);
	
	int deleteDistrictById(int districtId);
}
