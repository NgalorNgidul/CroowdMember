package com.croowd.ui.member.client.component;

public class SexDv {
	Integer sex;
	String name;

	public SexDv() {
		sex = 0;
	}

	public SexDv(Integer sex, String name) {
		this.sex = sex;
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
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
