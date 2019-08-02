package com.aawashcar.capservice.service;

import java.util.List;

import com.aawashcar.capservice.entities.CapabilityType;

public interface CapabilityTypeService {
	int addCapabilityType(CapabilityType capabilityType);
	
	List<CapabilityType> findCapabilityTypies();
	
	int updateCapabilityType(CapabilityType capabilityType);
}
