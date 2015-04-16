package com.croowd.ui.member.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class CategoryDv implements IsSerializable {

	Long id;
	String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
