package behaviourtests.merchant;

import behaviourtests.model.DTUPayAccount;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class MerchantService {
	private Entity<DTUPayAccount> e;
	public DTUPayAccount register(DTUPayAccount acc) {
		Client client = ClientBuilder.newClient();
		WebTarget r = client.target("http://fm-03.compute.dtu.dk:8080/merchant");
		Response response = r.path("/register")
				.request()
				.post(Entity.entity(acc, MediaType.APPLICATION_JSON));
		return response.readEntity(DTUPayAccount.class);
	}
}
