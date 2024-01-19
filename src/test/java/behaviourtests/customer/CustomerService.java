package behaviourtests.customer;

import behaviourtests.model.DTUPayAccount;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class CustomerService {

	public DTUPayAccount register(DTUPayAccount c) {
		Client client = ClientBuilder.newClient();
		WebTarget r = client.target("http://fm-03.compute.dtu.dk:8080/");
		Response response = r.path("customers").request().get();
		System.out.println(response.toString());
		return null;
	}

	public void test() {

	}

	public String[] generateTokens(DTUPayAccount c) {
//		Client client = ClientBuilder.newClient();
//		WebTarget r = client.target("http://localhost:8080/customer/");
//		var response = r.path("tokens").request().post(Entity.json(c), String[].class);
//		return response;
		return new String[]{"asd","dsadas"};
	}
}
