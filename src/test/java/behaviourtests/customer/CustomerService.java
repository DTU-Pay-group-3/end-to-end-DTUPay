package behaviourtests.customer;

import behaviourtests.model.DTUPayAccount;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class CustomerService {

	public DTUPayAccount register(DTUPayAccount c) {
		Client client = ClientBuilder.newClient();
		WebTarget r = client.target("http://localhost:8080/");
		var response = r.path("customers")
				.request()
				.post(Entity.entity(c, MediaType.APPLICATION_JSON));
		return response.readEntity(DTUPayAccount.class);
	}

	public String[] generateTokens(DTUPayAccount c) {
//		Client client = ClientBuilder.newClient();
//		WebTarget r = client.target("http://localhost:8080/customer/");
//		var response = r.path("tokens").request().post(Entity.json(c), String[].class);
//		return response;
		return new String[]{"asd","dsadas"};
	}
}
