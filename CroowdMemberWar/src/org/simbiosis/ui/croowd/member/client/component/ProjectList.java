package org.simbiosis.ui.croowd.member.client.component;

import org.simbiosis.ui.croowd.member.client.project.IProject.Activity;
import org.simbiosis.ui.croowd.member.shared.ProjectDv;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ProjectList extends Composite implements Editor<ProjectDv> {

	private static ProjectListUiBinder uiBinder = GWT
			.create(ProjectListUiBinder.class);

	interface ProjectListUiBinder extends UiBinder<Widget, ProjectList> {
	}

	interface Driver extends SimpleBeanEditorDriver<ProjectDv, ProjectList> {
	}

	Driver driver = GWT.create(Driver.class);

	Activity activity;

	public ProjectList() {
		initWidget(uiBinder.createAndBindUi(this));

		driver.initialize(this);
		driver.edit(new ProjectDv());
	}

	@UiField
	Label title;
	@UiField
	Label userName;
	@UiField
	Label shortBlurb;
	@UiField
	Label strLocation;
	@UiField
	Label funded;
	@UiField
	Label pledged;
	@UiField
	Button btnChange;

	ProjectDv dv;

	public void setData(ProjectDv data) {
		dv = data;
		driver.edit(data);
	}

	@UiHandler("btnChange")
	public void onChange(ClickEvent e) {
		activity.editProject(dv);
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
}
