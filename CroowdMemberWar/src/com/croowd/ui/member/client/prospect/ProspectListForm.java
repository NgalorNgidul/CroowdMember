package com.croowd.ui.member.client.prospect;

import org.simbiosis.ui.gwt.client.SIMbiosisStatus;

import com.croowd.ui.member.client.json.JsonServerResponse;
import com.croowd.ui.member.client.json.ProspectJso;
import com.croowd.ui.member.client.prospecteditor.ProspectEditor;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ProspectListForm extends Composite implements IProspectList {

	Activity activity;
	SIMbiosisStatus status;

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
	}

	@Override
	public void setActivity(Activity activity, SIMbiosisStatus status) {
		this.activity = activity;
		this.status = status;
		//
		editorForm.setActivity(activity);
		resultList.setParent(this, status);
		appPanel.add(resultList);
	}

	@Override
	public Widget getWidget() {
		return this;
	}

	@Override
	public void editProspect(ProspectJso data) {
		appPanel.clear();
		editorForm.setData(status.getSimbiosisApi(), data);
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
		editorForm.setData(status.getSimbiosisApi(),
				JsonServerResponse.createProspectJso());
		appPanel.add(editorForm);
	}

	@Override
	public ProspectJso getData() {
		return editorForm.getData();
	}

	public void refreshResult() {
		activity.refreshResult();
	}

	@Override
	public int getFilter() {
		return resultList.getFilter();
	}

	@Override
	public void setCategories(JsArrayString categories) {
		editorForm.setCategories(categories);
	}
}
