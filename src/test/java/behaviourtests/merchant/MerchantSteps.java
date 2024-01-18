package behaviourtests.merchant;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MerchantSteps {
    MerchantService service = new MerchantService();
    DTUPayAccount merchantAccount;

    @Given("a merchant with a bank account")
    public void aMerchantWithABankAccount() {

    }

    @When("the merchant is being registered")
    public void theMerchantIsBeingRegistered() {
        merchantAccount = service.register(new DTUPayAccount("Bob", "Bname", "3322119999", "54321"));
    }

    @Then("the merchant is registered")
    public void theMerchantIsRegistered() {
        assertTrue(merchantAccount.getId().equals("123"));
        assertNotNull(merchantAccount);
    }

    @And("has a non empty")
    public void hasANonEmpty() {
    }
}
