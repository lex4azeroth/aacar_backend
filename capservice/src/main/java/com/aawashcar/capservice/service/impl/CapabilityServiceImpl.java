package com.aawashcar.capservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aawashcar.capservice.entities.Capability;
import com.aawashcar.capservice.mappers.CapabilityMapper;
import com.aawashcar.capservice.service.CapabilityService;

@Service
public class CapabilityServiceImpl implements CapabilityService {

	@Autowired
	private CapabilityMapper mapper;
	
	@Override
	public int addCapability(Capability capability) {
		return mapper.addCapability(capability);
	}

	@Override
	public List<Capability> findCapabilities() {
		return mapper.findCapabilities();
	}

	@Override
	public int updateCapability(Capability capability) {
		return mapper.updateCapability(capability);
	}

	@Override
	public Capability findCapability(int id) {
		return mapper.findCapability(id);
	}

}
