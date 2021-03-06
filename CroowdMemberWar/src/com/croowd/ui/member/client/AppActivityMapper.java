package com.croowd.ui.member.client;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisActivityMapper;

import com.croowd.ui.member.client.invest.InvestListActivity;
import com.croowd.ui.member.client.places.InvestList;
import com.croowd.ui.member.client.places.Profile;
import com.croowd.ui.member.client.places.Project;
import com.croowd.ui.member.client.places.ProspectList;
import com.croowd.ui.member.client.profile.ProfileActivity;
import com.croowd.ui.member.client.projectold.ProjectActivity;
import com.croowd.ui.member.client.prospect.ProspectListActivity;
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
		if (place instanceof Project) {
			return new ProjectActivity((Project) place, appFactory);
		} else if (place instanceof Profile) {
			return new ProfileActivity((Profile) place, appFactory);
		} else if (place instanceof ProspectList) {
			return new ProspectListActivity((ProspectList) place, appFactory);
		} else if (place instanceof InvestList) {
			return new InvestListActivity((InvestList) place, appFactory);
		}

		return null;
	}

}
