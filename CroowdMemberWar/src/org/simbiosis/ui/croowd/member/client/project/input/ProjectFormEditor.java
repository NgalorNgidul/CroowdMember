package org.simbiosis.ui.croowd.member.client.project.input;

import java.util.List;

import org.simbiosis.ui.croowd.member.client.project.input.IProjectInput.Activity;
import org.simbiosis.ui.croowd.member.shared.CategoryDv;
import org.simbiosis.ui.croowd.member.shared.LocationDv;
import org.simbiosis.ui.croowd.member.shared.ProjectDv;
import org.simbiosis.ui.gwt.client.editor.EditorForm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ProjectFormEditor extends EditorForm<ProjectDv> implements
		Editor<ProjectDv> {

	private static ProjectFormUiBinder uiBinder = GWT
			.create(ProjectFormUiBinder.class);

	interface ProjectFormUiBinder extends UiBinder<Widget, ProjectFormEditor> {
	}

	interface Driver extends
			SimpleBeanEditorDriver<ProjectDv, ProjectFormEditor> {
	}

	Driver driver = GWT.create(Driver.class);

	Activity activity;

	@UiField
	TextBox title;
	@UiField
	TextArea shortBlurb;
	@UiField
	ListBox category;
	@UiField
	ListBox subCategory;
	@UiField
	ListBox location;
	@UiField
	Button btnSave;
	@UiField
	Button btnCancel;

	public ProjectFormEditor() {
		initWidget(uiBinder.createAndBindUi(this));
		driver.initialize(this);
		driver.edit(new ProjectDv());
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@UiHandler("btnSave")
	void onSave(ClickEvent event) {
		Window.alert("simpan");
	}

	@UiHandler("btnCancel")
	void onCancel(ClickEvent event) {
		activity.onBack();
	}

	@Override
	public void edit(ProjectDv data) {
		driver.edit(data);
	}

	public void setCategorys(List<CategoryDv> categorys) {
		category.clear();
		for (CategoryDv dv : categorys) {
			category.addItem(dv.getName(), dv.getId().toString());
		}
	}

	public void setSubCategorys(List<CategoryDv> subCategorys) {
		subCategory.clear();
		for (CategoryDv dv : subCategorys) {
			subCategory.addItem(dv.getName(), dv.getId().toString());
		}
	}

	public void setLocations(List<LocationDv> locations) {
		location.clear();
		for (LocationDv dv : locations) {
			location.addItem(dv.getName(), dv.getId().toString());
		}
	}
}
