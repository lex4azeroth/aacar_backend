package com.aawashcar.lbsservice.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class BaseModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5853301744653017187L;
	private int id;
	private Timestamp createdTime;
	private Timestamp modifiedTime;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Timestamp getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
}
