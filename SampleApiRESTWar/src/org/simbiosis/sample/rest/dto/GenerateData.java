package org.simbiosis.sample.rest.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenerateData {

	public List<ProjectDto> sampleListProject() {
		List<ProjectDto> list = new ArrayList<ProjectDto>();
		ProjectDto dto = new ProjectDto();
		dto.setId(1L);
		dto.setCategory(2L);
		dto.setDuration(new Date());
		dto.setFunded("10%");
		dto.setPledged("RP.10000,00");
		dto.setGoal("Rp.40.000.000,00");
		dto.setLocation(2L);
		dto.setShortBlurb("this is the short description");
		dto.setStrCategory("technology");
		dto.setStrDuration("15-05-2015");
		dto.setStrLocation("Jakarta");
		dto.setStrSubCategory("developer");
		dto.setSubCategory(2L);
		dto.setTitle("Project Title");
		dto.setUserName("musisician");
		list.add(dto);

		dto = new ProjectDto();
		dto.setId(2L);
		dto.setCategory(1L);
		dto.setDuration(new Date());
		dto.setFunded("20%");
		dto.setPledged("RP.20000,00");
		dto.setGoal("Rp.10.000.000,00");
		dto.setLocation(1L);
		dto.setShortBlurb("this is the short description 2");
		dto.setStrCategory("technology");
		dto.setStrDuration("15-05-2015");
		dto.setStrLocation("Jakarta");
		dto.setStrSubCategory("developer");
		dto.setSubCategory(1L);
		dto.setTitle("Project Title 2");
		dto.setUserName("musisician");
		list.add(dto);

		dto = new ProjectDto();
		dto.setId(3L);
		dto.setCategory(1L);
		dto.setDuration(new Date());
		dto.setFunded("30%");
		dto.setPledged("RP.30000,00");
		dto.setGoal("Rp.40.000.000,00");
		dto.setLocation(1L);
		dto.setShortBlurb("this is the short description 3");
		dto.setStrCategory("technology");
		dto.setStrDuration("15-05-2015");
		dto.setStrLocation("Jakarta");
		dto.setStrSubCategory("developer");
		dto.setSubCategory(1L);
		dto.setTitle("Project Title 3");
		dto.setUserName("musisician");
		list.add(dto);
		return list;
	}
}
