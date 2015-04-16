package org.simbiosis.ui.croowd.member.client.json;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;

public class SimpleProjectJso extends JavaScriptObject {
	protected SimpleProjectJso() {
	}

	public final native Long getId() /*-{
		return this.id;
	}-*/;

	public final native String getTitle() /*-{
		return this.title;
	}-*/;

	public final native String getShortBlurb() /*-{
		return this.shortBlurb;
	}-*/;

	public final native Long getLocation() /*-{
		return this.location;
	}-*/;

	public final native String getStrLocation() /*-{
		return this.strLocation;
	}-*/;

	public final native String getFunded() /*-{
		return this.funded;
	}-*/;

	public final native String getPledged() /*-{
		return this.pledged;
	}-*/;

	public final native String getUserName() /*-{
		return this.userName;
	}-*/;

	public final native Long getCategory() /*-{
		return this.category;
	}-*/;

	public final native String getStrCategory() /*-{
		return this.strCategory;
	}-*/;

	public final native Long getSubCategory() /*-{
		return this.subCategory;
	}-*/;

	public final native String getStrSubCategory() /*-{
		return this.strSubCategory;
	}-*/;

	public final native Date getDuration() /*-{
		return this.duration;
	}-*/;

	public final native String getStrDuration() /*-{
		return this.strDuration;
	}-*/;

	public final native String getGoal() /*-{
		return this.goal;
	}-*/;

}
