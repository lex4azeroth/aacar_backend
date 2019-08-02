package com.aawashcar.promservice.entities;

public class RUserConsumeService extends BaseEntity {
	private int userId;
	private int serviceId;
	private int promotionId;
	private int consumedCount;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public int getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}

	public int getConsumedCount() {
		return consumedCount;
	}

	public void setConsumedCount(int consumedCount) {
		this.consumedCount = consumedCount;
	}
}
