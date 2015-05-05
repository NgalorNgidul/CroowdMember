package com.croowd.ui.member.client;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisClientFactoryImpl;

import com.croowd.ui.member.client.profile.IProfile;
import com.croowd.ui.member.client.profile.ProfileForm;
import com.croowd.ui.member.client.project.IProject;
import com.croowd.ui.member.client.project.MainMenu;
import com.croowd.ui.member.client.project.input.IProjectInput;
import com.croowd.ui.member.client.project.input.ProjectForm;
import com.croowd.ui.member.client.prospect.IProspect;
import com.croowd.ui.member.client.prospect.ProspectForm;

public class AppFactoryImpl extends SIMbiosisClientFactoryImpl implements
		AppFactory {

	static final ProspectForm PROSPECT_FORM = new ProspectForm();
	static final MainMenu PROJECT = new MainMenu();
	static final ProjectForm PROJECT_FORM = new ProjectForm();
	static final ProfileForm PROFILE_FORM = new ProfileForm();

	@Override
	public IProject getProject() {
		return PROJECT;
	}

	@Override
	public IProjectInput getProjectInput() {
		return PROJECT_FORM;
	}

	@Override
	public IProfile getProfileForm() {
		return PROFILE_FORM;
	}

	@Override
	public IProspect getProspectForm() {
		return PROSPECT_FORM;
	}

}
