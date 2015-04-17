package com.croowd.ui.member.client.json;

public class JsonServerResponse {

	public static final native ProspectJso getProjectJso(
			String responseString) /*-{
		// You should be able to use a safe parser here
		// (like the one from json.org)
		return eval('(' + responseString + ')');
	}-*/;

}
