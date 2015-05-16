package com.croowd.ui.validation.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class RegistrationJso extends JavaScriptObject {
	protected RegistrationJso() {
	}

	public final native String getName() /*-{
		return this.name;
	}-*/;

	public final native void setName(String name) /*-{
		this.name = name;
	}-*/;

	public final native String getEmail() /*-{
		return this.email;
	}-*/;

	public final native void setEmail(String email) /*-{
		this.email = email;
	}-*/;

	public final native String getAddress() /*-{
		return this.address;
	}-*/;

	public final native void setAddress(String address) /*-{
		this.address = address;
	}-*/;

	public final native String getCity() /*-{
		return this.city;
	}-*/;

	public final native void setCity(String city) /*-{
		this.city = city;
	}-*/;

	public final native String getZipCode() /*-{
		return this.zipCode;
	}-*/;

	public final native void setZipCode(String zipCode) /*-{
		this.zipCode = zipCode;
	}-*/;

	public final native String getProvince() /*-{
		return this.province;
	}-*/;

	public final native void setProvince(String province) /*-{
		this.province = province;
	}-*/;

	public final native String getFixPhone() /*-{
		return this.fixPhone;
	}-*/;

	public final native void setFixPhone(String fixPhone) /*-{
		this.fixPhone = fixPhone;
	}-*/;

	public final native String getCellPhone() /*-{
		return this.cellPhone;
	}-*/;

	public final native void setCellPhone(String cellPhone) /*-{
		this.cellPhone = cellPhone;
	}-*/;

	public final native String getPassword() /*-{
		return this.password;
	}-*/;

	public final native void setPassword(String password) /*-{
		this.password = password;
	}-*/;

	public final String getPasswordconf() {
		return "";
	}

}
