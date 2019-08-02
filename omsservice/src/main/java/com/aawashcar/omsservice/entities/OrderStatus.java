package com.aawashcar.omsservice.entities;

public class OrderStatus extends BaseInfoEntity {
	/**
	 * 正数50内为需要继续处理状态：
	 * 		支付 -> 10 ; 
	 * 		待派单 -> 20; 
	 * 		进行中 -> 30; 
	 * 		退款中 -> 50;
	 * 负数为完成情况状态:
	 * 		已取消 -> -1; 
	 * 		已完成 -> -10; 
	 * 		0 -> 问题订单
	 */
	private int statusCode;
	
	private boolean enabled;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
