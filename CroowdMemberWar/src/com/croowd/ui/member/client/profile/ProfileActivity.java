package com.croowd.ui.member.client.profile;

import com.croowd.ui.member.client.AppFactory;
import com.croowd.ui.member.client.json.JsonServerResponse;
import com.croowd.ui.member.client.json.MemberJso;
import com.croowd.ui.member.client.profile.IProfile.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ProfileActivity extends Activity {

	Place myPlace;
	AppFactory appFactory;
	Activity activity;

	public ProfileActivity(Place myPlace, AppFactory appFactory) {
		setFactory(appFactory);
		this.myPlace = myPlace;
		this.appFactory = appFactory;
		activity = this;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		IProfile myForm = appFactory.getProfileForm();
		myForm.setActivity(this);
		//
		loadMember();
		//
		panel.setWidget(myForm.getWidget());
	}
	
	private void loadMember(){
		String url = "http://api.croowd.co.id/member/getBySession/" + getSession();

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		try {
			builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable e) {
					Window.alert(e.getMessage());
				}

				public void onResponseReceived(Request request,
						Response response) {
					if (200 == response.getStatusCode()) {
						MemberJso jso = JsonServerResponse
								.getMemberJso(response.getText());
						processResult(jso);
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
	
	private void processResult(MemberJso member){
		IProfile myForm = appFactory.getProfileForm();
		myForm.setData(member);
	}

}
