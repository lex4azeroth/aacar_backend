package com.aawashcar.opsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.opsservice.entities.ResidentialQuarter;

@Mapper
public interface ResidentialQuarterMapper {

	int addResidentialQuarter(ResidentialQuarter residentialQuarter);

	ResidentialQuarter findResidentialQuarterById(int residentialQuarterId);
	
	ResidentialQuarter findResidentialQuarterByName(String name);
	
	List<ResidentialQuarter> listResidentialQuarter(@Param("provinceId") int provinceId, @Param("cityId") int cityId, @Param("districtId") int districtId);

	int deleteResidentialQuarterById(int residentialQuarterId);
}
