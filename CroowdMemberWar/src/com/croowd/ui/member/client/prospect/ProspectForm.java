package com.croowd.ui.member.client.prospect;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ProspectForm extends Composite implements IProspect {

	Activity activity;

	private static ProfileFormUiBinder uiBinder = GWT
			.create(ProfileFormUiBinder.class);

	interface ProfileFormUiBinder extends UiBinder<Widget, ProspectForm> {
	}

	public ProspectForm() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@Override
	public Widget getWidget() {
		return this;
	}

}
