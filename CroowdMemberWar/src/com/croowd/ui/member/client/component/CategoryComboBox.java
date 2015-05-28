package com.croowd.ui.member.client.component;

import org.simbiosis.ui.gwt.client.editor.ListComboBox;

public class CategoryComboBox extends ListComboBox<String, CategoryDv> {

	@Override
	public String convertItemId(CategoryDv data) {
		return data.getName();
	}

	@Override
	public int compareData(String value, CategoryDv data) {
		return data.getName().compareTo(value);
	}

	@Override
	public String convertData(int index, String value) {
		return index > -1 ? value : "";
	}

}
