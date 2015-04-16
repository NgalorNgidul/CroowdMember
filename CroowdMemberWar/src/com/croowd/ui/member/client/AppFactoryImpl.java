package com.croowd.ui.member.client;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisClientFactoryImpl;

import com.croowd.ui.member.client.project.IProject;
import com.croowd.ui.member.client.project.MainMenu;
import com.croowd.ui.member.client.project.input.IProjectInput;
import com.croowd.ui.member.client.project.input.ProjectForm;

public class AppFactoryImpl extends SIMbiosisClientFactoryImpl implements
		AppFactory {

	static final MainMenu PROJECT = new MainMenu();
	static final ProjectForm PROJECT_FORM = new ProjectForm();

	@Override
	public IProject getProject() {
		// TODO Auto-generated method stub
		return PROJECT;
	}

	@Override
	public IProjectInput getProjectInput() {
		// TODO Auto-generated method stub
		return PROJECT_FORM;
	}

}
