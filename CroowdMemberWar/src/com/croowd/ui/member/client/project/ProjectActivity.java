package com.croowd.ui.member.client.project;

import java.util.ArrayList;
import java.util.List;

import com.croowd.ui.member.client.AppFactory;
import com.croowd.ui.member.client.json.SimpleProjectJso;
import com.croowd.ui.member.client.places.ProjectPlace;
import com.croowd.ui.member.client.project.IProject.Activity;
import com.croowd.ui.member.client.project.input.IProjectInput;
import com.croowd.ui.member.client.project.input.ProjectInputActivity;
import com.croowd.ui.member.shared.ProjectDv;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DefaultDateTimeFormatInfo;
import com.google.gwt.user.client.Window;
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
		listProject(myForm);
		//

		this.panel.setWidget(myForm.getWidget());
	}

	public void listProject(final IProject myform) {
		String url = Window.Location.getProtocol() + "//"
				+ Window.Location.getHost() + "/prospect/"
				+ appFactory.getStatus().getSession() + "/listAll/";

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		try {
			builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable e) {
					Window.alert(e.getMessage());
				}

				public void onResponseReceived(Request request,
						Response response) {
					if (200 == response.getStatusCode()) {
						JsArray<SimpleProjectJso> projects = JsonUtils
								.<JsArray<SimpleProjectJso>> safeEval(response
										.getText());
						List<ProjectDv> list = generateListDv(projects);
						Window.alert("size dv : " + list.size());
						myform.setProjectData(list);
					} else {
						Window.alert("Received HTTP status code other than 200 : "
								+ response.getStatusText());
					}
				}
			});
		} catch (RequestException e) {
			// Couldn't connect to server
			Window.alert(e.getMessage());
		}
	}

	@Override
	public void editProject(ProjectDv dv) {
		IProjectInput inputForm = appFactory.getProjectInput();
		inputForm.setActivity(getInputActivity());
		inputForm.setData(dv);
		inputForm.viewer();
		panel.setWidget(inputForm.getWidget());
	}

	public List<ProjectDv> generateListDv(JsArray<SimpleProjectJso> jso) {
		List<ProjectDv> list = new ArrayList<ProjectDv>();
		for (int i = 0; i < jso.length(); i++) {
			ProjectDv dv = new ProjectDv();
			dv.setId(jso.get(i).getId());
			dv.setTitle(jso.get(i).getTitle());
			dv.setUserName(jso.get(i).getUserName());
			dv.setShortBlurb(jso.get(i).getShortBlurb());
			dv.setLocation(jso.get(i).getLocation());
			dv.setFunded(jso.get(i).getFunded());
			dv.setPledged(jso.get(i).getPledged());
			dv.setCategory(jso.get(i).getCategory());
			dv.setSubCategory(jso.get(i).getSubCategory());
			dv.setStrSubCategory(jso.get(i).getStrSubCategory());
			dv.setDuration(dtf.parse(jso.get(i).getStrDuration()));
			dv.setGoal(jso.get(i).getGoal());
			dv.setStrCategory(jso.get(i).getStrCategory());
			dv.setStrDuration(jso.get(i).getStrDuration());
			dv.setStrLocation(jso.get(i).getStrLocation());
			list.add(dv);
		}
		return list;
	}

}
