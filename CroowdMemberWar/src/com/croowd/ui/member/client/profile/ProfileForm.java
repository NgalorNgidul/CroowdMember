package com.croowd.ui.member.client.profile;

import java.util.ArrayList;
import java.util.List;

import com.croowd.ui.member.client.component.IdTypeComboBox;
import com.croowd.ui.member.client.component.IdTypeDv;
import com.croowd.ui.member.client.json.MemberJso;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
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
	IdTypeComboBox idType;
	@UiField
	TextBox idCode;
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
	TextBox fixPhone;
	@UiField
	TextBox cellPhone;

	public ProfileForm() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		List<IdTypeDv> idTypes = new ArrayList<IdTypeDv>();
		idTypes.add(new IdTypeDv(1,"KTP"));
		idTypes.add(new IdTypeDv(2,"PASPOR"));
		idType.setList(idTypes);
		//
		dob.setFormat(new DateBox.DefaultFormat(DateTimeFormat
				.getFormat("dd-MM-yyyy")));
		//
		fixPhone.getElement().setPropertyString("placeholder", "No telpon rumah");
		cellPhone.getElement().setPropertyString("placeholder", "No telpon seluler");
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

	@Override
	public MemberJso getData() {
		return driver.flush();
	}

	@UiHandler("btnSave")
	public void onSave(ClickEvent e) {
		activity.saveProfile();
	}
}
