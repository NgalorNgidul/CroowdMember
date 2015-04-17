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

	public final native String getDescription() /*-{
		return this.description;
	}-*/;

	public final native String getCategory() /*-{
		return this.category;
	}-*/;

	public final native String getLocation() /*-{
		return this.location;
	}-*/;

	public final native String getPledged() /*-{
		return this.pledged;
	}-*/;

	public final native String getOwnerName() /*-{
		return this.ownerName;
	}-*/;

}
