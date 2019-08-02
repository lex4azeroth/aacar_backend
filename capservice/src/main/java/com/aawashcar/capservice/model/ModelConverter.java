package com.aawashcar.capservice.model;

import com.aawashcar.capservice.entities.Capability;
import com.aawashcar.capservice.entities.CapabilityType;
import com.aawashcar.capservice.entities.Material;

public class ModelConverter {
	
	public static Capability modelToEnitty(CapabilityModel model) {
		Capability entity = new Capability();
		
		if (model.getId() != null) {
			entity.setId(model.getId());
		}
		
		entity.setEnabled(model.isEnabled() != null ? model.isEnabled() : true);
		entity.setCleanningPart(model.getCleanningPart());
		entity.setConsumables(model.getConsumables());
		entity.setDescription(model.getDescription());
		entity.setIconUrl(model.getIconUrl());
		entity.setModifiedTime(model.getModifiedTime());
		entity.setName(model.getName());
		entity.setServiceId(model.getServiceId());
		entity.setStandard(model.getStandard());
		entity.setTimeConsuming(model.getTimeConsuming());
		entity.setCreatedTime(model.getCreatedTime());
		entity.setCategoryId(model.getCategoryId());
		entity.setCategoryName(model.getCategoryName());
		entity.setCategoryUrl(model.getCategoryUrl());
		return entity;
	}
	
	public static CapabilityType modelToEnitty(CapabilityTypeModel model) {
		CapabilityType entity = new CapabilityType();
		
		if (model.getId() != null) {
			entity.setId(model.getId());
		}
		
		entity.setEnabled(model.isEnabled() != null ? model.isEnabled() : true);
		entity.setCreatedTime(model.getCreatedTime());
		entity.setDescription(model.getDescription());
		entity.setModifiedTime(model.getModifiedTime());
		entity.setName(model.getName());
		entity.setTypeId(model.getTypeId());
		return entity;
	}
	
	public static Material modelToEnitty(MaterialModel model) {
		Material entity = new Material();
		
		if (model.getId() != null) {
			entity.setId(model.getId());
		}
		
		entity.setEnabled(model.isEnabled() != null ? model.isEnabled() : true);
		entity.setCreatedTime(model.getCreatedTime());
		entity.setDescription(model.getDescription());
		entity.setIconUrl(model.getIconUrl());
		entity.setModifiedTime(model.getModifiedTime());
		entity.setName(model.getName());
		return entity;
	}
	
	public static CapabilityModel entityToModel(Capability entity) {
		CapabilityModel model = new CapabilityModel();
		model.setCleanningPart(entity.getCleanningPart());
		model.setConsumables(entity.getConsumables());
		model.setCreatedTime(entity.getCreatedTime());
		model.setDescription(entity.getDescription());
		model.setEnabled(entity.isEnabled());
		model.setIconUrl(entity.getIconUrl());
		model.setId(entity.getId());
		model.setModifiedTime(entity.getModifiedTime());
		model.setName(entity.getName());
		model.setServiceId(entity.getServiceId());
		model.setStandard(entity.getStandard());
		model.setTimeConsuming(entity.getTimeConsuming());
		model.setCategoryId(entity.getCategoryId());
		model.setCategoryName(entity.getCategoryName());
		model.setCategoryUrl(entity.getCategoryUrl());
		return model;
	}
	
	public static CapabilityTypeModel entityToModel(CapabilityType entity) {
		CapabilityTypeModel model = new CapabilityTypeModel();
		model.setCreatedTime(entity.getCreatedTime());
		model.setDescription(entity.getDescription());
		model.setEnabled(entity.isEnabled());
		model.setId(entity.getId());
		model.setModifiedTime(entity.getModifiedTime());
		model.setName(entity.getName());
		model.setTypeId(entity.getTypeId());
		return model;
	}

	public static MaterialModel entityToModel(Material entity) {
		MaterialModel model = new MaterialModel();
		model.setCreatedTime(entity.getCreatedTime());
		model.setDescription(entity.getDescription());
		model.setEnabled(entity.isEnabled());
		model.setIconUrl(entity.getIconUrl());
		model.setId(entity.getId());
		model.setModifiedTime(entity.getModifiedTime());
		model.setName(entity.getName());
		return model;
	}
}
