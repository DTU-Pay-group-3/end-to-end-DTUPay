package behaviourtests.customer;

import behaviourtests.model.DTUPayAccount;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

/*Author Sandra s233484*/
public class CustomerService {

	public DTUPayAccount register(DTUPayAccount c) {
		Client client = ClientBuilder.newClient();
		WebTarget r = client.target("http://localhost:8080/");
		var response = r.path("customers").request().post(Entity.entity(c, MediaType.APPLICATION_JSON), DTUPayAccount.class);
		return response;
	}

	public String[] generateTokens(DTUPayAccount c) {
		Client client = ClientBuilder.newClient();
		WebTarget r = client.target("http://localhost:8080/customers/");
		var response = r.path("tokens").request().post(Entity.entity(c.getId(), MediaType.APPLICATION_JSON), String[].class);
		return response;
	}
}
