package com.aawashcar.crmservice.entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4827773344276757403L;
	private int id;
	private Timestamp createdTime;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}
}
