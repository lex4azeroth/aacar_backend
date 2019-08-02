package com.aawashcar.opsservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aawashcar.opsservice.entities.WashCarService;
import com.aawashcar.opsservice.mappers.ServiceMapper;
import com.aawashcar.opsservice.service.WashCarServiceService;

@Service()
public class WashCarServiceServiceImpl implements WashCarServiceService {

	@Autowired
	private ServiceMapper serviceMapper;
	
	@Override
	public List<WashCarService> listServices() {
		return serviceMapper.listServices();
	}
	
	@Override
	public WashCarService findServiceById(int id) {
		return serviceMapper.findServiceById(id);
	}

	@Override
	public double findOriginPrice(int vtId, int vcId, int serviceId) {
		return serviceMapper.findOriginPrice(vtId, vcId, serviceId);
	}
}
