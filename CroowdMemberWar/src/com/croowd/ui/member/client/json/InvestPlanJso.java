package com.croowd.ui.member.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class InvestPlanJso extends JavaScriptObject {

	protected InvestPlanJso() {
	}

	public final native void setSession(String session)/*-{
		this.session = session;
	}-*/;

	public final native String getMemberName() /*-{
		return this.memberName;
	}-*/;

	public final native Long getId() /*-{
		return this.id;
	}-*/;

	public final native Long getProspectId() /*-{
		return this.prospectId;
	}-*/;

	public final native void setProspectId(Long prospectId) /*-{
		this.prospectId = prospectId;
	}-*/;

	public final native ProspectJso getProspect() /*-{
		return this.prospect;
	}-*/;

	public final native double getValue() /*-{
		return this.value;
	}-*/;

	public final native void setValue(double value) /*-{
		this.value = value;
	}-*/;

	public final String getStrValue() {
		return new Double(getValue()).toString();
	}

	public final void setStrValue(String strValue) {
		String value = strValue.replace(",", "");
		Double dValue = Double.parseDouble(value);
		setValue(dValue);
	};

}
