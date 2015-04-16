package com.croowd.ui.member.client.project;

import java.util.List;

import com.croowd.ui.member.client.component.ProjectList;
import com.croowd.ui.member.shared.ProjectDv;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainMenu extends Composite implements IProject {

	private static MainMenuUiBinder uiBinder = GWT
			.create(MainMenuUiBinder.class);

	interface MainMenuUiBinder extends UiBinder<Widget, MainMenu> {
	}

	Activity activitiy;

	@UiField
	ScrollPanel scrollPanel;

	public MainMenu() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setActivity(Activity activity) {
		this.activitiy = activity;
	}

	@Override
	public void setProjectData(List<ProjectDv> data) {
		scrollPanel.clear();
		Grid grid = new Grid(1, 4);
		for (int i = 0; i < data.size(); i++) {
			ProjectList projectList = new ProjectList();
			projectList.setActivity(activitiy);
			projectList.setData(data.get(i));
			projectList.addStyleName("balance");
			grid.setWidget(0, i, projectList.asWidget());
		}
		scrollPanel.add(grid);
	}

	@Override
	public Widget getWidget() {
		return this;
	}

}
