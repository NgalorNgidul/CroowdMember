package com.croowd.ui.member.client;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisActivityMapper;

import com.croowd.ui.member.client.places.ProjectPlace;
import com.croowd.ui.member.client.project.ProjectActivity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper extends SIMbiosisActivityMapper {

	public AppActivityMapper(AppFactory clientFactory) {
		super(clientFactory);
	}

	@Override
	public Activity dispatchActivity(Place place) {
		AppFactory appFactory = (AppFactory) getClientFactory();
		//
		if (place instanceof ProjectPlace) {
			return new ProjectActivity((ProjectPlace) place, appFactory);
		}
		return null;
	}

}
