package com.croowd.ui.validation.client.main;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainForm extends Composite {

	private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

	interface ThisUiBinder extends UiBinder<Widget, MainForm> {
	}

	@UiField
	DockLayoutPanel sidebarParentPanel;
	@UiField
	VerticalPanel sidebarPanel;
	@UiField
	SimpleLayoutPanel appPanel;
	@UiField
	Label appPath;
	@UiField
	HTMLPanel logoPanel;

	public MainForm() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		appPath.setText("Croowd / Member / Validasi member");
	}

	@Override
	public Widget getWidget() {
		return this;
	}

	public void addAppPanel(Widget appWidget){
		appPanel.add(appWidget);
	}
}
