package com.croowd.ui.member.client.invest;

import com.croowd.ui.member.client.json.InvestPlanJso;
import com.croowd.ui.member.client.json.ProspectJso;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class InvestResultList extends Composite {

	InvestListForm parentForm;

	NumberFormat nf = NumberFormat.getFormat("#,##0.00");

	private static ProspectResultListUiBinder uiBinder = GWT
			.create(ProspectResultListUiBinder.class);

	interface ProspectResultListUiBinder extends
			UiBinder<Widget, InvestResultList> {
	}

	public abstract class InvestClickHandler implements ClickHandler {
		InvestPlanJso invest = null;

		public InvestClickHandler(InvestPlanJso invest) {
			this.invest = invest;
		}

		public InvestPlanJso getInvest() {
			return invest;
		}
	}

	@UiField
	VerticalPanel prospectList;

	@UiField
	ListBox filter;

	// @UiField
	// Button btnNew;

	public InvestResultList() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		filter.addItem("Semua","0");
		filter.addItem("Belum validasi","1");
		filter.addItem("Sudah validasi","2");
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
		HTMLPanel panel = null;
		//
		if (prospectList.getWidgetCount() > 0) {
			panel = new HTMLPanel("<div></div>");
			panel.setStyleName("itemlinespacer");
			vp.add(panel);
		}
		//
		HorizontalPanel wrapper = new HorizontalPanel();
		wrapper.setSpacing(10);
		wrapper.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);

		Image image = new Image(
				"http://app.croowd.co.id/resources/getProspectImage?type=small&id="
						+ data.getId());
		image.setWidth("300px");
		wrapper.add(image);
		wrapper.add(new HTMLPanel("<div width=\"20px\"></div>"));
		VerticalPanel contentWrapper = new VerticalPanel();
		panel = new HTMLPanel("<b>" + data.getTitle() + "</b><br/>oleh <b>"
				+ data.getOwnerName() + "</b><br/>Kebutuhan : Rp "
				+ nf.format(data.getPrincipal()) + ", Tenor : "
				+ data.getTenor() + " bulan<br/>" + data.getDescription()
				+ "<br/><br/>Investasi : Rp " + nf.format(invest.getValue())
				+ "<br/><br/>");
		panel.setStyleName("itemline");
		contentWrapper.add(panel);
		Button btnReview = new Button("Lihat detail");
		btnReview.setStyleName("fieldbutton");
		btnReview.addClickHandler(new InvestClickHandler(invest) {

			@Override
			public void onClick(ClickEvent event) {
				parentForm.editInvest(getInvest());
			}
		});
		contentWrapper.add(btnReview);
		wrapper.add(contentWrapper);
		vp.add(wrapper);
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

	@UiHandler("btnNew")
	public void onNewProspect(ClickEvent e) {
		parentForm.newData();
	}

	@UiHandler("btnRefresh")
	public void onRefresh(ClickEvent e) {
		parentForm.refreshResult();
	}

	public int getFilter(){
		return filter.getSelectedIndex();
	}
}
