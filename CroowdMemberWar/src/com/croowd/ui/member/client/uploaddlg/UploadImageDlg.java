package com.croowd.ui.member.client.uploaddlg;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class UploadImageDlg extends DialogBox {

	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	interface MyUiBinder extends UiBinder<Widget, UploadImageDlg> {
	}

	@UiField
	Label fileName;
	@UiField
	FileUpload upload;
	@UiField
	FormPanel form;
	@UiField
	Hidden prospectId;
	@UiField
	Button submit;

	UploadImageDlgHandler completeHandler = null;

	public UploadImageDlg(Long id, UploadImageDlgHandler handler) {
		//
		this.completeHandler = handler;
		//
		uiBinder.createAndBindUi(this);
		//
		setGlassEnabled(true);
		setSize("360px", "130px");
		//
		form.setMethod(FormPanel.METHOD_POST);
		form.setEncoding(FormPanel.ENCODING_MULTIPART);
		//
		prospectId.setValue(id.toString());
		//
		upload.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				fileName.setText(upload.getFilename());
			}
		});

		form.addSubmitHandler(new SubmitHandler() {

			@Override
			public void onSubmit(SubmitEvent event) {
				// event.cancel();
				submit.setText("Sedang mengunggah...");
			}
		});

		form.addSubmitCompleteHandler(new SubmitCompleteHandler() {

			@Override
			public void onSubmitComplete(SubmitCompleteEvent event) {
				completeHandler.onComplete();
				hide();
			}
		});

	}

	@UiFactory
	DialogBox getDialogBox() {
		// UiBinder will call this to get a DialogBox instance
		// and this is the DialogBox instance we want to use
		return this;
	}

	@UiHandler("btnCancel")
	public void onCancel(ClickEvent e) {
		hide();
	}

	@UiHandler("submit")
	public void onSubmit(ClickEvent e) {
		form.submit();
	}

	@UiHandler("btnSearch")
	public void onSearch(ClickEvent e) {
		jsClickUpload(upload.getElement());
	}

	native void jsClickUpload(Element pElement) /*-{
		pElement.click();
	}-*/;

}
