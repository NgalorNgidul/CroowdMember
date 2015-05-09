package com.croowd.ui.member.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class InvestList extends Place {
	String token;

	public InvestList(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public static class Tokenizer implements PlaceTokenizer<InvestList> {

		@Override
		public InvestList getPlace(String token) {
			return new InvestList(token);
		}

		@Override
		public String getToken(InvestList place) {
			return place.getToken();
		}

	}
}
