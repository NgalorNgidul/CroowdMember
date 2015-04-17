package com.croowd.ui.member.client.project.input;

import java.util.List;

import org.simbiosis.ui.gwt.client.editor.EditorForm;

import com.croowd.ui.member.client.json.ProspectJso;
import com.croowd.ui.member.client.project.input.IProjectInput.Activity;
import com.croowd.ui.member.shared.CategoryDv;
import com.croowd.ui.member.shared.LocationDv;
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

public class ProjectFormEditor extends EditorForm<ProspectJso> implements
		Editor<ProspectJso> {

	private static ProjectFormUiBinder uiBinder = GWT
			.create(ProjectFormUiBinder.class);

	interface ProjectFormUiBinder extends UiBinder<Widget, ProjectFormEditor> {
	}

	interface Driver extends
			SimpleBeanEditorDriver<ProspectJso, ProjectFormEditor> {
	}

	Driver driver = GWT.create(Driver.class);

	Activity activity;

	@UiField
	TextBox title;
	@UiField
	TextArea description;
	@UiField
	ListBox category;
	@UiField
	ListBox location;
	@UiField
	Button btnSave;
	@UiField
	Button btnCancel;

	ProspectJso dv;

	public ProjectFormEditor() {
		initWidget(uiBinder.createAndBindUi(this));
		driver.initialize(this);
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@UiHandler("btnSave")
	void onSave(ClickEvent event) {
		dv = driver.flush();
		// dv.setCategory(new
		// Long(category.getValue(category.getSelectedIndex())));
		// dv.setSubCategory(new Long(subCategory.getValue(subCategory
		// .getSelectedIndex())));
		// dv.setLocation(new
		// Long(location.getValue(location.getSelectedIndex())));
		activity.onSave(driver.flush());
	}

	@UiHandler("btnCancel")
	void onCancel(ClickEvent event) {
		activity.onBack();
	}

	@Override
	public void edit(ProspectJso data) {
		dv = data;
		driver.edit(data);
	}

	public void setCategorys(List<CategoryDv> categorys) {
		int index = 0;
		for (CategoryDv dv : categorys) {
			category.addItem(dv.getName(), dv.getId().toString());
			// if (this.dv.getCategory() == dv.getId()) {
			// category.setSelectedIndex(index);
			// }
			index++;
		}
	}

	public void setSubCategorys(List<CategoryDv> subCategorys) {
		int index = 0;
		for (CategoryDv dv : subCategorys) {
			//subCategory.addItem(dv.getName(), dv.getId().toString());
			// if (this.dv.getSubCategory() == dv.getId()) {
			// subCategory.setSelectedIndex(index);
			// }
			index++;
		}
	}

	public void setLocations(List<LocationDv> locations) {
		int index = 0;
		for (LocationDv dv : locations) {
			location.addItem(dv.getName(), dv.getId().toString());
			// if (this.dv.getLocation() == dv.getId()) {
			// location.setSelectedIndex(index);
			// }
			index++;
		}
	}
}
