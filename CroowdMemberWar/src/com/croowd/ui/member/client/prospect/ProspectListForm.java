package com.croowd.ui.member.client.prospect;

import com.croowd.ui.member.client.json.JsonServerResponse;
import com.croowd.ui.member.client.json.ProspectJso;
import com.croowd.ui.member.client.prospecteditor.ProspectEditor;
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
	ProspectEditor editorForm = new ProspectEditor();

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
		editorForm.setActivity(activity);
	}

	@Override
	public Widget getWidget() {
		return this;
	}

	@Override
	public void editProspect(ProspectJso data) {
		appPanel.clear();
		editorForm.setData(data);
		appPanel.add(editorForm);
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

	public void newData() {
		appPanel.clear();
		editorForm.setData(JsonServerResponse.createProspectJso());
		appPanel.add(editorForm);
	}

	@Override
	public ProspectJso getData() {
		return editorForm.getData();
	}
}
