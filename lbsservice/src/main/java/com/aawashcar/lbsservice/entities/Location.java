package com.aawashcar.lbsservice.entities;

import java.math.BigDecimal;

public class Location extends BaseEntity {

	private Integer userId;
	private String openId;
	private String detailAddress;
	private String addressRemark;
	private BigDecimal longitude;
	private BigDecimal latitude;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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

	public void setAddressRemarks(String addressRemark) {
		this.addressRemark = addressRemark;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

}
