package com.croowd.ui.member.client;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisHistoryMapper;

import com.croowd.ui.member.client.places.ProjectPlace;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ ProjectPlace.Tokenizer.class })
public interface AppHistoryMapper extends SIMbiosisHistoryMapper {

}
