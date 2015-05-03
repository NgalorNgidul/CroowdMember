package com.croowd.ui.validation.client.userform;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class RegisterSuccess extends Composite {

	private static RegisterSuccessUiBinder uiBinder = GWT
			.create(RegisterSuccessUiBinder.class);

	interface RegisterSuccessUiBinder extends UiBinder<Widget, RegisterSuccess> {
	}

	public RegisterSuccess() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
