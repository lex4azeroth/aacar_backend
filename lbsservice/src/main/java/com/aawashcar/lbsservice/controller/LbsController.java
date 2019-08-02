package com.aawashcar.lbsservice.controller;

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

import com.aawashcar.lbsservice.entities.Location;
import com.aawashcar.lbsservice.model.LocationModel;
import com.aawashcar.lbsservice.model.ModelConverter;
import com.aawashcar.lbsservice.service.LbsService;


@RequestMapping("/")
@ResponseBody
@Controller
public class LbsController {
	
	@Autowired
	private LbsService service;
	
	@RequestMapping(value="add", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public int makeOrder(@RequestBody LocationModel model) {
		Location location = ModelConverter.modelToEntity(model);
		return service.addLocation(location);
	}
	
	@RequestMapping(value="getLocationsByUserId/{userId}", method=RequestMethod.GET)
	public List<LocationModel> getLocationsByUserId(@PathVariable("userId") int userId) {
		List<Location> entities = service.findLocationByUserId(userId);
		return entities.stream().map(entity -> ModelConverter.entityToModel(entity)).collect(Collectors.toList());
	}
	
	@RequestMapping(value="getLocationsByOpenId/{openId}", method=RequestMethod.GET)
	public List<LocationModel> getLocationsByUserId(@PathVariable("openId") String openId) {
		List<Location> entities = service.findLocationByOpenId(openId);
		return entities.stream().map(entity -> ModelConverter.entityToModel(entity)).collect(Collectors.toList());
	}
	
	@RequestMapping(value="getLocationById/{id}", method=RequestMethod.GET)
	public LocationModel getLocationById(@PathVariable("id") int id) {
		Location entity = service.findLocationById(id);
		return ModelConverter.entityToModel(entity);
	}
	
	@RequestMapping(value="updateLocation", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public int updateLocation(@RequestBody LocationModel model) {
		Location location = ModelConverter.modelToEntity(model);
		return service.updateLocation(location);
	}
}
