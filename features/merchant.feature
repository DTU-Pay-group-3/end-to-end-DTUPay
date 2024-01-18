Feature: Merchant feature

  Scenario: Merchant Registration
  	Given a merchant with a bank account
  	When the merchant is being registered
  	Then the merchant is registered
  	And has a non empty 	