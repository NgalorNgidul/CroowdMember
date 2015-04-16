package com.croowd.ui.validation.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CroowdValidation implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// Ambil string hash
		// Bentuknya #xxxxxxxxxxxxxxxxxxxxxxxx
		String hash = Window.Location.getHash();
		Window.alert(hash);
	}
}
