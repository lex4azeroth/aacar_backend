package com.aawashcar.opsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aawashcar.opsservice.service.PricingService;

@RequestMapping("pricing/")
@ResponseBody
@Controller
public class PricingController {

	@Autowired
	private PricingService pricingService;

	@RequestMapping(value = "price/{typeId}/{categoryId}/{serviceId}", method = RequestMethod.GET)
	public double getPrice(@PathVariable(name = "typeId") int typeId,
	                       @PathVariable(name = "categoryId") int categoryId,
	                       @PathVariable(name = "serviceId") int serviceId) {
		return pricingService.getPrice(typeId, categoryId, serviceId);
	}
}
