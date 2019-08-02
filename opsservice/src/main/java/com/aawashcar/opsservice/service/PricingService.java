package com.aawashcar.opsservice.service;

public interface PricingService {
	double getPrice(int typeId, int categoryId, int serviceId);
}
