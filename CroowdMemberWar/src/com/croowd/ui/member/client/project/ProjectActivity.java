package com.croowd.ui.member.client.project;

import com.croowd.ui.member.client.AppFactory;
import com.croowd.ui.member.client.json.ProspectJso;
import com.croowd.ui.member.client.places.Project;
import com.croowd.ui.member.client.project.IProject.Activity;
import com.croowd.ui.member.client.project.input.IProjectInput;
import com.croowd.ui.member.client.project.input.ProjectInputActivity;
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

	Project myPlace;
	AppFactory appFactory;
	ProjectInputActivity inputActivity;

	AcceptsOneWidget panel;

	public ProjectActivity(Project myPlace, AppFactory appFactory) {
		super();
		setFactory(appFactory);
		this.myPlace = myPlace;
		this.appFactory = appFactory;
	}

	ProjectInputActivity getInputActivity() {
		if (inputActivity == null) {
			inputActivity = new ProjectInputActivity(new Project(""),
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
		String url = "http://api.croowd.co.id/prospect/"
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
						JsArray<ProspectJso> projects = JsonUtils
								.<JsArray<ProspectJso>> safeEval(response
										.getText());
						myform.setProjectData(projects);
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
	public void editProject(ProspectJso dv) {
		IProjectInput inputForm = appFactory.getProjectInput();
		inputForm.setActivity(getInputActivity());
		inputForm.setData(dv);
		inputForm.viewer();
		panel.setWidget(inputForm.getWidget());
	}

}
