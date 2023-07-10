Feature: list vets

Background:
	* url petclinic

Scenario: get all vets
  Given path 'api/vet/vets'
  When method get
  Then status 200
