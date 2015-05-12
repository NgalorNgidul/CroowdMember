package com.croowd.ui.member.client.prospectdlg;

import java.util.ArrayList;
import java.util.List;

import com.croowd.ui.member.client.invest.InvestListForm;
import com.croowd.ui.member.client.json.ProspectJso;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ProspectDlg extends DialogBox {

	private static ProspectDlgUiBinder uiBinder = GWT
			.create(ProspectDlgUiBinder.class);

	interface ProspectDlgUiBinder extends UiBinder<Widget, ProspectDlg> {
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
	
	InvestListForm parentForm;

	@UiField
	TextBox searchKey;
	@UiField
	VerticalPanel searchResult;

	public ProspectDlg() {
		uiBinder.createAndBindUi(this);
		//
		setGlassEnabled(true);
		setSize("600px", "400px");
		//
		clearData();
	}

	@UiFactory
	DialogBox thatsJustMe() {
		// UiBinder will call this to get a DialogBox instance
		// and this is the DialogBox instance we want to use
		return this;
	}

	@UiHandler("btnCancel")
	public void onCancel(ClickEvent e) {
		hide();
	}

	@UiHandler("btnSearch")
	public void onSearch(ClickEvent e) {
		String url = "http://api.croowd.co.id/prospect/find/"
				+ searchKey.getText();

		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		try {
			builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable e) {
					Window.alert(e.getMessage());
				}

				public void onResponseReceived(Request request,
						Response response) {
					if (200 == response.getStatusCode()) {
						JsArray<ProspectJso> projects = JsonUtils
								.<JsArray<ProspectJso>> safeEval(response
										.getText());
						showResult(projects);
					} else {
						Window.alert("Received HTTP status code other than 200 : "
								+ response.getStatusText());
					}
				}
			});
		} catch (RequestException ex) {
			// Couldn't connect to server
			Window.alert(ex.getMessage());
		}
	}

	public void setParent(InvestListForm parentForm) {
		this.parentForm = parentForm;
	}
	
	void showResult(JsArray<ProspectJso> projects) {
		searchResult.clear();
		if (projects.length() > 0) {
			for (int i = 0; i < projects.length(); i++) {
				addData(projects.get(i));
			}
		} else {
			noData();
		}
	}

	public void addData(ProspectJso data) {
		VerticalPanel vp = new VerticalPanel();
		vp.setStyleName("fullbox");
		HTMLPanel panel = new HTMLPanel("<b>" + data.getTitle()
				+ "</b> oleh <b>" + data.getOwnerName()
				+ "</b><br/>Kebutuhan : Rp " + data.getPrincipal()
				+ ",-, Tenor : " + data.getTenor() + " bulan<br/>"
				+ data.getDescription() + "<br/><br/>");
		panel.setStyleName("itemline");
		vp.add(panel);
		Button btnReview = new Button("Pilih");
		btnReview.setStyleName("fieldbutton");
		buttons.add(new Mapper(btnReview, data));
		btnReview.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				onClickHandler((Button) event.getSource());
			}
		});
		vp.add(btnReview);
		panel = new HTMLPanel("<div></div>");
		panel.setStyleName("itemlinespacer");
		vp.add(panel);
		searchResult.add(vp);
		searchResult.setCellHeight(panel, "100%");
	}

	public void noData() {
		VerticalPanel vp = new VerticalPanel();
		vp.setStyleName("fullbox");
		HTMLPanel panel = new HTMLPanel("Data yang anda cari tidak ditemukan.");
		panel.setStyleName("itemline");
		vp.add(panel);
		searchResult.add(vp);
		searchResult.setCellHeight(panel, "100%");
	}

	public void clearData() {
		VerticalPanel vp = new VerticalPanel();
		vp.setStyleName("fullbox");
		HTMLPanel panel = new HTMLPanel("");
		panel.setStyleName("itemline");
		vp.add(panel);
		searchResult.add(vp);
		searchResult.setCellHeight(panel, "100%");
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
			parentForm.selectProspect(result);
			hide();
		}
	}
}
