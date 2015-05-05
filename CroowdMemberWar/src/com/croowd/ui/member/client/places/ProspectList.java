package com.croowd.ui.member.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ProspectList extends Place {
	String token;

	public ProspectList(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public static class Tokenizer implements PlaceTokenizer<ProspectList> {

		@Override
		public ProspectList getPlace(String token) {
			return new ProspectList(token);
		}

		@Override
		public String getToken(ProspectList place) {
			return place.getToken();
		}

	}
}
