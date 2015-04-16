package org.simbiosis.ui.croowd.member.client.json;

public class JsonServerResponse {

	public static final native SimpleProjectJso getProjectJso(
			String responseString) /*-{
		// You should be able to use a safe parser here
		// (like the one from json.org)
		return eval('(' + responseString + ')');
	}-*/;

}
