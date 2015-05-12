package com.croowd.ui.member.client.invest;

import com.croowd.ui.member.client.invest.IInvestList.Activity;
import com.croowd.ui.member.client.json.ProspectJso;
import com.croowd.ui.member.client.prospectdlg.ProspectDlg;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class InvestEditorForm extends Composite {

	Activity activity;
	InvestListForm parentForm;

	private static InvestEditorFormUiBinder uiBinder = GWT
			.create(InvestEditorFormUiBinder.class);

	interface InvestEditorFormUiBinder extends
			UiBinder<Widget, InvestEditorForm> {
	}

	@UiField
	HorizontalPanel prospectWidget;
	@UiField
	TextBox value;

	ProspectJso prospect = null;

	public InvestEditorForm() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		Button button = new Button("Cari Prospek");
		button.setStyleName("fieldbutton");
		button.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				ProspectDlg dlg = new ProspectDlg();
				dlg.setParent(parentForm);
				dlg.center();
			}
		});
		prospectWidget.add(button);
	}

	public void setParent(InvestListForm parentForm) {
		this.parentForm = parentForm;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public void setProspect(ProspectJso prospect) {
		prospectWidget.clear();
		ProspectViewerWidget pvw = new ProspectViewerWidget();
		pvw.setData(prospect);
		this.prospect = prospect;
		prospectWidget.add(pvw);
	}

	@UiHandler("btnBack")
	void onBtnBack(ClickEvent e) {
		activity.onBack();
	}

	@UiHandler("btnSave")
	void onBtnSave(ClickEvent e) {
		activity.onSave();
	}

	public ProspectJso getData() {
		return prospect;
	}

	public String getValue() {
		return value.getText();
	}
}
