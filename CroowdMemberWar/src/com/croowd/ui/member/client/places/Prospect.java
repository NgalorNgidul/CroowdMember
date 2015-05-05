package com.croowd.ui.member.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class Prospect extends Place {
	String token;

	public Prospect(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public static class Tokenizer implements PlaceTokenizer<Prospect> {

		@Override
		public Prospect getPlace(String token) {
			return new Prospect(token);
		}

		@Override
		public String getToken(Prospect place) {
			return place.getToken();
		}

	}
}
