package com.croowd.ui.member.client;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisHistoryMapper;

import com.croowd.ui.member.client.places.Profile;
import com.croowd.ui.member.client.places.Prospect;
import com.croowd.ui.member.client.places.Project;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ Prospect.Tokenizer.class, Project.Tokenizer.class,
		Profile.Tokenizer.class })
public interface AppHistoryMapper extends SIMbiosisHistoryMapper {

}
