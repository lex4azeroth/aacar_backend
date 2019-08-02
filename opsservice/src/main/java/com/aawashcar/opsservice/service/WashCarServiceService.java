package com.aawashcar.opsservice.service;

import java.util.List;

import com.aawashcar.opsservice.entities.WashCarService;

public interface WashCarServiceService {
	
	List<WashCarService> listServices();
	
	WashCarService findServiceById(int id);
	
	double findOriginPrice(int vtId, int vcId, int serviceId);

}
