package com.croowd.ui.member.client.invest;

import com.croowd.ui.member.client.json.InvestPlanJso;
import com.croowd.ui.member.client.json.ProspectJso;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class InvestListForm extends Composite implements IInvestList {

	Activity activity;

	private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

	interface ThisUiBinder extends UiBinder<Widget, InvestListForm> {
	}

	@UiField
	VerticalPanel appPanel;

	InvestResultList resultList = new InvestResultList();
	InvestEditorForm editorForm = new InvestEditorForm();

	public InvestListForm() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		resultList.setParent(this);
		editorForm.setParent(this);
		//
		appPanel.add(resultList);
	}

	@Override
	public void setActivity(Activity activity) {
		this.activity = activity;
		//
		editorForm.setActivity(activity);
	}

	@Override
	public Widget getWidget() {
		return this;
	}

	@Override
	public void editProspect(ProspectJso data) {
		appPanel.clear();
		// editorForm.setData(data);
		// appPanel.add(editorForm);
	}

	public void selectProspect(ProspectJso data) {
		editorForm.setProspect(data);
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
	public void addResultData(InvestPlanJso data) {
		resultList.addData(data);
	}

	@Override
	public void noResultData() {
		resultList.noData();
	}

	public void newData() {
		appPanel.clear();
		// editorForm.setData(JsonServerResponse.createProspectJso());
		appPanel.add(editorForm);
	}

	@Override
	public ProspectJso getProspect() {
		return editorForm.getData();
	}

	@Override
	public String getValue() {
		return editorForm.getValue();
	}
}
