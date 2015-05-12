package com.croowd.ui.member.client.invest;

import com.croowd.ui.member.client.json.InvestPlanJso;
import com.croowd.ui.member.client.json.ProspectJso;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class InvestResultList extends Composite {

	InvestListForm parentForm;

	private static ProspectResultListUiBinder uiBinder = GWT
			.create(ProspectResultListUiBinder.class);

	interface ProspectResultListUiBinder extends
			UiBinder<Widget, InvestResultList> {
	}

	@UiField
	VerticalPanel prospectList;
	@UiField
	Button btnNew;

	public InvestResultList() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setParent(InvestListForm parentForm) {
		this.parentForm = parentForm;
	}

	public void clearData() {
		prospectList.clear();
	}

	public void addData(InvestPlanJso invest) {
		ProspectJso data = invest.getProspect();
		VerticalPanel vp = new VerticalPanel();
		vp.setStyleName("fullbox");
		HTMLPanel panel = new HTMLPanel("<b>" + data.getTitle()
				+ "</b> oleh <b>" + data.getOwnerName()
				+ "</b><br/>Kebutuhan : Rp " + data.getPrincipal()
				+ ",-, Tenor : " + data.getTenor() + " bulan<br/>"
				+ data.getDescription() + "<br/><br/>Investasi : Rp "+invest.getValue()+"<br/><br/>");
		panel.setStyleName("itemline");
		vp.add(panel);
		Button btnReview = new Button("Lihat detail");
		btnReview.setStyleName("fieldbutton");
		// buttons.add(new Mapper(btnReview, data));
		// btnReview.addClickHandler(new ClickHandler() {
		//
		// @Override
		// public void onClick(ClickEvent event) {
		// onClickHandler((Button) event.getSource());
		// }
		// });
		vp.add(btnReview);
		panel = new HTMLPanel("<div></div>");
		panel.setStyleName("itemlinespacer");
		vp.add(panel);
		prospectList.add(vp);
	}

	public void noData() {
		VerticalPanel vp = new VerticalPanel();
		vp.setStyleName("fullbox");
		HTMLPanel panel = new HTMLPanel(
				"Saat ini Anda belum memiliki prospek. Untuk membuat prospek baru klik tombol buat prospek di bawah.");
		panel.setStyleName("itemline");
		vp.add(panel);
		prospectList.add(vp);
	}

	// private void onClickHandler(Button button) {
	// ProspectJso result = null;
	// int i = 0;
	// while (i < buttons.size() && result == null) {
	// if (buttons.get(i).getButton() == button) {
	// result = buttons.get(i).getJso();
	// }
	// i++;
	// }
	// if (result != null) {
	// parentForm.editProspect(result);
	// }
	// }

	@UiHandler("btnNew")
	public void onNewProspect(ClickEvent e) {
		parentForm.newData();
	}

}
