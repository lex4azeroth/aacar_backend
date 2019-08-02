package com.aawashcar.capservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aawashcar.capservice.entities.CapabilityType;
import com.aawashcar.capservice.mappers.CapabilityTypeMapper;
import com.aawashcar.capservice.service.CapabilityTypeService;

@Service
public class CapabilityTypeServiceImpl implements CapabilityTypeService {

	@Autowired
	private CapabilityTypeMapper mapper;
	
	@Override
	public int addCapabilityType(CapabilityType capabilityType) {
		return mapper.addCapabilityType(capabilityType);
	}

	@Override
	public List<CapabilityType> findCapabilityTypies() {
		return mapper.findCapabilityTypes();
	}

	@Override
	public int updateCapabilityType(CapabilityType capabilityType) {
		return mapper.addCapabilityType(capabilityType);
	}
}
