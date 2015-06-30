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

	public final Long getProspectId() {
		long lValue = getNativeProspectId();
		return lValue;
	}

	public final void setProspectId(Long prospectId) {
		int iValue = prospectId.intValue();
		setNativeProspectId(iValue);
	}

	public final native int getNativeProspectId() /*-{
		return this.prospectId;
	}-*/;

	public final native void setNativeProspectId(int prospectId) /*-{
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

}
