package com.aawashcar.capservice.service;

import com.aawashcar.capservice.entities.Material;


public interface CapabilityMaterialService {
	
	int addMaterial(Material material);
	
	Material findMaterialById(int id);
	
	int updateMaterial(Material material);
}
