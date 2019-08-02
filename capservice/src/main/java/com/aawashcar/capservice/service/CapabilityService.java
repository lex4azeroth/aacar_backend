package com.aawashcar.capservice.service;

import java.util.List;

import com.aawashcar.capservice.entities.Capability;

public interface CapabilityService {
	
	int addCapability(Capability capability);
	
	List<Capability> findCapabilities();
	
	Capability findCapability(int id);
	
	int updateCapability(Capability capability);

}
