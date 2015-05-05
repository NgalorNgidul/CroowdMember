package com.croowd.ui.member.client.profile;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisActivity;

import com.google.gwt.user.client.ui.Widget;

public interface IProfile {
	void setActivity(Activity activity);

	public Widget getWidget();

	public abstract class Activity extends SIMbiosisActivity {
	}
}
