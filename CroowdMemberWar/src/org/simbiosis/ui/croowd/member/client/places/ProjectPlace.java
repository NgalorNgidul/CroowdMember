package org.simbiosis.ui.croowd.member.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ProjectPlace extends Place {
	String token;

	public ProjectPlace(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public static class Tokenizer implements PlaceTokenizer<ProjectPlace> {

		@Override
		public ProjectPlace getPlace(String token) {
			return new ProjectPlace(token);
		}

		@Override
		public String getToken(ProjectPlace place) {
			return place.getToken();
		}

	}
}
