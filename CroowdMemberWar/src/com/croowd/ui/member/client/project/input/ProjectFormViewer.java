package com.croowd.ui.member.client.project.input;

import org.simbiosis.ui.gwt.client.editor.ViewerForm;

import com.croowd.ui.member.client.project.input.IProjectInput.Activity;
import com.croowd.ui.member.shared.ProjectDv;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ProjectFormViewer extends ViewerForm<ProjectDv> implements
		Editor<ProjectDv> {

	private static ProjectFormUiBinder uiBinder = GWT
			.create(ProjectFormUiBinder.class);

	interface ProjectFormUiBinder extends UiBinder<Widget, ProjectFormViewer> {
	}

	interface Driver extends
			SimpleBeanEditorDriver<ProjectDv, ProjectFormViewer> {
	}

	Driver driver = GWT.create(Driver.class);

	Activity activity;

	@UiField
	Label title;
	@UiField
	Label shortBlurb;
	@UiField
	Label strCategory;
	@UiField
	Label strSubCategory;
	@UiField
	Label strLocation;
	@UiField
	Label strDuration;
	@UiField
	Label goal;
	@UiField
	Button btnChange;
	@UiField
	Button btnBack;

	ProjectDv dv;

	public ProjectFormViewer() {
		initWidget(uiBinder.createAndBindUi(this));
		driver.initialize(this);
		driver.edit(new ProjectDv());
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@UiHandler("btnChange")
	void onChange(ClickEvent event) {
		activity.onEdit(dv);
	}

	@UiHandler("btnBack")
	void onBack(ClickEvent event) {
		activity.onBack();
	}

	@Override
	public void view(ProjectDv data) {
		driver.edit(data);
	}

}
