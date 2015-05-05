package com.croowd.ui.member.client.prospect;

import com.croowd.ui.member.client.AppFactory;
import com.croowd.ui.member.client.prospect.IProspect.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ProspectActivity extends Activity {

	Place myPlace;
	AppFactory appFactory;
	Activity activity;

	public ProspectActivity(Place myPlace, AppFactory appFactory) {
		setFactory(appFactory);
		this.myPlace = myPlace;
		this.appFactory = appFactory;
		activity = this;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		IProspect myForm = appFactory.getProspectForm();
		myForm.setActivity(this);
		//
		// loadProspect();
		//
		panel.setWidget(myForm.getWidget());
	}

}
