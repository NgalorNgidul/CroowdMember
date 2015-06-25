package com.croowd.ui.validation.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class ConfigJso extends JavaScriptObject {

	protected ConfigJso() {

	}

	public final native String getAppApi() /*-{
		return this.appApi;
	}-*/;

	public final native String getSimbiosisApi() /*-{
		return this.simbiosisApi;
	}-*/;
}
