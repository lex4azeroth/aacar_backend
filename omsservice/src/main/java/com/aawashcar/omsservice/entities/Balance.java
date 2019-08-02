package com.aawashcar.omsservice.entities;

public class Balance extends BaseEntity {
	private int userId;
	private double balance;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
