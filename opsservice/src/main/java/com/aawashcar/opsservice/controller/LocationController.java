package com.aawashcar.opsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aawashcar.opsservice.entities.City;
import com.aawashcar.opsservice.entities.District;
import com.aawashcar.opsservice.entities.Location;
import com.aawashcar.opsservice.entities.Province;
import com.aawashcar.opsservice.entities.ResidentialQuarter;
import com.aawashcar.opsservice.service.LocationService;

@RequestMapping("location/")
@ResponseBody
@Controller
@Deprecated
public class LocationController {
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value="lal/{id}", method = RequestMethod.GET)
	public Location getLaL(@PathVariable("id") int id) {
		return locationService.findLalById(id);
	}

	@RequestMapping(value = "province/default", method = RequestMethod.GET)
	public Province defaultProvince() {
		return locationService.retrieveDefaultProvince();
	}

	@RequestMapping(value = "city/default", method = RequestMethod.GET)
	public City defaultCity() {
		return locationService.retrieveDefaultCity();
	}

	@RequestMapping(value = "district/default", method = RequestMethod.GET)
	public District defaultDistrict() {
		return locationService.retrieveDefaultDistrict();
	}

	@RequestMapping(value = "resiquarter/default", method = RequestMethod.GET)
	public ResidentialQuarter defaultResiQuarter() {
		return locationService.retrieveDefaultResiQuarter();
	}
	
	@RequestMapping(value = "province/{id}", method = RequestMethod.GET)
	public Province findProvince(@PathVariable("id") int id) {
		return locationService.findProvinceById(id);
	}
	
	@RequestMapping(value = "city/{id}", method = RequestMethod.GET)
	public City findCity(@PathVariable("id") int id) {
		return locationService.findCityById(id);
	}

	@RequestMapping(value = "district/{id}", method = RequestMethod.GET)
	public District findDistrict(@PathVariable("id") int id) {
		return locationService.findDistrictById(id);
	}

	@RequestMapping(value = "resiquarter/{id}", method = RequestMethod.GET)
	public ResidentialQuarter findResiQuarter(@PathVariable("id") int id) {
		return locationService.findResidentialQuarterById(id);
	}

	@RequestMapping(value = "district/listall/{provinceId}/{cityId}", method = RequestMethod.GET)
	public List<District>
	       listDistricts(@PathVariable(name = "provinceId") int provinceId,
	                     @PathVariable(name = "cityId") int cityId) {
		return locationService.listDistricts(provinceId, cityId);
	}
	
	@RequestMapping(value = "residentialquarter/listall/{provinceId}/{cityId}/{districtId}", method = RequestMethod.GET)
	public List<ResidentialQuarter>
	       listResidentialQuarters(@PathVariable(name = "provinceId") int provinceId,
	                     @PathVariable(name = "cityId") int cityId, 
	                     @PathVariable(name= "districtId") int districtId) {
		return locationService.listResidentialQuarter(provinceId, cityId, districtId);
	}
}
