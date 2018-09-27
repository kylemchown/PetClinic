Feature: Testing Pet Clinic

	Scenario: U1
    Given a vet
    When I click on some records
    Then I can see the care available for animals

	Scenario: U2
    Given an admin
    When I update a record
    Then the correct details are now shown

	Scenario: U3
    Given an admin
    When I delete a animal
    Then emails arent sent to deceased animals
	
	Scenario: U5
    Given an admin
    When I add new records
    Then the records are correct
	
	Scenario: U5
    Given an admin
    When I add new owners to the records
    Then the details show the change
    
    Scenario: POST Owner
Given an owner to add to the system
When I send a post request
Then the owner is added

Scenario: GET Owner
Given an owner is in the system
When I perform a get request
Then I have their information

Scenario: PUT Owner
Given an owner is in the system
When I perform a put request to update their information
Then their information is successfully changed

Scenario: DELETE Owner
Given an owner is in the system
When I perform a delete request
Then their information is no longer stored

 