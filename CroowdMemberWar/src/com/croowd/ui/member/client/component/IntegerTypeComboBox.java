package com.croowd.ui.member.client.component;

import org.simbiosis.ui.gwt.client.editor.ListComboBox;

public class IntegerTypeComboBox extends ListComboBox<Integer, IntegerTypeDv> {

	@Override
	public String convertItemId(IntegerTypeDv data) {
		return data.getType().toString();
	}

	@Override
	public int compareData(Integer value, IntegerTypeDv data) {
		return data.getType().compareTo(value);
	}

	@Override
	public Integer convertData(int index, String value) {
		return index > -1 ? Integer.parseInt(value) : 0;
	}

}
