package com.croowd.ui.validation.client.notvalidform;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class NotValidForm extends Composite {

	private static NotValidFormUiBinder uiBinder = GWT
			.create(NotValidFormUiBinder.class);

	interface NotValidFormUiBinder extends UiBinder<Widget, NotValidForm> {
	}

	public NotValidForm() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
