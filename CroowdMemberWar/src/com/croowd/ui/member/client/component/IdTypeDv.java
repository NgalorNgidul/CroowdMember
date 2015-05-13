package com.croowd.ui.member.client.component;

public class IdTypeDv {
	Integer type;
	String name;

	public IdTypeDv() {
		type = 0;
	}

	public IdTypeDv(Integer type, String name) {
		this.type = type;
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
