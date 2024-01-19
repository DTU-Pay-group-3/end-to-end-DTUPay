package behaviourtests.customer;

import behaviourtests.model.DTUPayAccount;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

public class CustomerService {

	public DTUPayAccount register(DTUPayAccount c) {
		Client client = ClientBuilder.newClient();
		WebTarget r = client.target("http://fm-03.compute.dtu.dk:8080/");
		var response = r.path("customers")
				.request()
				.post(Entity.entity(c, APPLICATION_JSON));
		return response.readEntity(DTUPayAccount.class);
	}

	public String[] generateTokens(DTUPayAccount c) {
		Client client = ClientBuilder.newClient();
		WebTarget r = client.target("http://fm-03.compute.dtu.dk:8080/customers/");
		var response = r.path("tokens").request().post(Entity.json(c), String[].class);
		return response;
	}
}
