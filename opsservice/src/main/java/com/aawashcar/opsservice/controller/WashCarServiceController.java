package com.aawashcar.opsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aawashcar.opsservice.entities.WashCarService;
import com.aawashcar.opsservice.service.WashCarServiceService;

@RequestMapping("wasshcarservice/")
@ResponseBody
@Controller
@Deprecated
public class WashCarServiceController {
	@Autowired
	private WashCarServiceService serviceService;

	@RequestMapping(value = "services", method = RequestMethod.GET)
	public List<WashCarService> listServices() {
		return serviceService.listServices();
	}
	
	@RequestMapping(value = "service/{serviceId}", method = RequestMethod.GET)
	public WashCarService findServiceById(@PathVariable("serviceId") int serviceId) {
		return serviceService.findServiceById(serviceId);
	}
	
	@RequestMapping(value = "service/originprice/{vehicletype}/{vehiclecate}/{serviceid}", method = RequestMethod.GET)
	public double findOriginPrice(@PathVariable("vehicletype") int vtId, 
								  @PathVariable("vehiclecate") int vcId, 
								  @PathVariable("serviceid") int serviceId) {
		return serviceService.findOriginPrice(vtId, vcId, serviceId);
	}
}
