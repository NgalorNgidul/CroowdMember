package com.croowd.ui.member.client.prospect;

import com.croowd.ui.member.client.json.ProspectJso;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ProspectListForm extends Composite implements IProspectList {

	Activity activity;

	private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

	interface ThisUiBinder extends UiBinder<Widget, ProspectListForm> {
	}

	@UiField
	VerticalPanel appPanel;

	ProspectResultList resultList = new ProspectResultList();
	ApprovalForm approvalForm = new ApprovalForm();

	public ProspectListForm() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		resultList.setParent(this);
		appPanel.add(resultList);
	}

	@Override
	public void setActivity(Activity activity) {
		this.activity = activity;
		//
		approvalForm.setActivity(activity);
	}

	@Override
	public Widget getWidget() {
		return this;
	}

	@Override
	public void reviewProspect(ProspectJso data) {
		appPanel.clear();
		approvalForm.setData(data);
		appPanel.add(approvalForm);
	}

	@Override
	public void backToList() {
		appPanel.clear();
		appPanel.add(resultList);
	}

	@Override
	public void clearResultData() {
		resultList.clearData();
	}


	@Override
	public void addResultData(ProspectJso data) {
		resultList.addData(data);
	}

	@Override
	public void noResultData() {
		resultList.noData();
	}

}
