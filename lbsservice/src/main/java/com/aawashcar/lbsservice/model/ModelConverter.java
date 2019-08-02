package com.aawashcar.lbsservice.model;

import com.aawashcar.lbsservice.entities.Location;

public class ModelConverter {
	
	public static Location modelToEntity(LocationModel model) {
		Location location = new Location();
		
		if (model == null) {
			return location;
		}
		
		location.setAddressRemarks(model.getAddressRemark());
		location.setDetailAddress(model.getDetailAddress());
		location.setLatitude(model.getLatitude() == null ? null : model.getLatitude());
		location.setLongitude(model.getLongitude() == null ? null : model.getLongitude());
		location.setUserId(model.getUserId());
		location.setOpenId(model.getOpenId());
		return location;
	}
	
	public static LocationModel entityToModel(Location location) {
		LocationModel locationModel = new LocationModel();
		
		if (location == null) {
			return locationModel;
		}

		locationModel.setId(location.getId());
		locationModel.setAddressRemark(location.getAddressRemark());
		locationModel.setDetailAddress(location.getDetailAddress());
		locationModel.setLatitude(location.getLatitude());
		locationModel.setLongitude(location.getLongitude());
		locationModel.setUserId(location.getUserId().intValue());
		locationModel.setOpenId(location.getOpenId());
		locationModel.setModifiedTime(location.getModifiedTime());
		locationModel.setCreatedTime(location.getCreatedTime());
		return locationModel;
	}

}
