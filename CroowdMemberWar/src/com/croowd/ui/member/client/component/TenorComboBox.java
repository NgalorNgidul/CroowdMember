package com.croowd.ui.member.client.component;

import org.simbiosis.ui.gwt.client.editor.ListComboBox;

public class TenorComboBox extends ListComboBox<Integer, TenorDv> {
	
	@Override
	public String convertItemId(TenorDv data) {
		return data.getTenor().toString();
	}

	@Override
	public int compareData(Integer value, TenorDv data) {
		return data.getTenor().compareTo(value);
	}

	@Override
	public Integer convertData(int index, String value) {
		return index > -1 ? Integer.parseInt(value) : 0;
	}

}
