package com.aawashcar.promservice.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.promservice.entities.RUserConsumeService;

@Mapper
public interface RUserConsumeServiceMapper {
	
	int addRUserConsumeService(RUserConsumeService rUserConsumeService);
	
	RUserConsumeService findRUserConsumeServiceById(int id);
}
