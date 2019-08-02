package com.aawashcar.opsservice.service;

import java.util.List;

import com.aawashcar.opsservice.model.Store;

public interface StoreService {
	
	public Store findStoreByStoreId(String storeId);
	
	public List<Store> findStores();

}
