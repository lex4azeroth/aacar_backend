package com.aawashcar.capservice.entities;

import java.sql.Timestamp;

public class BaseEntity {

	private int id;
	private Timestamp createdTime;
	private Timestamp modifiedTime;
	private boolean enabled;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}
	
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Timestamp getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
