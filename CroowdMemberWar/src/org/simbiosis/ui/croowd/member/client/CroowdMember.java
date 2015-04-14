package org.simbiosis.ui.croowd.member.client;

import com.google.gwt.core.client.EntryPoint;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CroowdMember implements EntryPoint {

	public void onModuleLoad() {
		new AppEntryPoint(getClass().getSimpleName()).start();
	}
}
