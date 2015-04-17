package com.croowd.ui.member.client.project.input;

import org.simbiosis.ui.gwt.client.editor.ViewerForm;

import com.croowd.ui.member.client.json.ProspectJso;
import com.croowd.ui.member.client.project.input.IProjectInput.Activity;
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

public class ProjectFormViewer extends ViewerForm<ProspectJso> implements
		Editor<ProspectJso> {

	private static ProjectFormUiBinder uiBinder = GWT
			.create(ProjectFormUiBinder.class);

	interface ProjectFormUiBinder extends UiBinder<Widget, ProjectFormViewer> {
	}

	interface Driver extends
			SimpleBeanEditorDriver<ProspectJso, ProjectFormViewer> {
	}

	Driver driver = GWT.create(Driver.class);

	Activity activity;

	@UiField
	Label title;
	@UiField
	Label description;
	@UiField
	Label category;
	@UiField
	Label location;
	@UiField
	Button btnChange;
	@UiField
	Button btnBack;

	ProspectJso dv;

	public ProjectFormViewer() {
		initWidget(uiBinder.createAndBindUi(this));
		driver.initialize(this);
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
	public void view(ProspectJso data) {
		driver.edit(data);
	}

}
