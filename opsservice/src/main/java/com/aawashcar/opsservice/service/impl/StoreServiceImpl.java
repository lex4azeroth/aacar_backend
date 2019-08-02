package com.aawashcar.opsservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aawashcar.opsservice.entities.StoreEntity;
import com.aawashcar.opsservice.mappers.StoreMapper;
import com.aawashcar.opsservice.model.Store;
import com.aawashcar.opsservice.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreMapper mapper;

	@Override
	public Store findStoreByStoreId(String storeId) {
		return entityToModel(mapper.findStore(storeId));
	}

	@Override
	public List<Store> findStores() {
		List<StoreEntity> entities = mapper.listStores();
		return entities.stream().map(entity -> entityToModel(entity)).collect(Collectors.toList());
	}

	private Store entityToModel(StoreEntity storeEntity) {
		Store store = new Store();
		store.setId(storeEntity.getId());
		store.setAddress(
				StringUtils.isNotEmpty(storeEntity.getAddress()) ? storeEntity.getAddress() : StringUtils.EMPTY);
		store.setDescription(
				StringUtils.isNotEmpty(storeEntity.getDescription()) ? storeEntity.getAddress() : StringUtils.EMPTY);
		store.setEnabled(storeEntity.isEnabled());
		store.setIcon(StringUtils.isNotEmpty(storeEntity.getIcon()) ? storeEntity.getIcon() : StringUtils.EMPTY);
		store.setLatitude(storeEntity.getLatitude());
		store.setLongitude(storeEntity.getLongitude());
		store.setModifiedTime(storeEntity.getModifiedTime());
		store.setStoreId(storeEntity.getStoreId());
		store.setTitle(storeEntity.getTitle());
		store.setModifiedTime(storeEntity.getModifiedTime());
		store.setCreatedTime(storeEntity.getCreatedTime());
		store.setEnabled(storeEntity.isEnabled());
		return store;
	}

}
