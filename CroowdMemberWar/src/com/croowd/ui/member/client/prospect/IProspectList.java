package com.croowd.ui.member.client.prospect;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisActivity;

import com.croowd.ui.member.client.json.ProspectJso;
import com.google.gwt.user.client.ui.Widget;

public interface IProspectList {

	public void setActivity(Activity activity);

	public Widget getWidget();

	public void clearResultData();

	public void addResultData(ProspectJso data);

	public void noResultData();

	public void editProspect(ProspectJso data);

	public void backToList();

	public ProspectJso getData();

	public abstract class Activity extends SIMbiosisActivity {
		public abstract void onBack();

		public abstract void onSave();

	}
}
