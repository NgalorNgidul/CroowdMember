package com.croowd.ui.member.client.profile;

import com.croowd.ui.member.client.json.MemberJso;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

public class ProfileForm extends Composite implements IProfile,
		Editor<MemberJso> {

	Activity activity;

	private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

	interface ThisUiBinder extends UiBinder<Widget, ProfileForm> {
	}

	interface Driver extends SimpleBeanEditorDriver<MemberJso, ProfileForm> {
	}

	Driver driver = GWT.create(Driver.class);

	@UiField
	Button btnSave;
	@UiField
	TextBox name;
	@UiField
	TextBox pob;
	@UiField
	DateBox dob;
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

	public ProfileForm() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		driver.initialize(this);
	}

	@Override
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@Override
	public Widget getWidget() {
		return this;
	}

	@Override
	public void setData(MemberJso member) {
		driver.edit(member);
	}

}
