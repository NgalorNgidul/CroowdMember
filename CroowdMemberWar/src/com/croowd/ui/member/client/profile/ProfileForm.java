package com.croowd.ui.member.client.profile;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ProfileForm extends Composite implements IProfile {

	Activity activity;

	private static ProfileFormUiBinder uiBinder = GWT
			.create(ProfileFormUiBinder.class);

	interface ProfileFormUiBinder extends UiBinder<Widget, ProfileForm> {
	}

	public ProfileForm() {
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
