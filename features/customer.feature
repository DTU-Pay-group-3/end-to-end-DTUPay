Feature: Customer

	Scenario: Customer Registration
		Given an unregistered customer with empty id
		Then the customer is being registered
		And the customer has a non empty id
		When The Customer requests the Tokens
		Then Customers receives the tokens
