package com.aawashcar.lbsservice.model;

import java.math.BigDecimal;

public class LocationModel extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5809379780558212740L;
	private int userId;
	private String openId;
	private String detailAddress;
	private String addressRemark;
	private BigDecimal longitude;
	private BigDecimal latitude;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getAddressRemark() {
		return addressRemark;
	}
	public void setAddressRemark(String addressRemark) {
		this.addressRemark = addressRemark;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

}
