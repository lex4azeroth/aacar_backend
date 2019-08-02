package com.aawashcar.opsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aawashcar.opsservice.model.Store;
import com.aawashcar.opsservice.service.StoreService;

@RequestMapping("store/")
@Controller
@ResponseBody
public class StoreController {

	@Autowired
	private StoreService service;

	@RequestMapping(value = "{storeid}", method = RequestMethod.GET)
	public Store showStore(@PathVariable("storeid") String storeId) {
		return service.findStoreByStoreId(storeId);
	}

	@RequestMapping(value = "listall", method = RequestMethod.GET)
	public List<Store> listStores() {
		List<Store> stores = service.findStores();
		return stores;
	}
}
