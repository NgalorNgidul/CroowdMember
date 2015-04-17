package com.croowd.ui.member.client.project;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisActivity;

import com.croowd.ui.member.client.json.ProspectJso;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.Widget;

public interface IProject {

	public void setActivity(Activity activity);

	public Widget getWidget();

	public void setProjectData(JsArray<ProspectJso> data);

	public abstract class Activity extends SIMbiosisActivity {
		public abstract void editProject(ProspectJso dv);
	}
}
