package com.croowd.ui.member.client.project.input;

import java.util.List;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisActivity;

import com.croowd.ui.member.shared.CategoryDv;
import com.croowd.ui.member.shared.LocationDv;
import com.croowd.ui.member.shared.ProjectDv;
import com.google.gwt.user.client.ui.Widget;

public interface IProjectInput {

	void setActivity(Activity activity);

	public Widget getWidget();

	public void viewer();

	public void editor();

	public void setData(ProjectDv dv);

	public void setListCategory(List<CategoryDv> categorys);

	public void setListSubCategory(List<CategoryDv> subCategorys);

	public void setListLocation(List<LocationDv> locations);

	public abstract class Activity extends SIMbiosisActivity {
		public abstract void onBack();

		public abstract void changeSubCategory(String value);

		public abstract void onEdit(ProjectDv dv);

		public abstract void onSave(ProjectDv dv);
	}
}
