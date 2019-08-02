package com.aawashcar.opsservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aawashcar.opsservice.entities.Price;
import com.aawashcar.opsservice.mappers.PriceMapper;
import com.aawashcar.opsservice.service.PricingService;

@Service()
public class PricingServiceImpl implements PricingService {

	@Autowired
	private PriceMapper priceMapper;
	
	@Override
	public double getPrice(int typeId, int categoryId, int serviceId) {
		Price price = priceMapper.getPrice(typeId, categoryId, serviceId);
		if (price != null) {
			return price.getPrice();
		} else {
			return 0d;
		}
	}
}
