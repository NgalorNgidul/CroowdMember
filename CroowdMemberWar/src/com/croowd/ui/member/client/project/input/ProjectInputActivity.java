package com.croowd.ui.member.client.project.input;

import java.util.ArrayList;
import java.util.List;

import com.croowd.ui.member.client.AppFactory;
import com.croowd.ui.member.client.project.input.IProjectInput.Activity;
import com.croowd.ui.member.shared.CategoryDv;
import com.croowd.ui.member.shared.LocationDv;
import com.croowd.ui.member.shared.ProjectDv;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ProjectInputActivity extends Activity {

	Place myPlace;
	AppFactory appFactory;
	Activity activity;

	public ProjectInputActivity(Place myPlace, AppFactory appFactory) {
		setFactory(appFactory);
		this.myPlace = myPlace;
		this.appFactory = appFactory;
		activity = this;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {

	}

	@Override
	public void onBack() {
		appFactory.getPlaceController().goTo(myPlace);
	}

	@Override
	public void changeSubCategory(String value) {
		IProjectInput myForm = appFactory.getProjectInput();
		myForm.setListSubCategory(generateSubCategory(new Integer(value)));

	}

	public List<CategoryDv> generateSubCategory(int index) {
		List<CategoryDv> list = new ArrayList<CategoryDv>();
		for (int i = 1; i <= 3; i++) {
			CategoryDv dv = new CategoryDv();
			dv.setId(new Long(i));
			dv.setName("category child" + index + " " + i);
			list.add(dv);
		}
		return list;
	}

	@Override
	public void onEdit(ProjectDv dv) {
		IProjectInput formEditor = appFactory.getProjectInput();
		formEditor.editor();
		formEditor.setListCategory(generateCategory());
		formEditor.setListLocation(generateLocation());
		formEditor.setListSubCategory(generateSubCategory(0));
	}

	public List<CategoryDv> generateCategory() {
		List<CategoryDv> list = new ArrayList<CategoryDv>();
		for (int i = 1; i <= 5; i++) {
			CategoryDv dv = new CategoryDv();
			dv.setId(new Long(i));
			dv.setName("category" + i);
			list.add(dv);
		}
		return list;
	}

	public List<LocationDv> generateLocation() {
		List<LocationDv> list = new ArrayList<LocationDv>();
		for (int i = 1; i <= 3; i++) {
			LocationDv dv = new LocationDv();
			dv.setId(new Long(i));
			dv.setName("Location " + i);
			list.add(dv);
		}
		return list;
	}

	@Override
	public void onSave(ProjectDv dv) {
		Window.alert("id category: " + dv.getCategory());

	}

}
