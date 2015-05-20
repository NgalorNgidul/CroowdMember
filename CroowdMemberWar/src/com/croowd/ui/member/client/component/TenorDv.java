package com.croowd.ui.member.client.component;

public class TenorDv {
	Integer tenor;
	String name;

	public TenorDv() {
		tenor = 0;
	}

	public TenorDv(Integer tenor, String name) {
		this.tenor = tenor;
		this.name = name;
	}

	public Integer getTenor() {
		return tenor;
	}

	public void setTenor(Integer tenor) {
		this.tenor = tenor;
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
