package com.croowd.ui.validation.client.userform;

import com.croowd.ui.validation.shared.MemberDv;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class UserEditor extends Composite implements Editor<MemberDv> {

	interface ThisUiBinder extends UiBinder<Widget, UserEditor> {
	}

	private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

	interface Driver extends SimpleBeanEditorDriver<MemberDv, UserEditor> {
	}

	Driver driver = GWT.create(Driver.class);

	@UiField
	Button btnSave;
	@UiField
	Button btnCancel;
	@UiField
	TextBox name;
	@UiField
	TextBox address;
	@UiField
	TextBox city;
	@UiField
	TextBox zipCode;
	@UiField
	TextBox province;
	@UiField
	TextBox phone;
	@UiField
	PasswordTextBox password;
	@UiField
	PasswordTextBox passwordconf;

	public UserEditor() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		driver.initialize(this);
		driver.edit(new MemberDv());
	}

	@UiHandler("btnSave")
	public void onSave(ClickEvent e) {

	}

	@UiHandler("btnCancel")
	public void onCancel(ClickEvent e) {
		// showViewForm();
	}

}
