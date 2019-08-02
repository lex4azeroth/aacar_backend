package com.aawashcar.capservice.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6952084889003191862L;

	private Integer id;
	private Timestamp createdTime;
	private Timestamp modifiedTime;
	private Boolean enabled;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
