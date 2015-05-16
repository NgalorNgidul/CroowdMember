package com.croowd.ui.member.client.invest;

import com.croowd.ui.member.client.json.ProspectJso;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.NumberLabel;
import com.google.gwt.user.client.ui.Widget;

public class ProspectViewerWidget extends Composite implements
		Editor<ProspectJso> {

	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	interface MyUiBinder extends UiBinder<Widget, ProspectViewerWidget> {
	}

	interface Driver extends
			SimpleBeanEditorDriver<ProspectJso, ProspectViewerWidget> {
	}

	Driver driver = GWT.create(Driver.class);
	@UiField
	Label title;
	@UiField
	Label location;
	@UiField
	NumberLabel<Double> principal;
	@UiField
	NumberLabel<Integer> tenor;
	@UiField
	Label shortDescription;
	@UiField
	Label description;

	public ProspectViewerWidget() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		driver.initialize(this);
	}

	public void setData(ProspectJso prospect) {
		driver.edit(prospect);
	}
}
