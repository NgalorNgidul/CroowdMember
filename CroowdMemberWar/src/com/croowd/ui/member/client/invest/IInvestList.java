package com.croowd.ui.member.client.invest;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisActivity;

import com.croowd.ui.member.client.json.InvestPlanJso;
import com.croowd.ui.member.client.json.ProspectJso;
import com.google.gwt.user.client.ui.Widget;

public interface IInvestList {

	public void setActivity(Activity activity);

	public Widget getWidget();

	public void clearResultData();

	public void addResultData(InvestPlanJso data);

	public void noResultData();

	public void editProspect(ProspectJso data);

	public void backToList();

	public ProspectJso getProspect();

	public String getValue();

	public abstract class Activity extends SIMbiosisActivity {
		public abstract void onBack();

		public abstract void onSave();

	}
}
