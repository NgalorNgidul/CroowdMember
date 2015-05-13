package com.croowd.ui.member.client.json;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;

public class MemberJso extends JavaScriptObject {
	protected MemberJso() {
	}

	public final native void setSession(String session) /*-{
		this.session = session;
	}-*/;

	public final native Long getId() /*-{
		return this.id;
	}-*/;

	public final native String getName() /*-{
		return this.name;
	}-*/;

	public final native void setName(String name) /*-{
		this.name = name;
	}-*/;

	public final native String getMotherName() /*-{
		return this.motherName;
	}-*/;

	public final native void setMotherName(String motherName) /*-{
		this.motherName = motherName;
	}-*/;

	public final native String getPob() /*-{
		return this.pob;
	}-*/;

	public final native void setPob(String pob) /*-{
		this.pob = pob;
	}-*/;

	public final Date getDob() {
		return new Date((long) JsDate.parse(getNativeDob()));
	}

	public final void setDob(Date date) {
		setNativeDob(JsDate.create((double) date.getTime()));
	}

	public final native String getNativeDob() /*-{
		return this.dob;
	}-*/;

	public final native void setNativeDob(JsDate dob) /*-{
		this.dob = dob;
	}-*/;

	public final native int getIdType() /*-{
		return this.idType;
	}-*/;

	public final native void setIdType(int idType) /*-{
		this.idType = idType;
	}-*/;

	public final native String getIdCode() /*-{
		return this.idCode;
	}-*/;

	public final native void setIdCode(String idCode) /*-{
		this.idCode = idCode;
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

}
