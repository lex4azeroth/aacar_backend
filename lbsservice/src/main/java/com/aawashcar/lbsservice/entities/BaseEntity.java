package com.aawashcar.lbsservice.entities;

import java.sql.Timestamp;

public class BaseEntity {

	private int id;
	private Timestamp createdTime;
	private Timestamp modifiedTime;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public Timestamp getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
}
