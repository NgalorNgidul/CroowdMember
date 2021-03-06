package com.croowd.ui.member.client.prospecteditor;

import java.util.ArrayList;
import java.util.List;

import org.simbiosis.ui.gwt.client.editor.DoubleTextBox;
import org.simbiosis.ui.gwt.client.editor.StringListComboBox;

import com.croowd.ui.member.client.component.IntegerTypeComboBox;
import com.croowd.ui.member.client.component.IntegerTypeDv;
import com.croowd.ui.member.client.json.ProspectJso;
import com.croowd.ui.member.client.prospect.IProspectList.Activity;
import com.croowd.ui.member.client.uploaddlg.UploadImageDlg;
import com.croowd.ui.member.client.uploaddlg.UploadImageDlgHandler;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
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
	StringListComboBox category;
	@UiField
	IntegerTypeComboBox tenor;
	@UiField
	TextArea shortDescription;
	@UiField
	TextArea description;
	@UiField
	IntegerTypeComboBox campaignPeriod;
	@UiField
	HTMLPanel smallPicture;
	@UiField
	Button btnUploadFoto;

	String pictureUrl = "";
	int pictureCounter = 1;

	Long id = 0L;

	public ProspectEditor() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		title.getElement().setPropertyString("placeholder", "Nama proyek");
		location.getElement().setPropertyString("placeholder", "Lokasi proyek");
		shortDescription.getElement().setPropertyString("placeholder",
				"Keterangan singkat");
		description.getElement().setPropertyString("placeholder",
				"Keterangan lengkap");
		//
		List<IntegerTypeDv> tenors = new ArrayList<IntegerTypeDv>();
		tenors.add(new IntegerTypeDv(6, "6 BULAN"));
		tenors.add(new IntegerTypeDv(12, "1 TAHUN"));
		tenors.add(new IntegerTypeDv(24, "2 TAHUN"));
		tenors.add(new IntegerTypeDv(36, "3 TAHUN"));
		tenors.add(new IntegerTypeDv(48, "4 TAHUN"));
		tenor.setList(tenors);
		//
		List<IntegerTypeDv> campaignPeriods = new ArrayList<IntegerTypeDv>();
		campaignPeriods.add(new IntegerTypeDv(10, "10 HARI"));
		campaignPeriods.add(new IntegerTypeDv(20, "20 HARI"));
		campaignPeriods.add(new IntegerTypeDv(30, "30 HARI"));
		campaignPeriods.add(new IntegerTypeDv(40, "40 HARI"));
		campaignPeriods.add(new IntegerTypeDv(50, "50 HARI"));
		campaignPeriod.setList(campaignPeriods);
		//
		driver.initialize(this);
		//
		smallPicture.setVisible(false);
		btnUploadFoto.setVisible(false);
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public void setCategories(JsArrayString categories) {
		List<String> mycat = new ArrayList<String>();
		for (int i = 0; i < categories.length(); i++) {
			mycat.add(categories.get(i));
		}
		category.setList(mycat);
	}

	public void setData(String resourceUrl, ProspectJso data) {
		if (data.getId() != 0) {
			id = data.getId();
			smallPicture.setVisible(true);
			btnUploadFoto.setVisible(true);
		} else {
			id = 0L;
			smallPicture.setVisible(false);
			btnUploadFoto.setVisible(false);
		}
		smallPicture.clear();
		driver.edit(data);
		if (data.getId() != 0) {
			pictureUrl = "http://" + resourceUrl
					+ "/resources/getProspectImage?type=small&id="
					+ data.getId().toString();
			Image picture = new Image(pictureUrl);
			picture.setWidth("300px");
			smallPicture.add(picture);
		}
	}

	public ProspectJso getData() {
		return driver.flush();
	}

	@UiHandler("btnSave")
	void onBtnSave(ClickEvent e) {
		if (campaignPeriod.getValue() < 1) {
			Window.alert("Masa promosi harus lebih dari 0");
		} else if (principal.getValue() < 1000000) {
			Window.alert("Nilai kebutuhan harus lebih dari 1.000.000 Rupiah");
		} else if (shortDescription.getText().isEmpty() || description.getText().isEmpty()) {
			Window.alert("Keterangan singkat dan lengkap harus diisi");
		} else {
			activity.onSave();
		}
	}

	@UiHandler("btnBack")
	void onBtnBack(ClickEvent e) {
		activity.onBack();
	}

	@UiHandler("btnUploadFoto")
	void onBtnUploadFoto(ClickEvent e) {
		UploadImageDlg uploadDlg = new UploadImageDlg(id,
				new UploadImageDlgHandler() {

					@Override
					public void onComplete() {
						smallPicture.clear();
						Image picture = new Image(pictureUrl + "&counter="
								+ pictureCounter++);
						picture.setWidth("300px");
						smallPicture.add(picture);
					}
				});

		uploadDlg.center();
	}

}
