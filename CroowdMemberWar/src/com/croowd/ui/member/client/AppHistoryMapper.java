package com.croowd.ui.member.client;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisHistoryMapper;

import com.croowd.ui.member.client.places.Project;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ Project.Tokenizer.class })
public interface AppHistoryMapper extends SIMbiosisHistoryMapper {

}
