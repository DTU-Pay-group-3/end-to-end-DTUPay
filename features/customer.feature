Feature: Customer

	Scenario: Customer Registration
		Given an unregistered customer with empty id
		When the customer is being registered
		Then the customer is registered
		And has a non empty id
		When The Customer requests the Tokens
		Then Customers receives the tokens
