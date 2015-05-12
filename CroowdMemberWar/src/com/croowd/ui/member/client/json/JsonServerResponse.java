package com.croowd.ui.member.client.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class JsonServerResponse {

	public static ProspectJso createProspectJso() {
		ProspectJso prospect = (ProspectJso) JavaScriptObject.createObject()
				.cast();
		prospect.setPrincipal(0D);
		prospect.setTenor(0);
		return prospect;
	}

	public static InvestPlanJso createInvestPlanJso() {
		InvestPlanJso plan = (InvestPlanJso) JavaScriptObject.createObject()
				.cast();
		return plan;
	}

	public static final native ProspectJso getProjectJso(String responseString) /*-{
		// You should be able to use a safe parser here
		// (like the one from json.org)
		return eval('(' + responseString + ')');
	}-*/;

	public static final native JsArray<ProspectJso> getListProjectJso(
			String responseString)/*-{
		// You should be able to use a safe parser here
		// (like the one from json.org)
		return eval('(' + responseString + ')');
	}-*/;

	public static final native MemberJso getMemberJso(String responseString) /*-{
		// You should be able to use a safe parser here
		// (like the one from json.org)
		return eval('(' + responseString + ')');
	}-*/;

}
