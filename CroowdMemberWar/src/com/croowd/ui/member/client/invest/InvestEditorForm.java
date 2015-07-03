package com.croowd.ui.member.client.invest;

import org.simbiosis.ui.gwt.client.editor.DoubleTextBox;

import com.croowd.ui.member.client.invest.IInvestList.Activity;
import com.croowd.ui.member.client.json.InvestPlanJso;
import com.croowd.ui.member.client.json.ProspectJso;
import com.croowd.ui.member.client.prospectdlg.ProspectDlg;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
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
	DoubleTextBox value;

	ProspectJso prospect = null;

	public InvestEditorForm() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		value.setValue(0D);
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

	public void setData(InvestPlanJso invest) {
		value.setValue(invest.getValue());
		setProspect(invest.getProspect());
	}

	@UiHandler("btnBack")
	void onBtnBack(ClickEvent e) {
		activity.onBack();
	}

	@UiHandler("btnSave")
	void onBtnSave(ClickEvent e) {
		if (value.getValue()<=0D){
			Window.alert("Anda harus mengisi nilai investasi");
		}else{
			activity.onSave();
		}
	}

	public ProspectJso getData() {
		return prospect;
	}

	public Double getValue() {
		return value.getValue();
	}
}
