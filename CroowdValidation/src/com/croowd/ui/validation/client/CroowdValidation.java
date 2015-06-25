package com.croowd.ui.validation.client;

import org.simbiosis.ui.gwt.client.json.ConfigJso;

import com.croowd.ui.validation.client.json.JsonServerResponse;
import com.croowd.ui.validation.client.json.RegistrationJso;
import com.croowd.ui.validation.client.main.MainForm;
import com.croowd.ui.validation.client.notvalidform.NotValidForm;
import com.croowd.ui.validation.client.userform.UserEditor;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CroowdValidation implements EntryPoint {

	MainForm mainForm;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// Load configuration
		loadConfiguration();
	}

	private void loadConfiguration() {
		String function = "/systemuiapi/config/";
		String url = Window.Location.getProtocol() + "//"
				+ Window.Location.getHost() + function;
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		try {
			builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable e) {
					Window.alert(e.getMessage());
				}

				public void onResponseReceived(Request request,
						Response response) {
					if (200 == response.getStatusCode()) {
						if (!response.getText().isEmpty()) {
							ConfigJso config = JsonServerResponse
									.getConfigJso(response.getText());
							// Ambil string hash
							// Bentuknya #xxxxxxxxxxxxxxxxxxxxxxxx, ambil
							// setelah tanda #
							String hash = Window.Location.getHash()
									.substring(1);
							validation(hash, config.getAppApi());
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

	private void validation(String hash, final String urlApi) {
		String function = "/registration/validate/";
		String url = Window.Location.getProtocol() + "//" + urlApi + function
				+ hash;

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		try {
			builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable e) {
					Window.alert(e.getMessage());
				}

				public void onResponseReceived(Request request,
						Response response) {
					if (200 == response.getStatusCode()) {
						RegistrationJso jso = JsonServerResponse
								.getRegistrationJso(response.getText());
						processResult(jso, urlApi);
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

	private void processResult(RegistrationJso jso, String urlApi) {
		mainForm = new MainForm();
		if (jso != null) {
			UserEditor editor = new UserEditor();
			editor.setUrlApi(urlApi);
			editor.setData(jso);
			mainForm.addAppPanel(editor);
			// Go to profile
		} else {
			mainForm.addAppPanel(new NotValidForm());
		}
		RootLayoutPanel.get().add(mainForm);
	}
}
