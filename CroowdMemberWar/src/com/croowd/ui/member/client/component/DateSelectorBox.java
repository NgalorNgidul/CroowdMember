package com.croowd.ui.member.client.component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class DateSelectorBox extends Composite implements LeafValueEditor<Date> {

	IntegerTypeComboBox ddate = new IntegerTypeComboBox();
	IntegerTypeComboBox mdate = new IntegerTypeComboBox();
	IntegerTypeComboBox ydate = new IntegerTypeComboBox();

	public DateSelectorBox() {
		HTMLPanel panel = new HTMLPanel("");
		ddate.setStyleName("fieldcombobox");
		panel.add(ddate);
		mdate.setStyleName("fieldcombobox");
		panel.add(mdate);
		ydate.setStyleName("fieldcombobox");
		panel.add(ydate);
		//
		List<IntegerTypeDv> days = new ArrayList<IntegerTypeDv>();
		for (int i = 1; i < 32; i++) {
			days.add(new IntegerTypeDv(i, String.valueOf(i)));
		}
		ddate.setList(days);
		List<IntegerTypeDv> months = new ArrayList<IntegerTypeDv>();
		months.add(new IntegerTypeDv(1, "Januari"));
		months.add(new IntegerTypeDv(2, "Februari"));
		months.add(new IntegerTypeDv(3, "Maret"));
		months.add(new IntegerTypeDv(4, "April"));
		months.add(new IntegerTypeDv(5, "Mei"));
		months.add(new IntegerTypeDv(6, "Juni"));
		months.add(new IntegerTypeDv(7, "Juli"));
		months.add(new IntegerTypeDv(8, "Agustus"));
		months.add(new IntegerTypeDv(9, "September"));
		months.add(new IntegerTypeDv(10, "Oktober"));
		months.add(new IntegerTypeDv(11, "November"));
		months.add(new IntegerTypeDv(12, "Desember"));
		mdate.setList(months);
		List<IntegerTypeDv> years = new ArrayList<IntegerTypeDv>();
		for (int i = 1930; i <= 1995; i++) {
			years.add(new IntegerTypeDv(i, String.valueOf(i)));
		}
		ydate.setList(years);
		//
		initWidget(panel);
	}

	@Override
	public void setValue(Date value) {
		ddate.setValue(Integer.parseInt(DateTimeFormat.getFormat("dd").format(
				value)));
		mdate.setValue(Integer.parseInt(DateTimeFormat.getFormat("MM").format(
				value)));
		ydate.setValue(Integer.parseInt(DateTimeFormat.getFormat("yyyy")
				.format(value)));
	}

	@Override
	public Date getValue() {
		NumberFormat nf = NumberFormat.getFormat("00");
		String strDate = nf.format(ddate.getValue()) + "-"
				+ nf.format(mdate.getValue()) + "-"
				+ ydate.getValue().toString();
		return DateTimeFormat.getFormat("dd-MM-yyyy").parse(strDate);
	}

}
