package org.simbiosis.ui.croowd.member.shared;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ProjectDv implements IsSerializable {

	Long id;
	String strImage;
	String title;
	String shortBlurb;
	String location;
	String funded;
	String pledged;
	String userName;
	String category;
	String subCategory;
	Date duration;
	String strDuration;
	String goal;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public String getStrDuration() {
		return strDuration;
	}

	public void setStrDuration(String strDuration) {
		this.strDuration = strDuration;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStrImage() {
		return strImage;
	}

	public void setStrImage(String strImage) {
		this.strImage = strImage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortBlurb() {
		return shortBlurb;
	}

	public void setShortBlurb(String shortBlurb) {
		this.shortBlurb = shortBlurb;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFunded() {
		return funded;
	}

	public void setFunded(String funded) {
		this.funded = funded;
	}

	public String getPledged() {
		return pledged;
	}

	public void setPledged(String pledged) {
		this.pledged = pledged;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
