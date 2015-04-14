package org.simbiosis.ui.croowd.member.client;

import org.simbiosis.ui.croowd.member.client.project.IProject;
import org.simbiosis.ui.croowd.member.client.project.input.IProjectInput;
import org.simbiosis.ui.gwt.client.mvp.SIMbiosisClientFactory;

public interface AppFactory extends SIMbiosisClientFactory {
	IProject getProject();

	IProjectInput getProjectInput();
}
