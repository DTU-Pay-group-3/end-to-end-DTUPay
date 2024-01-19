package behaviourtests.customer;

import behaviourtests.model.DTUPayAccount;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

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
