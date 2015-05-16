package com.croowd.ui.member.client;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisClientFactoryImpl;

import com.croowd.ui.member.client.invest.IInvestList;
import com.croowd.ui.member.client.invest.InvestListForm;
import com.croowd.ui.member.client.profile.IProfile;
import com.croowd.ui.member.client.profile.ProfileForm;
import com.croowd.ui.member.client.projectold.IProject;
import com.croowd.ui.member.client.projectold.MainMenu;
import com.croowd.ui.member.client.prospect.IProspectList;
import com.croowd.ui.member.client.prospect.ProspectListForm;

public class AppFactoryImpl extends SIMbiosisClientFactoryImpl implements
		AppFactory {

	static final ProspectListForm PROSPECT_FORM = new ProspectListForm();
	static final MainMenu PROJECT = new MainMenu();
	static final ProfileForm PROFILE_FORM = new ProfileForm();
	static final InvestListForm INVEST_FORM = new InvestListForm();

	@Override
	public IProject getProject() {
		return PROJECT;
	}

	@Override
	public IProfile getProfileForm() {
		return PROFILE_FORM;
	}

	@Override
	public IProspectList getProspectList() {
		return PROSPECT_FORM;
	}

	@Override
	public IInvestList getInvestList() {
		return INVEST_FORM;
	}

}
