package org.simbiosis.ui.croowd.member.client.project;

import java.util.List;

import org.simbiosis.ui.croowd.member.shared.ProjectDv;
import org.simbiosis.ui.gwt.client.mvp.SIMbiosisActivity;

import com.google.gwt.user.client.ui.Widget;

public interface IProject {

	public void setActivity(Activity activity);

	public Widget getWidget();

	public void setProjectData(List<ProjectDv> data);

	public abstract class Activity extends SIMbiosisActivity {
		public abstract void editProject(ProjectDv dv);
	}
}
