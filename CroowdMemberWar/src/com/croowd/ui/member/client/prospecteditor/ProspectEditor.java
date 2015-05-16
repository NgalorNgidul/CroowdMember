package com.croowd.ui.member.client.prospecteditor;

import org.simbiosis.ui.gwt.client.editor.DoubleTextBox;
import org.simbiosis.ui.gwt.client.editor.IntegerTextBox;

import com.croowd.ui.member.client.json.ProspectJso;
import com.croowd.ui.member.client.prospect.IProspectList.Activity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ProspectEditor extends Composite implements Editor<ProspectJso> {

	Activity activity;

	private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

	interface ThisUiBinder extends UiBinder<Widget, ProspectEditor> {
	}

	interface Driver extends
			SimpleBeanEditorDriver<ProspectJso, ProspectEditor> {
	}

	Driver driver = GWT.create(Driver.class);

	/*
	 * @UiField TabLayoutPanel viewCust;
	 */

	@UiField
	TextBox title;
	@UiField
	TextBox location;
	@UiField
	DoubleTextBox principal;
	@UiField
	IntegerTextBox tenor;
	@UiField
	TextArea shortDescription;
	@UiField
	TextArea description;

	@UiField
	Button btnSave;
	@UiField
	Button btnBack;

	public ProspectEditor() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		driver.initialize(this);
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public void setData(ProspectJso data) {
		driver.edit(data);
	}

	public ProspectJso getData() {
		return driver.flush();
	}

	@UiHandler("btnSave")
	void onBtnSave(ClickEvent e) {
		activity.onSave();
	}

	@UiHandler("btnBack")
	void onBtnBack(ClickEvent e) {
		activity.onBack();
	}
}
