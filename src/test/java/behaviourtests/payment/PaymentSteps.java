package behaviourtests.payment;

import behaviourtests.customer.CustomerService;
import behaviourtests.merchant.MerchantService;
import behaviourtests.model.DTUPayAccount;
import behaviourtests.model.Payment;
import dtu.ws.fastmoney.BankService;
import dtu.ws.fastmoney.BankServiceException_Exception;
import dtu.ws.fastmoney.BankServiceService;
import dtu.ws.fastmoney.User;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/*Author Sandra s233484*/
public class PaymentSteps {

    PaymentService service = new PaymentService();
    CustomerService customerService = new CustomerService();
    MerchantService merchantService = new MerchantService();
    private User customer = new User();
    private User merchant = new User();
    private DTUPayAccount userCustomer;
    private DTUPayAccount userMerchant;
    private CompletableFuture<DTUPayAccount> userDTUCustomer= new CompletableFuture<>();
    private CompletableFuture<DTUPayAccount> userDTUMerchant = new CompletableFuture<>();
    private String customerBankID;
    private String merchantBankID;
    private CompletableFuture<String> result = new CompletableFuture<>();
    private CompletableFuture<String[]> customerTokens = new CompletableFuture<String[]>();
    private Payment payment;

    private BankService bank = new BankServiceService().getBankServicePort();


//    @Before
//    public void SetupAccounts() {
//        customer.setFirstName("NewUniqueFNameasd23fsa");
//        customer.setLastName("NewUniqueLNamesad23asfsa");
//        customer.setCprNumber("10111231111");
//
//        merchant.setFirstName("NewUniqueFNameMe32rcasdash");
//        merchant.setLastName("NewUniqueLNameMe32asdasrch");
//        merchant.setCprNumber("10101010211211312");
//
//        try {
//            customerBankID = bank.createAccountWithBalance(customer, BigDecimal.valueOf(500));
//            userCustomer= new DTUPayAccount(customer.getFirstName(),customer.getLastName(),customer.getCprNumber(),customerBankID);
//            merchantBankID = bank.createAccountWithBalance(merchant, BigDecimal.valueOf(500));
//            userMerchant= new DTUPayAccount(merchant.getFirstName(),merchant.getLastName(),merchant.getCprNumber(),merchantBankID);
//        } catch (Exception e) {
//            System.out.println("USER EXIST");
//        }
//    }

    @Given("A registered merchant and customer")
    public void aRegisteredMerchantAndCustomer() {
        new Thread(() -> {
            userDTUCustomer.complete(customerService.register(userCustomer));
            assertNotNull(userDTUCustomer.join().getId());
            customerTokens.complete(customerService.generateTokens(userDTUCustomer.join()));
        }).start();
        new Thread(() -> {
            userDTUMerchant.complete(merchantService.register(userMerchant));
        }).start();
    }

    @When("The merchant making a payment request")
    public void theMerchantMakingAPaymentRequest() {
        assertNotNull(userDTUMerchant.join().getId());
        assertNotNull(customerTokens.join());
        payment = new Payment(UUID.randomUUID().toString(),userDTUMerchant.join().getId(), customerTokens.join()[0], "NewPayment", BigDecimal.valueOf(100));
    }

    @Then("The payment is being processed")
    public void thePaymentIsBeingProcessed() {
        new Thread(() -> {
        var confirmation=service.makePayment(payment);
        result.complete(confirmation);
        }).start();
    }

    @And("The result is successfull")
    public void theResultIsSuccessfull() {
        assertEquals(result.join(), payment.getPaymentId()+" Completed Successfully");
    }

//    @After
//    public void Clean() throws BankServiceException_Exception {
//        //It is probably not necessary to check the balance since the PaymentComplete event was published
//        System.out.println(bank.getAccount(customerBankID).getBalance() + " Cust1 balance");
//        System.out.println(bank.getAccount(merchantBankID).getBalance() + " Merchant balance");
//
//        bank.retireAccount(customerBankID);
//        bank.retireAccount(merchantBankID);
//    }
}
