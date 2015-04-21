package org.simbiosis.sample.api.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/sample")
public class ProjectApi {

	@GET()
	@Path("/projects")
	@Produces("application/json")
	public String listCustomers() {
		ObjectWriter ow = new ObjectMapper().writer()
				.withDefaultPrettyPrinter();
		String json = null;
		try {
			Generator generator = new Generator();
			List<ProjectDto> result = generator.generateSample();
			json = ow.writeValueAsString(result);
		} catch (Exception e) {
			JSONObject object = new JSONObject();
			try {
				object.put("result", e.getMessage());
				return object.toString();
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return json;
	}

}
