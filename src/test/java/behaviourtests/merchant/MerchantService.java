package behaviourtests.merchant;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

public class MerchantService {

	public DTUPayAccount register(DTUPayAccount acc) {
		Client client = ClientBuilder.newClient();
		WebTarget r = client.target("http://localhost:8080/merchant");
		var response = r.path("/register").request().post(Entity.json(acc), DTUPayAccount.class);
		return response;
	}
}
