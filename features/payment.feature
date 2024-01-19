Feature: Payment

  Scenario: Payment
    Given A registered merchant and customer
    When The merchant making a payment request
    Then The payment is being processed
    And The result is successfull
