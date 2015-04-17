package com.croowd.ui.member.client.component;

import com.croowd.ui.member.client.json.ProspectJso;
import com.croowd.ui.member.client.project.IProject.Activity;
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

public class ProjectList extends Composite implements Editor<ProspectJso> {

	private static ProjectListUiBinder uiBinder = GWT
			.create(ProjectListUiBinder.class);

	interface ProjectListUiBinder extends UiBinder<Widget, ProjectList> {
	}

	interface Driver extends SimpleBeanEditorDriver<ProspectJso, ProjectList> {
	}

	Driver driver = GWT.create(Driver.class);

	Activity activity;

	public ProjectList() {
		initWidget(uiBinder.createAndBindUi(this));

		driver.initialize(this);
		//driver.edit(new ProspectJso());
	}

	@UiField
	Label title;
	@UiField
	Label ownerName;
	@UiField
	Label description;
	@UiField
	Label location;
	@UiField
	Button btnChange;

	ProspectJso dv;

	public void setData(ProspectJso data) {
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
