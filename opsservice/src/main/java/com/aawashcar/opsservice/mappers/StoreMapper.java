package com.aawashcar.opsservice.mappers;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.opsservice.entities.StoreEntity;

@Mapper
public interface StoreMapper {

	StoreEntity findStore(String storeId);
	
	List<StoreEntity> listStores();
}
