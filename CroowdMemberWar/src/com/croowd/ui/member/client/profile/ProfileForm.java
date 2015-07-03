package com.croowd.ui.member.client.profile;

import java.util.ArrayList;
import java.util.List;

import org.simbiosis.ui.gwt.client.editor.DoubleTextBox;
import org.simbiosis.ui.gwt.client.editor.IntegerTextBox;
import org.simbiosis.ui.gwt.client.editor.LongTextBox;

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
import com.google.gwt.user.client.Window;
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
	LongTextBox idCode;
	@UiField
	TextBox pob;
	@UiField
	DateSelectorBox dob;
	@UiField
	LongTextBox taxNr;
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
	IntegerTypeComboBox homeStayDur;
	@UiField
	IntegerTypeComboBox vehicle;
	@UiField
	IntegerTypeComboBox vehicleProduction;

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
		incomeTypes.add(new IntegerTypeDv(0, "Tidak ada"));
		incomeTypes.add(new IntegerTypeDv(1, "PNS"));
		incomeTypes.add(new IntegerTypeDv(2, "Wirausaha"));
		incomeTypes.add(new IntegerTypeDv(3, "Polisi/TNI"));
		incomeTypes.add(new IntegerTypeDv(4, "Sektor informal"));
		mainIncomeType.setList(incomeTypes);
		//
		incomeTypes = new ArrayList<IntegerTypeDv>();
		incomeTypes.add(new IntegerTypeDv(0, "Tidak ada"));
		incomeTypes.add(new IntegerTypeDv(1,
				"Bekerja paruh waktu di tempat lain"));
		incomeTypes.add(new IntegerTypeDv(2, "Wirausaha"));
		incomeTypes.add(new IntegerTypeDv(3, "Investasi"));
		sideIncomeType.setList(incomeTypes);
		//
		List<IntegerTypeDv> homes = new ArrayList<IntegerTypeDv>();
		homes.add(new IntegerTypeDv(0, "Menumpang"));
		homes.add(new IntegerTypeDv(1, "Kontrak"));
		homes.add(new IntegerTypeDv(2, "Rumah sendiri"));
		home.setList(homes);
		//
		List<IntegerTypeDv> homeStayDurs = new ArrayList<IntegerTypeDv>();
		homeStayDurs.add(new IntegerTypeDv(1, "1 tahun"));
		homeStayDurs.add(new IntegerTypeDv(2, "2 tahun"));
		homeStayDurs.add(new IntegerTypeDv(3, "3 tahun"));
		homeStayDurs.add(new IntegerTypeDv(4, "4 tahun"));
		homeStayDurs.add(new IntegerTypeDv(5, "5 tahun"));
		homeStayDur.setList(homeStayDurs);
		//
		List<IntegerTypeDv> vehicles = new ArrayList<IntegerTypeDv>();
		vehicles.add(new IntegerTypeDv(0, "Tidak ada"));
		vehicles.add(new IntegerTypeDv(1, "Motor"));
		vehicles.add(new IntegerTypeDv(2, "Mobil"));
		vehicle.setList(vehicles);
		//
		List<IntegerTypeDv> vehicleProductions = new ArrayList<IntegerTypeDv>();
		vehicleProductions.add(new IntegerTypeDv(2009, "2009"));
		vehicleProductions.add(new IntegerTypeDv(2010, "2010"));
		vehicleProductions.add(new IntegerTypeDv(2011, "2011"));
		vehicleProductions.add(new IntegerTypeDv(2012, "2012"));
		vehicleProductions.add(new IntegerTypeDv(2013, "2013"));
		vehicleProductions.add(new IntegerTypeDv(2014, "2014"));
		vehicleProductions.add(new IntegerTypeDv(2015, "2015"));
		vehicleProduction.setList(vehicleProductions);
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
		if (name.getText().isEmpty()) {
			Window.alert("Nama harus diisi");
		} else if (motherName.getText().isEmpty()) {
			Window.alert("Nama ibu harus diisi");
		} else if (motherName.getText().isEmpty()) {
			Window.alert("Nama ibu harus diisi");
		} else if (idCode.getText().length() < 16) {
			Window.alert("Nomer ktp yang diberikan tidak benar");
		} else if (idCode.getText().length() >= 16 && !validasiKtp()) {
		} else if (taxNr.getText().length() < 15) {
			Window.alert("Nomer NPWP yang diberikan tidak benar");
		} else if (taxNr.getText().length() >= 15 && !validasiNpwp()) {
			Window.alert("Nomer NPWP yang diberikan tidak benar");
		} else if (address.getText().isEmpty() || city.getText().isEmpty()
				|| zipCode.getText().isEmpty() || province.getText().isEmpty()) {
			Window.alert("Keterangan alamat, kota, kode pos, propinsi harus diisi");
		} else if (cellPhone.getText().isEmpty()
				&& fixPhone.getText().isEmpty()) {
			Window.alert("Salah satu nomor telpon (telpon rumah atau telpon seluler) harus diisi");
		} else {
			activity.saveProfile();
		}
	}

	private boolean validasiKtp() {
		String hh = idCode.getText().substring(6, 8);
		int nr = Integer.parseInt(hh);
		if (nr > 40 || nr < 32) {
			if (!validasiKtpLagi(nr)) {
				Window.alert("Nomer ktp tidak sesuai dengan data jenis kelamin");
				return false;
			}
		} else {
			Window.alert("Nomer ktp yang diberikan tidak benar");
			return false;
		}
		return true;
	}

	private boolean validasiKtpLagi(int nr) {
		if (nr > 40 && sex.getValue() == 1) {
			return false;
		} else if (nr < 32 && sex.getValue() == 2) {
			return false;
		}
		return true;
	}

	private boolean validasiNpwp() {
		String str18 = taxNr.getText().substring(0, 8);
		String str9 = taxNr.getText().substring(8, 9);
		int jumlah18 = 0;
		for (int i = 0; i < str18.length(); i++) {
			if (i % 2 == 0) {
				jumlah18 += Integer.parseInt(str18.substring(i, i + 1));
			} else {
				jumlah18 += (Integer.parseInt(str18.substring(i, i + 1)) * 2);
			}
		}
		//
		int jumlahPuluh = 10;
		if (jumlah18 > 10 && jumlah18 <= 20) {
			jumlahPuluh = 20;
		} else if (jumlah18 > 20 && jumlah18 <= 30) {
			jumlahPuluh = 30;
		} else if (jumlah18 > 30 && jumlah18 <= 40) {
			jumlahPuluh = 40;
		} else if (jumlah18 > 40 && jumlah18 <= 50) {
			jumlahPuluh = 50;
		} else if (jumlah18 > 50 && jumlah18 <= 60) {
			jumlahPuluh = 60;
		} else if (jumlah18 > 60 && jumlah18 <= 70) {
			jumlahPuluh = 70;
		} else if (jumlah18 > 70 && jumlah18 <= 80) {
			jumlahPuluh = 80;
		}
		int digit9 = jumlahPuluh - jumlah18;
		if (Integer.parseInt(str9) == digit9) {
			return true;
		}
		return false;
	}

}
