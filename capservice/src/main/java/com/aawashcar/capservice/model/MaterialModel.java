package com.aawashcar.capservice.model;

public class MaterialModel extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8262923845145746871L;
	private String name;
	private String description;
	private String iconUrl;

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

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
}
