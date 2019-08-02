package com.aawashcar.capservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.capservice.entities.Capability;

@Mapper
public interface CapabilityMapper {
	
	int addCapability(Capability capability);
	
	List<Capability> findCapabilities();
	
	Capability findCapability(int id);
	
	int updateCapability(Capability capability);
}
