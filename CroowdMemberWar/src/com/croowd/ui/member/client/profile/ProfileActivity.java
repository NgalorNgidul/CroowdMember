package com.croowd.ui.member.client.profile;

import com.croowd.ui.member.client.AppFactory;
import com.croowd.ui.member.client.profile.IProfile.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ProfileActivity extends Activity {

	Place myPlace;
	AppFactory appFactory;
	Activity activity;

	public ProfileActivity(Place myPlace, AppFactory appFactory) {
		setFactory(appFactory);
		this.myPlace = myPlace;
		this.appFactory = appFactory;
		activity = this;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		IProfile myForm = appFactory.getProfileForm();
		myForm.setActivity(this);
		//
		// loadProspect();
		//
		panel.setWidget(myForm.getWidget());
	}

}
