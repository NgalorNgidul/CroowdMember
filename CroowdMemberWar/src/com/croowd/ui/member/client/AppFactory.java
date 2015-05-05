package com.croowd.ui.member.client;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisClientFactory;

import com.croowd.ui.member.client.profile.IProfile;
import com.croowd.ui.member.client.project.IProject;
import com.croowd.ui.member.client.project.input.IProjectInput;
import com.croowd.ui.member.client.prospect.IProspectList;

public interface AppFactory extends SIMbiosisClientFactory {
	IProspectList getProspectList();

	IProject getProject();

	IProjectInput getProjectInput();

	IProfile getProfileForm();
}
