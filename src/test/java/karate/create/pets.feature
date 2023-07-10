Feature: list owners

Background:
	* url petclinic

Scenario: add a new pet to the customer having the less pets
	Given path 'api/customer/owners'
	When method get
	Then status 200
	Then header Content-type = 'application/json'
	Then assert response.length>0
	Then def random = function(max){ return Math.floor(Math.random() * max) }
	Then def length = response.length
	Then def customerToUpdate = response[random(length)]
	
	Given path 'api/customers/owners/{customerToUpdate.id}/pets'
	And def random = function(max){ return Math.floor(Math.random() * max) }
	And def fakerObj = new faker()
	And def name = fakerObj.dog().name()
	And def type = random(6) 
	And request {"id":0,"name":"#()","birthDate":"2023-07-03T22:00:00.000Z","typeId":"#(type)"}
	When method post