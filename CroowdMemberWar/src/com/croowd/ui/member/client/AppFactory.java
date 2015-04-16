package com.croowd.ui.member.client;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisClientFactory;

import com.croowd.ui.member.client.project.IProject;
import com.croowd.ui.member.client.project.input.IProjectInput;

public interface AppFactory extends SIMbiosisClientFactory {
	IProject getProject();

	IProjectInput getProjectInput();
}
