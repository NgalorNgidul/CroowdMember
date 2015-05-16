package com.croowd.ui.validation.client.userform;

import com.croowd.ui.validation.client.json.RegistrationJso;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class UserEditor extends Composite implements Editor<RegistrationJso> {

	interface ThisUiBinder extends UiBinder<Widget, UserEditor> {
	}

	private static ThisUiBinder uiBinder = GWT.create(ThisUiBinder.class);

	interface Driver extends
			SimpleBeanEditorDriver<RegistrationJso, UserEditor> {
	}

	Driver driver = GWT.create(Driver.class);

	@UiField
	VerticalPanel appPanel;
	@UiField
	Button btnSave;
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
	TextBox fixPhone;
	@UiField
	TextBox cellPhone;
	@UiField
	PasswordTextBox password;
	@UiField
	PasswordTextBox passwordconf;

	public UserEditor() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		name.getElement().setPropertyString("placeholder", "Nama lengkap");
		address.getElement().setPropertyString("placeholder", "Alamat lengkap");
		city.getElement().setPropertyString("placeholder", "Kota");
		zipCode.getElement().setPropertyString("placeholder", "Kode pos");
		province.getElement().setPropertyString("placeholder", "Propinsi");
		fixPhone.getElement().setPropertyString("placeholder", "No telpon rumah");
		cellPhone.getElement().setPropertyString("placeholder", "No telpon seluler");
		//
		driver.initialize(this);
	}

	public void setData(RegistrationJso jso) {
		driver.edit(jso);
	}

	@UiHandler("btnSave")
	public void onSave(ClickEvent e) {
		String checkData = isDataComplete();
		if (!checkData.isEmpty()) {
			Window.alert(checkData);
		} else {
			String checkPassword = isPasswordOk();
			if (!checkPassword.isEmpty()) {
				Window.alert(checkPassword);
			} else {
				confirmRegistration(driver.flush());
			}
		}
	}

	private String isPasswordOk() {
		String result = "";
		if (password.getText().compareTo(passwordconf.getText()) != 0) {
			result = "Kata kunci yang anda isikan tidak sama dengan konfirmasi";
		} else if (password.getText().length() < 3) {
			result = "Kata kunci harus terdiri dari 3 karakter atau lebih";
		}
		return result;
	}

	private String isDataComplete() {
		String result = "";
		if (name.getText().isEmpty()) {
			result = "Nama harus diisi";
		} else if (address.getText().isEmpty()) {
			result = "Alamat harus diisi";
		} else if (city.getText().isEmpty()) {
			result = "Kota harus diisi";
		} else if (zipCode.getText().isEmpty()) {
			result = "Kode pos harus diisi";
		} else if (province.getText().isEmpty()) {
			result = "Propinsi harus diisi";
		} else if (fixPhone.getText().isEmpty() && cellPhone.getText().isEmpty()) {
			result = "Nomer telpon harus diisi";
		}
		return result;
	}

	private void confirmRegistration(RegistrationJso data) {
		String url = "http://api.croowd.co.id/registration/confirmmember";
		//
		RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, url);
		try {
			builder.setHeader("Content-Type", "application/json");
			builder.sendRequest(new JSONObject(data).toString(),
					new RequestCallback() {
						public void onError(Request request, Throwable e) {
							Window.alert(e.getMessage());
						}

						public void onResponseReceived(Request request,
								Response response) {
							if (200 == response.getStatusCode()) {
								if (response.getText().isEmpty()){
									registerSuccess();
								}
							} else {
								Window.alert("Received HTTP status code other than 200 : "
										+ response.getStatusText());
							}
						}
					});
		} catch (RequestException e) {
			// Couldn't connect to server
			Window.alert(e.getMessage());
		}
	}
	
	private void registerSuccess(){
		appPanel.clear();
		appPanel.add(new RegisterSuccess());
	}
}
