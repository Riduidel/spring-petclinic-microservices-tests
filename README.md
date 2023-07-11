# Spring-petclinic-microservices tests

This project provides a full HTTP testing solution for petclinic including

* API tests using Karate
* Performance tests using Karate-Gatling

## How to run

* `mvn test` will run the karate tests
* `mvn test -Pgatling` will run the karate tests then the performance tests

### Running tests on a specific server

If you want to run these tests on a server that is not localhost you can either

* Add the `-Durl={tested server}` on command-line
* Edit the `karate-config.js` file to change the `petclinic` parameter

Prefer the first solution, which has no impact on SCM files.

### Reading the reports

Karate reports are in the `target\karate-reports` directory.
Gatling reports are in the `target\gatling` directory.