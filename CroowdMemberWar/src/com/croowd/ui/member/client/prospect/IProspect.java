package com.croowd.ui.member.client.prospect;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisActivity;

import com.google.gwt.user.client.ui.Widget;

public interface IProspect {
	void setActivity(Activity activity);

	public Widget getWidget();

	public abstract class Activity extends SIMbiosisActivity {
	}
}
