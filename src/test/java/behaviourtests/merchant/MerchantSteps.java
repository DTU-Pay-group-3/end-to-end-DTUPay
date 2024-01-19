package behaviourtests.merchant;

import behaviourtests.model.DTUPayAccount;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertFalse;

//@Author for class: Jacob
public class MerchantSteps {
    MerchantService service = new MerchantService();
    DTUPayAccount merchantAccount, responseAccount;

    @Given("a merchant with a bank account")
    public void aMerchantWithABankAccount() {
        merchantAccount = new DTUPayAccount("Bob", "Bname", "3322119999", "54321");
    }

    @When("the merchant is being registered")
    public void theMerchantIsBeingRegistered() {
        responseAccount = service.register(merchantAccount);
    }

    @Then("the merchant is registered")
    public void theMerchantIsRegistered() {
//        assertNotNull(responseAccount.getId());
    }

    @And("the merchant has a non empty id")
    public void theMerchantHasANonEmptyId() {
        assertFalse(responseAccount.getId().isBlank());
    }
}
