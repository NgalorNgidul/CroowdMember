package com.croowd.ui.member.client;

import org.simbiosis.ui.gwt.client.mvp.SIMbiosisHistoryMapper;

import com.croowd.ui.member.client.places.Profile;
import com.croowd.ui.member.client.places.ProspectList;
import com.croowd.ui.member.client.places.Project;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ ProspectList.Tokenizer.class, Project.Tokenizer.class,
		Profile.Tokenizer.class })
public interface AppHistoryMapper extends SIMbiosisHistoryMapper {

}
