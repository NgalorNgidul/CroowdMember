package com.croowd.ui.member.client.profile;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisActivity;

import com.croowd.ui.member.client.json.MemberJso;
import com.google.gwt.user.client.ui.Widget;

public interface IProfile {
	void setActivity(Activity activity);

	public Widget getWidget();
	
	public void setData(MemberJso member);
	
	public MemberJso getData();

	public abstract class Activity extends SIMbiosisActivity {
		abstract void saveProfile();
	}
}
