package com.croowd.ui.member.client.component;

import org.simbiosis.ui.gwt.client.editor.ListComboBox;

public class IdTypeComboBox extends ListComboBox<Integer, IdTypeDv> {
	
	@Override
	public String convertItemId(IdTypeDv data) {
		return data.getType().toString();
	}

	@Override
	public int compareData(Integer value, IdTypeDv data) {
		return data.getType().compareTo(value);
	}

	@Override
	public Integer convertData(int index, String value) {
		return index > -1 ? Integer.parseInt(value) : 0;
	}

}
