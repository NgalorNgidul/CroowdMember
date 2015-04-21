package org.simbiosis.sample.api.rest;

import java.util.ArrayList;
import java.util.List;

public class Generator {

	public List<ProjectDto> generateSample() {
		List<ProjectDto> list = new ArrayList<ProjectDto>();
		ProjectDto dto = new ProjectDto();
		dto.setId(1L);
		dto.setCategory("category");
		dto.setDescription("description");
		dto.setLocation("location");
		dto.setOwnerName("owner");
		dto.setPledged("pledged");
		dto.setTitle("title");
		list.add(dto);
		return list;
	}

}
