package com.croowd.ui.validation.client.userform;

import com.croowd.ui.validation.client.json.RegistrationJso;
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
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class UserEditor extends Composite implements Editor<RegistrationJso> {

	interface ThisUiBinder extends UiBinder<Widget, UserEditor> {
	}

	private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

	interface Driver extends SimpleBeanEditorDriver<RegistrationJso, UserEditor> {
	}

	Driver driver = GWT.create(Driver.class);

	@UiField
	Button btnSave;
	@UiField
	Button btnCancel;
	@UiField
	TextBox name;
	@UiField
	Label email;
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
	}

	public void setData(RegistrationJso jso){
		driver.edit(jso);
	}
	
	@UiHandler("btnSave")
	public void onSave(ClickEvent e) {

	}

	@UiHandler("btnCancel")
	public void onCancel(ClickEvent e) {
		// showViewForm();
	}

}
