package com.aawashcar.opsservice.entities;

public class Member extends BaseInfoEntity {
	private int promotionId;
	private boolean enabled;

	public int getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
