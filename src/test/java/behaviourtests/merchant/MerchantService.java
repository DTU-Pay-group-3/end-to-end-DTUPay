package behaviourtests.merchant;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

public class MerchantService {

	public Merchant register(Merchant c) {
		Client client = ClientBuilder.newClient();
		WebTarget r = client.target("http://localhost:8080/");
		var response = r.path("merchant").request().post(Entity.json(c), Merchant.class);
		return response;
	}
}
