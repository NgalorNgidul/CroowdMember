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
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

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
	DateBox duration;
	@UiField
	Button btnSave;
	@UiField
	Button btnCancel;

	ProjectDv dv;

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
		dv = driver.flush();
		dv.setCategory(new Long(category.getValue(category.getSelectedIndex())));
		dv.setSubCategory(new Long(subCategory.getValue(subCategory
				.getSelectedIndex())));
		dv.setLocation(new Long(location.getValue(location.getSelectedIndex())));
		activity.onSave(driver.flush());
	}

	@UiHandler("btnCancel")
	void onCancel(ClickEvent event) {
		activity.onBack();
	}

	@Override
	public void edit(ProjectDv data) {
		dv = data;
		driver.edit(data);
	}

	public void setCategorys(List<CategoryDv> categorys) {
		int index = 0;
		for (CategoryDv dv : categorys) {
			category.addItem(dv.getName(), dv.getId().toString());
			if (this.dv.getCategory() == dv.getId()) {
				category.setSelectedIndex(index);
			}
			index++;
		}
	}

	public void setSubCategorys(List<CategoryDv> subCategorys) {
		int index = 0;
		for (CategoryDv dv : subCategorys) {
			subCategory.addItem(dv.getName(), dv.getId().toString());
			if (this.dv.getSubCategory() == dv.getId()) {
				subCategory.setSelectedIndex(index);
			}
			index++;
		}
	}

	public void setLocations(List<LocationDv> locations) {
		int index = 0;
		for (LocationDv dv : locations) {
			location.addItem(dv.getName(), dv.getId().toString());
			if (this.dv.getLocation() == dv.getId()) {
				location.setSelectedIndex(index);
			}
			index++;
		}
	}
}
