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

	public final native int getTenor() /*-{
		return this.tenor;
	}-*/;

	public final native void setTenor(int tenor) /*-{
		this.tenor = tenor;
	}-*/;

	public final native int getCampaignPeriod() /*-{
		return this.campaignPeriod;
	}-*/;

	public final native void setCampaignPeriod(int campaignPeriod) /*-{
		this.campaignPeriod = campaignPeriod;
	}-*/;

	public final native void setSession(String session) /*-{
		this.session = session;
	}-*/;

}
