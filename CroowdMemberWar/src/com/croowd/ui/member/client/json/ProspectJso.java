package com.croowd.ui.member.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class ProspectJso extends JavaScriptObject {
	protected ProspectJso() {
	}

	public final native Long getId() /*-{
		return this.id;
	}-*/;

	public final native String getTitle() /*-{
		return this.title;
	}-*/;

	public final native void setTitle(String title) /*-{
		this.title = title;
	}-*/;

	public final native String getShortDescription() /*-{
		return this.shortDescription;
	}-*/;

	public final native void setShortDescription(String shortDescription) /*-{
		this.shortDescription = shortDescription;
	}-*/;

	public final native String getDescription() /*-{
		return this.description;
	}-*/;

	public final native void setDescription(String description) /*-{
		this.description = description;
	}-*/;

	public final native String getCategory() /*-{
		return this.category;
	}-*/;

	public final native String getLocation() /*-{
		return this.location;
	}-*/;

	public final native void setLocation(String location) /*-{
		this.location = location;
	}-*/;

	public final native String getPledged() /*-{
		return this.pledged;
	}-*/;

	public final native String getOwnerName() /*-{
		return this.ownerName;
	}-*/;

	public final native double getPrincipal() /*-{
		return this.principal;
	}-*/;

	public final native void setPrincipal(double principal) /*-{
		this.principal = principal;
	}-*/;

	public final String getStrPrincipal() {
		return new Double(getPrincipal()).toString();
	}

	public final void setStrPrincipal(String principal) {
		String value = principal.replace(",", "");
		Double dValue = Double.parseDouble(value);
		setPrincipal(dValue);
	};

	public final native int getTenor() /*-{
		return this.tenor;
	}-*/;

	public final native void setTenor(int tenor) /*-{
		this.tenor = tenor;
	}-*/;

	public final String getStrTenor() {
		return new Integer(getTenor()).toString();
	}

	public final void setStrTenor(String tenor) {
		String value = tenor;
		if (value.isEmpty()) {
			value = "0";
		}
		setTenor(Integer.parseInt(value));
	}

	public final native void setSessionName(String sessionName) /*-{
		this.sessionName = sessionName;
	}-*/;

}
