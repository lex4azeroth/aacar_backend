package com.aawashcar.capservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aawashcar.capservice.entities.Capability;
import com.aawashcar.capservice.entities.CapabilityType;
import com.aawashcar.capservice.entities.Material;
import com.aawashcar.capservice.model.CapabilityModel;
import com.aawashcar.capservice.model.CapabilityTypeModel;
import com.aawashcar.capservice.model.MaterialModel;
import com.aawashcar.capservice.model.ModelConverter;
import com.aawashcar.capservice.service.CapabilityMaterialService;
import com.aawashcar.capservice.service.CapabilityService;
import com.aawashcar.capservice.service.CapabilityTypeService;

@RequestMapping("/")
@ResponseBody
@Controller
public class CapabilityController {
	
	@Autowired
	private CapabilityService capabilityService;
	
	@Autowired
	private CapabilityTypeService capabilityTypeService;
	
	@Autowired
	private CapabilityMaterialService materialService;
	
	@RequestMapping(value="capability/{id}", method=RequestMethod.GET)
	public CapabilityModel findCapability(@PathVariable int id) {
		Capability entity =  capabilityService.findCapability(id);
		return ModelConverter.entityToModel(entity);
	}
	
	@RequestMapping(value="capabilityname/{id}", method=RequestMethod.GET)
	public String findCapabilityName(@PathVariable int id) {
		Capability entity =  capabilityService.findCapability(id);
		return entity.getName();
	}
	
	@RequestMapping(value="addCapability", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public int addCapability(@RequestBody CapabilityModel model) {
		Capability entity = ModelConverter.modelToEnitty(model);
		return capabilityService.addCapability(entity);
	}
	
	@RequestMapping(value="capabilities", method=RequestMethod.GET)
	public List<CapabilityModel> getCapabilities() {
		List<Capability> entities = capabilityService.findCapabilities();
		return entities.stream().map(entity -> ModelConverter.entityToModel(entity)).collect(Collectors.toList());
	}
	
	@RequestMapping(value="updateCapability", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public int updateCapability(@RequestBody CapabilityModel model) {
		Capability entity = ModelConverter.modelToEnitty(model);
		return capabilityService.updateCapability(entity);
	}
	
	@RequestMapping(value="addCapabilityType", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public int addCapabilityType(@RequestBody CapabilityTypeModel model) {
		CapabilityType entity = ModelConverter.modelToEnitty(model);
		return capabilityTypeService.addCapabilityType(entity);
	}
	
	@RequestMapping(value="capabilityTypes", method=RequestMethod.GET)
	public List<CapabilityTypeModel> getCapabilityTypes() {
		List<CapabilityType> entities = capabilityTypeService.findCapabilityTypies();
		return entities.stream().map(entity -> ModelConverter.entityToModel(entity)).collect(Collectors.toList());
	}
	
	@RequestMapping(value="updateCapabilityType", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public int updateCapabilityType(@RequestBody CapabilityTypeModel model) {
		CapabilityType entity = ModelConverter.modelToEnitty(model);
		return capabilityTypeService.updateCapabilityType(entity);
	}
	
	@RequestMapping(value="addMaterial", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public int addMaterial(@RequestBody MaterialModel model) {
		Material entity = ModelConverter.modelToEnitty(model);
		return materialService.addMaterial(entity);
	}
	
	@RequestMapping(value="material", method=RequestMethod.GET)
	public MaterialModel getMaterials(int id) {
		Material entity = materialService.findMaterialById(id);
		return ModelConverter.entityToModel(entity);
	}
	
	@RequestMapping(value="updateMaterial", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public int updateMaterial(@RequestBody MaterialModel model) {
		Material entity = ModelConverter.modelToEnitty(model);
		return materialService.updateMaterial(entity);
	}
}
