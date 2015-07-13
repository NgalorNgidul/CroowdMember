package com.croowd.ui.validation.client.userform;

public class IntegerTypeDv {
	Integer type;
	String name;

	public IntegerTypeDv() {
		type = 0;
	}

	public IntegerTypeDv(Integer type, String name) {
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
