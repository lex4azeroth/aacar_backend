package com.aawashcar.opsservice.entities;

import java.sql.Timestamp;

public class BaseEntity {
	private int id;
	private Timestamp createdTime;
	private boolean enabled = true;

	public int getId() {
		return id;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
