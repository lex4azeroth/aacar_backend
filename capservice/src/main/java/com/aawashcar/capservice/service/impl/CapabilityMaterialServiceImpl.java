package com.aawashcar.capservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aawashcar.capservice.entities.Material;
import com.aawashcar.capservice.mappers.MaterialMapper;
import com.aawashcar.capservice.service.CapabilityMaterialService;

@Service
public class CapabilityMaterialServiceImpl implements CapabilityMaterialService {

	@Autowired
	private MaterialMapper mapper;
	
	@Override
	public int addMaterial(Material material) {
		return mapper.addMaterial(material);
	}

	@Override
	public Material findMaterialById(int id) {
		return mapper.findMaterialById(id);
	}

	@Override
	public int updateMaterial(Material material) {
		return mapper.updateMaterial(material);
	}

}
