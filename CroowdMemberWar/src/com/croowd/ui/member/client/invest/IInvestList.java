package com.croowd.ui.member.client.invest;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisActivity;

import com.croowd.ui.member.client.json.InvestPlanJso;
import com.croowd.ui.member.client.json.ProspectJso;
import com.google.gwt.user.client.ui.Widget;

public interface IInvestList {

	public void setActivity(Activity activity);

	public Widget getWidget();
	
	public int getFilter();

	public void clearResultData();

	public void addResultData(InvestPlanJso data);

	public void noResultData();
	
	public void newData(ProspectJso prospect);

	public void editInvest(InvestPlanJso data);

	public void backToList();

	public ProspectJso getProspect();

	public Double getValue();

	public abstract class Activity extends SIMbiosisActivity {
		public abstract void refreshResult();
		
		public abstract void onBack();

		public abstract void onSave();

	}
}
