package com.aawashcar.opsservice.entities;

public class Price extends BaseEntity {
	private int vehicleTypeId;
	private int vehicleCategoryId;
	private int serviceId;
	private double price;
	private boolean enabled;

	public int getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(int vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public int getVehicleCategoryId() {
		return vehicleCategoryId;
	}

	public void setVehicleCategoryId(int vehicleCategoryId) {
		this.vehicleCategoryId = vehicleCategoryId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
}
