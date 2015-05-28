package com.croowd.ui.member.client.prospecteditor;

import java.util.ArrayList;
import java.util.List;

import org.simbiosis.ui.gwt.client.editor.DoubleTextBox;
import org.simbiosis.ui.gwt.client.editor.IntegerTextBox;

import com.croowd.ui.member.client.component.CategoryComboBox;
import com.croowd.ui.member.client.component.CategoryDv;
import com.croowd.ui.member.client.component.TenorComboBox;
import com.croowd.ui.member.client.component.TenorDv;
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
	CategoryComboBox category;
	@UiField
	TenorComboBox tenor;
	@UiField
	TextArea shortDescription;
	@UiField
	TextArea description;
	@UiField
	IntegerTextBox campaignPeriod;
	@UiField
	HTMLPanel smallPicture;

	@UiField
	Button btnSave;
	@UiField
	Button btnBack;

	public ProspectEditor() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		List<TenorDv> tenors = new ArrayList<TenorDv>();
		tenors.add(new TenorDv(6, "6 BULAN"));
		tenors.add(new TenorDv(12, "1 TAHUN"));
		tenors.add(new TenorDv(24, "2 TAHUN"));
		tenors.add(new TenorDv(36, "3 TAHUN"));
		tenors.add(new TenorDv(48, "4 TAHUN"));
		tenor.setList(tenors);
		//
		List<CategoryDv> categories = new ArrayList<CategoryDv>();
		categories.add(new CategoryDv(1,"Kendaraan"));
		categories.add(new CategoryDv(2,"Rumah baru"));
		categories.add(new CategoryDv(3,"Renovasi"));
		categories.add(new CategoryDv(4,"Biaya sekolah"));
		categories.add(new CategoryDv(5,"Biaya pengobatan"));
		categories.add(new CategoryDv(6,"Bayar kartu kredit"));
		category.setList(categories);
		//
		driver.initialize(this);
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public void setData(ProspectJso data) {
		smallPicture.clear();
		driver.edit(data);
		Image picture = new Image(
				"http://app.croowd.co.id/resources/getProspectImage?type=small&id="
						+ data.getId());
		picture.setWidth("300px");
		smallPicture.add(picture);
	}

	public ProspectJso getData() {
		return driver.flush();
	}

	@UiHandler("btnSave")
	void onBtnSave(ClickEvent e) {
		activity.onSave();
	}

	@UiHandler("btnBack")
	void onBtnBack(ClickEvent e) {
		activity.onBack();
	}
}
