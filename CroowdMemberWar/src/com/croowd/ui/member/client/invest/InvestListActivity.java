package com.croowd.ui.member.client.invest;

import com.croowd.ui.member.client.AppFactory;
import com.croowd.ui.member.client.json.ProspectJso;
import com.croowd.ui.member.client.places.ProspectList;
import com.croowd.ui.member.client.prospect.IProspectList.Activity;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class InvestListActivity extends Activity {

	// String pattern = "dd-MM-yyyy"; /* your pattern here */
	// DefaultDateTimeFormatInfo info = new DefaultDateTimeFormatInfo();
	// DateTimeFormat dtf = new DateTimeFormat(pattern, info) {
	// }; // <= trick here

	ProspectList myPlace;
	AppFactory appFactory;

	public InvestListActivity(ProspectList myPlace, AppFactory appFactory) {
		super();
		setFactory(appFactory);
		this.myPlace = myPlace;
		this.appFactory = appFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		IInvestList myForm = appFactory.getProspectList();
		myForm.setActivity(this);
		//
		loadProspect();
		//
		panel.setWidget(myForm.getWidget());
	}

	private void loadProspect() {
		String url = "http://api.croowd.co.id/prospect/" + getSession()
				+ "/listAllByOwner/";

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		try {
			builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable e) {
					Window.alert(e.getMessage());
				}

				public void onResponseReceived(Request request,
						Response response) {
					if (200 == response.getStatusCode()) {
						IInvestList myForm = appFactory.getProspectList();
						JsArray<ProspectJso> projects = JsonUtils
								.<JsArray<ProspectJso>> safeEval(response
										.getText());
						myForm.clearResultData();
						if (projects.length() > 0) {
							for (int i = 0; i < projects.length(); i++) {
								myForm.addResultData(projects.get(i));
							}
						} else {
							myForm.noResultData();
						}
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

	private void reloadResultList(){
		IInvestList myForm = appFactory.getProspectList();
		myForm.backToList();
		myForm.clearResultData();
		loadProspect();
	}
	
	@Override
	public void onBack() {
		IInvestList myForm = appFactory.getProspectList();
		myForm.backToList();
	}

	@Override
	public void onSave() {
		String url = "http://api.croowd.co.id/prospect/" + getSession()
				+ "/save/";

		IInvestList myForm = appFactory.getProspectList();
		ProspectJso jso = myForm.getData();
		jso.setSessionName(getSession());
		RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, url);
		try {
			builder.setHeader("Content-Type", "application/json");
			builder.sendRequest(new JSONObject(jso).toString(),
					new RequestCallback() {
						public void onError(Request request, Throwable e) {
							Window.alert(e.getMessage());
						}

						public void onResponseReceived(Request request,
								Response response) {
							if (200 == response.getStatusCode()) {
								reloadResultList();
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

}
