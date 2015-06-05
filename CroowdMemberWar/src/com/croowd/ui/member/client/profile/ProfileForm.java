package com.croowd.ui.member.client.profile;

import java.util.ArrayList;
import java.util.List;

import org.simbiosis.ui.gwt.client.editor.DoubleTextBox;
import org.simbiosis.ui.gwt.client.editor.IntegerTextBox;

import com.croowd.ui.member.client.component.DateSelectorBox;
import com.croowd.ui.member.client.component.IntegerTypeComboBox;
import com.croowd.ui.member.client.component.IntegerTypeDv;
import com.croowd.ui.member.client.json.MemberJso;
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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

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
	IntegerTypeComboBox sex;
	@UiField
	TextBox motherName;
	@UiField
	IntegerTypeComboBox idType;
	@UiField
	IntegerTextBox idCode;
	@UiField
	TextBox pob;
	@UiField
	DateSelectorBox dob;
	@UiField
	IntegerTextBox taxNr;
	@UiField
	IntegerTypeComboBox education;
	@UiField
	Label email;
	@UiField
	TextBox address;
	@UiField
	TextBox city;
	@UiField
	IntegerTextBox zipCode;
	@UiField
	TextBox province;
	@UiField
	TextBox fixPhone;
	@UiField
	TextBox cellPhone;
	@UiField
	IntegerTypeComboBox sideIncomeType;
	@UiField
	IntegerTypeComboBox mainIncomeType;
	@UiField
	DoubleTextBox mainIncome;
	@UiField
	DoubleTextBox sideIncome;
	@UiField
	DoubleTextBox expense;
	@UiField
	DoubleTextBox otherExpense;
	@UiField
	IntegerTypeComboBox home;
	@UiField
	IntegerTypeComboBox vehicle;

	public ProfileForm() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		List<IntegerTypeDv> idTypes = new ArrayList<IntegerTypeDv>();
		idTypes.add(new IntegerTypeDv(1, "KTP"));
		idTypes.add(new IntegerTypeDv(2, "PASPOR"));
		idType.setList(idTypes);
		//
		List<IntegerTypeDv> sexTypes = new ArrayList<IntegerTypeDv>();
		sexTypes.add(new IntegerTypeDv(1, "PRIA"));
		sexTypes.add(new IntegerTypeDv(2, "WANITA"));
		sex.setList(sexTypes);
		//
		List<IntegerTypeDv> educations = new ArrayList<IntegerTypeDv>();
		educations.add(new IntegerTypeDv(1, "SD sederajad"));
		educations.add(new IntegerTypeDv(2, "SMP sederajad"));
		educations.add(new IntegerTypeDv(3, "SMA sederajad"));
		educations.add(new IntegerTypeDv(4, "S1"));
		educations.add(new IntegerTypeDv(5, "S2"));
		educations.add(new IntegerTypeDv(6, "S3"));
		education.setList(educations);
		//
		List<IntegerTypeDv> incomeTypes = new ArrayList<IntegerTypeDv>();
		incomeTypes.add(new IntegerTypeDv(1, "PNS"));
		incomeTypes.add(new IntegerTypeDv(2, "Wirausaha"));
		incomeTypes.add(new IntegerTypeDv(3, "Polisi/TNI"));
		incomeTypes.add(new IntegerTypeDv(4, "Sektor informal"));
		mainIncomeType.setList(incomeTypes);
		//
		incomeTypes = new ArrayList<IntegerTypeDv>();
		incomeTypes.add(new IntegerTypeDv(1,
				"Bekerja paruh waktu di tempat lain"));
		incomeTypes.add(new IntegerTypeDv(2, "Wirausaha"));
		incomeTypes.add(new IntegerTypeDv(3, "Investasi"));
		sideIncomeType.setList(incomeTypes);
		//
		List<IntegerTypeDv> homes = new ArrayList<IntegerTypeDv>();
		homes.add(new IntegerTypeDv(1, "Rumah sendiri"));
		homes.add(new IntegerTypeDv(2, "Kontrak"));
		home.setList(homes);
		//
		List<IntegerTypeDv> vehicles = new ArrayList<IntegerTypeDv>();
		vehicles.add(new IntegerTypeDv(1, "Motor"));
		vehicles.add(new IntegerTypeDv(2, "Mobil"));
		vehicle.setList(vehicles);
		//
		fixPhone.getElement().setPropertyString("placeholder",
				"No telpon rumah");
		cellPhone.getElement().setPropertyString("placeholder",
				"No telpon seluler");
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
