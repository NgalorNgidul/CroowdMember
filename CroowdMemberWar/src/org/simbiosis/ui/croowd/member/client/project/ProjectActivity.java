package org.simbiosis.ui.croowd.member.client.project;

import java.util.ArrayList;
import java.util.List;

import org.simbiosis.ui.croowd.member.client.AppFactory;
import org.simbiosis.ui.croowd.member.client.places.ProjectPlace;
import org.simbiosis.ui.croowd.member.client.project.IProject.Activity;
import org.simbiosis.ui.croowd.member.client.project.input.IProjectInput;
import org.simbiosis.ui.croowd.member.client.project.input.ProjectInputActivity;
import org.simbiosis.ui.croowd.member.shared.ProjectDv;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DefaultDateTimeFormatInfo;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ProjectActivity extends Activity {

	String pattern = "dd-MM-yyyy"; /* your pattern here */
	DefaultDateTimeFormatInfo info = new DefaultDateTimeFormatInfo();
	DateTimeFormat dtf = new DateTimeFormat(pattern, info) {
	}; // <= trick here

	ProjectPlace myPlace;
	AppFactory appFactory;
	ProjectInputActivity inputActivity;

	AcceptsOneWidget panel;

	public ProjectActivity(ProjectPlace myPlace, AppFactory appFactory) {
		super();
		setFactory(appFactory);
		this.myPlace = myPlace;
		this.appFactory = appFactory;
	}

	ProjectInputActivity getInputActivity() {
		if (inputActivity == null) {
			inputActivity = new ProjectInputActivity(new ProjectPlace(""),
					appFactory);
		}
		return inputActivity;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.panel = panel;
		IProject myForm = appFactory.getProject();
		myForm.setActivity(this);
		//
		loadProjectData(myForm);
		//

		this.panel.setWidget(myForm.getWidget());
	}

	private void loadProjectData(IProject myForm) {
		List<ProjectDv> list = new ArrayList<ProjectDv>();
		ProjectDv data = new ProjectDv();
		data.setTitle("This is Title");
		data.setShortBlurb("this is shortblub");
		data.setLocation("tangerang");
		data.setPledged("Rp.1000");
		data.setFunded("10%");
		data.setUserName("Nanang Hendro Sucahyo");
		data.setDuration(dtf.parse("09-04-2015"));
		data.setStrDuration(dtf.format(data.getDuration()));
		data.setGoal("RP 10.000,00");
		data.setCategory("category1");
		data.setSubCategory("category child1 0");
		list.add(data);

		data = new ProjectDv();
		data.setTitle("This is Title 2");
		data.setShortBlurb("this is shortblub");
		data.setLocation("tangerang");
		data.setPledged("Rp.1000");
		data.setFunded("10%");
		data.setUserName("Nanang Hendro Sucahyo");
		list.add(data);
		myForm.setProjectData(list);
	}

	@Override
	public void editProject(ProjectDv dv) {
		IProjectInput inputForm = appFactory.getProjectInput();
		inputForm.setActivity(getInputActivity());
		inputForm.setData(dv);
		inputForm.viewer();
		panel.setWidget(inputForm.getWidget());
	}

}
