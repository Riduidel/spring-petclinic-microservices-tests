Feature: list owners

Background:
	* url petclinic

Scenario: add a new customer
	Given path 'api/customer/owners'
	And def fakerObj = new faker()
	And def firstName = fakerObj.name().firstName()
	And def lastName = fakerObj.name().lastName()
	And def street = fakerObj.address().streetAddress()
	And def city = fakerObj.address().city()
	And def phone = "9055544487"
	And request {"firstName":"#(firstName)", "lastName":"#(lastName)", "address":"#(street)", "city":"#(city)", "telephone":"#(phone)"}
	When method post
	Then status 201
	Then header Content-type = 'application/json'
	Then match response contains {id: '#notnull'}
