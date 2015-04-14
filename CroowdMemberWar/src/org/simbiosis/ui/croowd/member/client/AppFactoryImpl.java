package org.simbiosis.ui.croowd.member.client;

import org.simbiosis.ui.croowd.member.client.project.IProject;
import org.simbiosis.ui.croowd.member.client.project.MainMenu;
import org.simbiosis.ui.croowd.member.client.project.input.IProjectInput;
import org.simbiosis.ui.croowd.member.client.project.input.ProjectForm;
import org.simbiosis.ui.gwt.client.mvp.SIMbiosisClientFactoryImpl;

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
