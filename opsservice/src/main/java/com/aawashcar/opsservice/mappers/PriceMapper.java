package com.aawashcar.opsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.opsservice.entities.Price;

@Mapper
public interface PriceMapper {
	
	int addPrice(Price price);
	
	int updatePriceOnly(@Param("id") int id, @Param("price") double price);
	
	int updatePriceStatus(@Param("id") int id, @Param("enabled") boolean enabled);
	
	Price getPrice(@Param("vehicleTypeId") int vehicleTypeId, @Param("vehicleCategoryId") int vehicleCategoryId, @Param("serviceId") int serviceId);
	
	List<Price> listPrices();
}
