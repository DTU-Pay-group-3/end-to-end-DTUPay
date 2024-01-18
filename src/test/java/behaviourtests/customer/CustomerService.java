package behaviourtests.customer;

import behaviourtests.merchant.Merchant;
import behaviourtests.model.DTUPayAccount;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

public class CustomerService {

	public DTUPayAccount register(DTUPayAccount c) {
		Client client = ClientBuilder.newClient();
		WebTarget r = client.target("http://localhost:8080/");
		var response = r.path("customer").request().post(Entity.json(c), DTUPayAccount.class);
		return response;
	}

	public String[] generateTokens(DTUPayAccount c) {
		Client client = ClientBuilder.newClient();
		WebTarget r = client.target("http://localhost:8080/customer/");
		var response = r.path("tokens").request().post(Entity.json(c), String[].class);
		return response;
	}
}
