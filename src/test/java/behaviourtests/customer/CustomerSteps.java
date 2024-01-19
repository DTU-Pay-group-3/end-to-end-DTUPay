package behaviourtests.customer;

import behaviourtests.model.DTUPayAccount;
import dtu.ws.fastmoney.BankServiceException_Exception;
import dtu.ws.fastmoney.User;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;

import java.util.concurrent.CompletableFuture;
import static org.junit.Assert.assertNotNull;

public class CustomerSteps {

    CustomerService service = new CustomerService();
    private DTUPayAccount customer;
    private CompletableFuture<DTUPayAccount> result = new CompletableFuture<DTUPayAccount>();
    private CompletableFuture<String[]> result2 = new CompletableFuture<String[]>();
    //private BankService bank = new BankServiceService().getBankServicePort();
    private String bankAccId;

    @Before
    public void registerBankAccount(){
        User u = new User();
        u.setFirstName("Gandra");
        u.setLastName("Mandra");
        u.setCprNumber("123456790");
        try {
            //bankAccId =bank.createAccountWithBalance(u, BigDecimal.valueOf(500));
            this.bankAccId="DAfg33rv43r";
        }catch(Exception e){

        }
    }

    @Given("an unregistered customer with empty id")
    public void anUnregisteredCustomerWithEmptyId() {
        customer = new DTUPayAccount();
        customer.setId("");
        customer.setAccountNumber(bankAccId);
        customer.setFirstName("Gandra");
        customer.setLastName("Mandra");
        customer.setCprNumber("1234567890");
    }

    @Then("the customer is being registered")
    public void theCustomerIsBeingRegistered() {
        customer = service.register(customer);
        result.complete(customer);
    }

    @And("the customer has a non empty id")
    public void theCustomerHasANonEmptyId() {
        assertNotNull(result.join().getId());
    }

    @When("The Customer requests the Tokens")
    public void theCustomerRequestsTheTokens() {
        result2.complete(service.generateTokens(customer));
    }

    @Then("Customers receives the tokens")
    public void customersReceivesTheTokens() {
        assertNotNull(result2.join());
    }

    @After
    public void retireAllAcc() throws BankServiceException_Exception {
        //bank.retireAccount(customer.getAccountNumber());
    }
}
