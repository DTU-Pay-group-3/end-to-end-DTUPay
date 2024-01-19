package behaviourtests.merchant;

import behaviourtests.model.DTUPayAccount;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class MerchantService {
	private Entity<DTUPayAccount> e;
	public DTUPayAccount register(DTUPayAccount acc) {
		Client client = ClientBuilder.newClient();
		WebTarget r = client.target("http://localhost:8080/merchant");
		var response = r.path("/register").request().post(Entity.entity(acc, MediaType.APPLICATION_JSON), DTUPayAccount.class);
		return response;
	}
}
