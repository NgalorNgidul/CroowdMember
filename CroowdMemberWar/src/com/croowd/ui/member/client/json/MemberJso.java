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

	public final native int getSex() /*-{
		return this.sex;
	}-*/;

	public final native void setSex(int sex) /*-{
		this.sex = sex;
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
		if (getNativeDob() == null) {
			return new Date();
		}
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

	public final Integer getIdCode() {
		if (getNativeIdCode() == null) {
			return 0;
		}
		return Integer.parseInt(getNativeIdCode());
	}

	public final void setIdCode(Integer idCode) {
		setNativeIdCode(idCode.toString());
	}

	public final native String getNativeIdCode() /*-{
		return this.idCode;
	}-*/;

	public final native void setNativeIdCode(String idCode) /*-{
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

	public final Integer getZipCode() {
		if (getNativeZipCode() == null) {
			return 0;
		}
		return Integer.parseInt(getNativeZipCode());
	}

	public final void setZipCode(Integer zipCode) {
		setNativeZipCode(zipCode.toString());
	}

	public final native String getNativeZipCode() /*-{
		return this.zipCode;
	}-*/;

	public final native void setNativeZipCode(String zipCode) /*-{
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

	public final native int getMainIncomeType() /*-{
		return this.mainIncomeType;
	}-*/;

	public final native void setMainIncomeType(int mainIncomeType) /*-{
		this.mainIncomeType = mainIncomeType;
	}-*/;

	public final native double getMainIncome() /*-{
		return this.mainIncome;
	}-*/;

	public final native void setMainIncome(double mainIncome) /*-{
		this.mainIncome = mainIncome;
	}-*/;

	public final native int getSideIncomeType() /*-{
		return this.sideIncomeType;
	}-*/;

	public final native void setSideIncomeType(int sideIncomeType) /*-{
		this.sideIncomeType = sideIncomeType;
	}-*/;

	public final native double getSideIncome() /*-{
		return this.sideIncome;
	}-*/;

	public final native void setSideIncome(double sideIncome) /*-{
		this.sideIncome = sideIncome;
	}-*/;

	public final native int getHome() /*-{
		return this.home;
	}-*/;

	public final native void setHome(int home) /*-{
		this.home = home;
	}-*/;

	public final native int getHomeStayDur() /*-{
		return this.homeStayDur;
	}-*/;

	public final native void setHomeStayDur(int homeStayDur) /*-{
		this.homeStayDur = homeStayDur;
	}-*/;

	public final native int getVehicle() /*-{
		return this.vehicle;
	}-*/;

	public final native void setVehicle(int vehicle) /*-{
		this.vehicle = vehicle;
	}-*/;

	public final native int getVehicleProduction() /*-{
		return this.vehicleProduction;
	}-*/;

	public final native void setVehicleProduction(int vehicleProduction) /*-{
		this.vehicleProduction = vehicleProduction;
	}-*/;

	public final native double getExpense() /*-{
		return this.expense;
	}-*/;

	public final native void setExpense(double expense) /*-{
		this.expense = expense;
	}-*/;

	public final native double getOtherExpense() /*-{
		return this.otherExpense;
	}-*/;

	public final native void setOtherExpense(double otherExpense) /*-{
		this.otherExpense = otherExpense;
	}-*/;

	public final int getTaxNr() {
		if (getNativeTaxNr() == null) {
			return 0;
		}
		return Integer.parseInt(getNativeTaxNr());
	}

	public final void setTaxNr(int taxNr) {
		setNativeTaxNr(String.valueOf(taxNr));
	}

	public final native String getNativeTaxNr() /*-{
		return this.taxNr;
	}-*/;

	public final native void setNativeTaxNr(String taxNr) /*-{
		this.taxNr = taxNr;
	}-*/;

	public final native int getEducation() /*-{
		return this.education;
	}-*/;

	public final native void setEducation(int education) /*-{
		this.education = education;
	}-*/;

}
