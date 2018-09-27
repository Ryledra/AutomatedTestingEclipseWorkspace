Feature: Testing Pet Clinic



Scenario: U5
 - Create new user record
	Given an admin
	When I add new owners to the records
	Then the details show the change

 

Scenario: U4 - Create new pet record
	Given an admin
	When I add new records
	Then the records are correct


Scenario: U2
 - Update pet record
	Given an admin
	When I update a record
	Then the correct details are now shown

Scenario: U3 - Delete pet record
	Given an admin
	When I delete a animal
	Then emails arent sent to deceased annimals


Scenario: U1
 - Check Records
	Given a vet

	When I click on some records

	Then I can see the care available for animals

