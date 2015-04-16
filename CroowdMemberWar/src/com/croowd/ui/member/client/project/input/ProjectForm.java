package com.croowd.ui.member.client.project.input;

import java.util.List;

import org.simbiosis.ui.gwt.client.editor.ViewerEditorForm;

import com.croowd.ui.member.shared.CategoryDv;
import com.croowd.ui.member.shared.LocationDv;
import com.croowd.ui.member.shared.ProjectDv;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ProjectForm extends Composite implements IProjectInput {

	Activity activity;

	private static ProjectFormUiBinder uiBinder = GWT
			.create(ProjectFormUiBinder.class);

	interface ProjectFormUiBinder extends UiBinder<Widget, ProjectForm> {
	}

	@UiField
	ViewerEditorForm<ProjectDv> project;

	ProjectFormViewer viewer;
	ProjectFormEditor editor;

	public ProjectForm() {
		initWidget(uiBinder.createAndBindUi(this));
		viewer = new ProjectFormViewer();
		editor = new ProjectFormEditor();
		project.setViewerEditor(viewer, editor);
		project.init(new ProjectDv());
	}

	@Override
	public void setActivity(Activity activity) {
		this.activity = activity;
		viewer.setActivity(activity);
		editor.setActivity(activity);
	}

	public Widget getWidget() {
		return this;
	}

	@Override
	public void setData(ProjectDv dv) {
		project.setData(dv);
	}

	@Override
	public void setListCategory(List<CategoryDv> categorys) {
		editor.setCategorys(categorys);
	}

	@Override
	public void setListSubCategory(List<CategoryDv> subCategorys) {
		editor.setSubCategorys(subCategorys);
	}

	@Override
	public void setListLocation(List<LocationDv> locations) {
		editor.setLocations(locations);
	}

	@Override
	public void viewer() {
		project.view();

	}

	@Override
	public void editor() {
		project.edit();
	}

}
