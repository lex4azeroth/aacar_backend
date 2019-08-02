package com.aawashcar.omsservice.entities;

import java.sql.Timestamp;

public class BaseEntity {
	private int id;
	private Timestamp createdTime;

	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Timestamp getCreatedTime() {
		return createdTime;
	}
}
