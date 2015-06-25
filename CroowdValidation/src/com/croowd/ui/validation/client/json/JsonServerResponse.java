package com.croowd.ui.validation.client.json;

import org.simbiosis.ui.gwt.client.json.ConfigJso;

public class JsonServerResponse {

	public static final native RegistrationJso getRegistrationJso(
			String responseString) /*-{
		// You should be able to use a safe parser here
		// (like the one from json.org)
		return eval('(' + responseString + ')');
	}-*/;

	public static final native ConfigJso getConfigJso(String responseString) /*-{
		// You should be able to use a safe parser here
		// (like the one from json.org)
		return eval('(' + responseString + ')');
	}-*/;

}
