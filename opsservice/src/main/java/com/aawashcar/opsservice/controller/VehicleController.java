package com.aawashcar.opsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aawashcar.opsservice.entities.Vehicle;
import com.aawashcar.opsservice.entities.VehicleCategory;
import com.aawashcar.opsservice.entities.VehicleType;
import com.aawashcar.opsservice.service.VehicleService;

@RequestMapping("vehicle/")
@ResponseBody
@Controller
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@RequestMapping(value = "categories", method = RequestMethod.GET)
	public List<VehicleCategory> getVehicleCategories() {
		return vehicleService.listCategories();
	}

	@RequestMapping(value = "category/{id}", method = RequestMethod.GET)
	public VehicleCategory getVehicleCategory(@PathVariable("id") int id) {
		return vehicleService.findVehicleCategoryById(id);
	}

	@RequestMapping(value = "type/{id}", method = RequestMethod.GET)
	public VehicleType getVehicleType(@PathVariable("id") int id) {
		return vehicleService.findVehicleTypeById(id);
	}

	@RequestMapping(value = "vehiclecategory/{id}", method = RequestMethod.GET)
	public VehicleCategory getCategoryByVehicleId(@PathVariable("id") int id) {
		return vehicleService.findCategoryByVehicleId(id);
	}

	@RequestMapping(value = "vehicletype/{id}", method = RequestMethod.GET)
	public VehicleType getTypeByVehicleId(@PathVariable("id") int id) {
		return vehicleService.findTypeByVehicleId(id);
	}

	@RequestMapping(value = "types", method = RequestMethod.GET)
	public List<VehicleType> getVehicleTypes() {
		return vehicleService.listTypes();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Vehicle findVehicleById(@PathVariable("id") int id) {
		return vehicleService.findVehicle(id);
	}

	@RequestMapping(value = "new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int newVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.newVehicle(vehicle);
	}

	@RequestMapping(value = "license/{license}", method = RequestMethod.GET)
	public Vehicle findVehicleByLicense(@PathVariable("license") String license) {
		return vehicleService.findVehicleByLicense(license);
	}
	
	@RequestMapping(value = "updatelicense/{vehicleid}/{license}", method = RequestMethod.PUT) 
	public int updateLicense(@PathVariable("vehicleid") int vehicleId, @PathVariable("license") String license) {
		Vehicle vehicle = vehicleService.findVehicle(vehicleId);
		
		if (vehicle == null) {
			// log error
			return 0;
		}
		vehicle.setLicense(license);
		return vehicleService.updateVehicle(vehicle);
	}
}
