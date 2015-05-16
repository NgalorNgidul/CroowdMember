package com.croowd.ui.member.client.prospect;

import java.util.ArrayList;
import java.util.List;

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

public class ProspectResultList extends Composite {

	ProspectListForm parentForm;

	private static ProspectResultListUiBinder uiBinder = GWT
			.create(ProspectResultListUiBinder.class);

	interface ProspectResultListUiBinder extends
			UiBinder<Widget, ProspectResultList> {
	}

	public class Mapper {
		Button button;
		ProspectJso jso;

		public Mapper(Button button, ProspectJso jso) {
			this.button = button;
			this.jso = jso;
		}

		public Button getButton() {
			return button;
		}

		public void setButton(Button button) {
			this.button = button;
		}

		public ProspectJso getJso() {
			return jso;
		}

		public void setJso(ProspectJso jso) {
			this.jso = jso;
		}

	}

	List<Mapper> buttons = new ArrayList<Mapper>();

	@UiField
	VerticalPanel prospectList;
	@UiField
	ListBox filter;
	@UiField
	Button btnRefresh;
	@UiField
	Button btnNew;

	public ProspectResultList() {
		initWidget(uiBinder.createAndBindUi(this));
		//
		filter.addItem("Semua");
		filter.addItem("Belum validasi");
		filter.addItem("Masa promosi");
		filter.addItem("Sudah eksekusi");
		//
	}

	public void setParent(ProspectListForm parentForm) {
		this.parentForm = parentForm;
	}

	public void clearData() {
		prospectList.clear();
		buttons.clear();
	}

	public void addData(ProspectJso data) {
		NumberFormat nf = NumberFormat.getFormat("#,##0.00");
		VerticalPanel vp = new VerticalPanel();
		vp.setStyleName("fullbox");
		HTMLPanel panel = null;
		//
		if (buttons.size() > 0) {
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
				+ nf.format(data.getPrincipal()) + ",-, Tenor : "
				+ data.getTenor() + " bulan<br/>" + data.getDescription()
				+ "<br/><br/>");
		panel.setStyleName("itemline");
		contentWrapper.add(panel);
		Button btnReview = new Button("Lihat detail");
		btnReview.setStyleName("fieldbutton");
		buttons.add(new Mapper(btnReview, data));
		btnReview.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				onClickHandler((Button) event.getSource());
			}
		});
		contentWrapper.add(btnReview);
		wrapper.add(contentWrapper);
		//wrapper.setCellVerticalAlignment(contentWrapper, HasVerticalAlignment.ALIGN_TOP);
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

	private void onClickHandler(Button button) {
		ProspectJso result = null;
		int i = 0;
		while (i < buttons.size() && result == null) {
			if (buttons.get(i).getButton() == button) {
				result = buttons.get(i).getJso();
			}
			i++;
		}
		if (result != null) {
			parentForm.editProspect(result);
		}
	}

	@UiHandler("btnNew")
	public void onNewProspect(ClickEvent e) {
		parentForm.newData();
	}

}
