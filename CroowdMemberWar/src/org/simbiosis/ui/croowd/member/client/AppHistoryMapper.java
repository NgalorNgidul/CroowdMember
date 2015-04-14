package org.simbiosis.ui.croowd.member.client;

import org.simbiosis.ui.croowd.member.client.places.ProjectPlace;
import org.simbiosis.ui.gwt.client.mvp.SIMbiosisHistoryMapper;

import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ ProjectPlace.Tokenizer.class })
public interface AppHistoryMapper extends SIMbiosisHistoryMapper {

}
