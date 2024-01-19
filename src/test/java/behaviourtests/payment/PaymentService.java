package behaviourtests.payment;

import behaviourtests.model.Payment;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

/*Author Marian s233481*/
public class PaymentService {
	public String makePayment(Payment payment) {
		Client client = ClientBuilder.newClient();
		WebTarget r = client.target("http://localhost:8080/merchant/");
		var response = r.path("pay").request().post(Entity.entity(payment, MediaType.APPLICATION_JSON), String.class);
		return response;
	}
}
