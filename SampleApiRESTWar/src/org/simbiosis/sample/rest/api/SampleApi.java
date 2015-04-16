package org.simbiosis.sample.rest.api;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.simbiosis.sample.rest.dto.GenerateData;
import org.simbiosis.sample.rest.dto.ProjectDto;

@Path("/sample")
public class SampleApi {

	@GET()
	@Path("/projects")
	@Produces("application/json")
	public String listProduct() {
		GenerateData generator = new GenerateData();
		ObjectWriter ow = new ObjectMapper().writer()
				.withDefaultPrettyPrinter();
		String json = null;
		List<ProjectDto> result = generator.sampleListProject();
		try {
			json = ow.writeValueAsString(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
}
