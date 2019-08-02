package com.aawashcar.capservice.model;

public class CapabilityTypeModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2780587664117006566L;

	private String typeId;
	private String name;
	private String description;

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
