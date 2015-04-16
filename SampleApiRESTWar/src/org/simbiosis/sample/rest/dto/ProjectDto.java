package org.simbiosis.sample.rest.dto;

import java.io.Serializable;
import java.util.Date;

public class ProjectDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4434165023481020081L;

	Long id;
	String strImage;
	String title;
	String shortBlurb;
	Long location;
	String strLocation;
	String funded;
	String pledged;
	String userName;
	Long category;
	String strCategory;
	Long subCategory;
	String strSubCategory;
	Date duration;
	String strDuration;
	String goal;

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

	public Long getLocation() {
		return location;
	}

	public void setLocation(Long location) {
		this.location = location;
	}

	public String getStrLocation() {
		return strLocation;
	}

	public void setStrLocation(String strLocation) {
		this.strLocation = strLocation;
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

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public String getStrCategory() {
		return strCategory;
	}

	public void setStrCategory(String strCategory) {
		this.strCategory = strCategory;
	}

	public Long getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Long subCategory) {
		this.subCategory = subCategory;
	}

	public String getStrSubCategory() {
		return strSubCategory;
	}

	public void setStrSubCategory(String strSubCategory) {
		this.strSubCategory = strSubCategory;
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

}
