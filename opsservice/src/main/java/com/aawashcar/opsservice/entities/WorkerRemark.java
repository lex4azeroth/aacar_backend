package com.aawashcar.opsservice.entities;

public class WorkerRemark extends BaseEntity {
	
	private String content;
	
	private int type;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
