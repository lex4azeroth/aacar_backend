package com.aawashcar.capservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.capservice.entities.CapabilityType;

@Mapper
public interface CapabilityTypeMapper {
	
	int addCapabilityType(CapabilityType capabilityType);
	
	List<CapabilityType> findCapabilityTypes();
	
	int updateCapabilityType(CapabilityType capabilityType);
}
