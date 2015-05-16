package com.croowd.ui.member.client.component;

import org.simbiosis.ui.gwt.client.editor.ListComboBox;

public class SexComboBox extends ListComboBox<Integer, SexDv> {

	@Override
	public String convertItemId(SexDv data) {
		return data.getSex().toString();
	}

	@Override
	public int compareData(Integer value, SexDv data) {
		return data.getSex().compareTo(value);
	}

	@Override
	public Integer convertData(int index, String value) {
		return index > -1 ? Integer.parseInt(value) : 0;
	}

}
