package com.croowd.ui.member.client.prospecteditor;

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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ProspectViewer extends Composite implements Editor<ProspectJso> {

	Activity activity;

	private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

	interface ThisUiBinder extends UiBinder<Widget, ProspectViewer> {
	}

	interface Driver extends SimpleBeanEditorDriver<ProspectJso, ProspectViewer> {
	}

	Driver driver = GWT.create(Driver.class);

	/*
	 * @UiField TabLayoutPanel viewCust;
	 */

	@UiField
	Label title;
	@UiField
	Label location;
	@UiField
	Label principal;
	@UiField
	Label tenor;
	@UiField
	Label description;

	@UiField
	Button btnBack;

	public ProspectViewer() {
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

	@UiHandler("btnBack")
	void onBtnBack(ClickEvent e) {
		activity.onBack();
	}
}
