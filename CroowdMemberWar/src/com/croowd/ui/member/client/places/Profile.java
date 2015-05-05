package com.croowd.ui.member.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class Profile extends Place {
	String token;

	public Profile(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public static class Tokenizer implements PlaceTokenizer<Profile> {

		@Override
		public Profile getPlace(String token) {
			return new Profile(token);
		}

		@Override
		public String getToken(Profile place) {
			return place.getToken();
		}

	}
}
