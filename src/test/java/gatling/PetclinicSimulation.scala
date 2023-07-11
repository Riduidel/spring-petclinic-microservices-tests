package gatling

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class PetclinicSimulation extends Simulation {
	// Allow correct aggregation of results
	val protocol = karateProtocol(
	)

	protocol.nameResolver = (req, ctx) => req.getHeader("karate-name")
	protocol.runner.karateEnv("perf")
	
	val get_vets = scenario("get_vets").exec(karateFeature("classpath:karate/get/vets.feature"))
	val get_customers = scenario("get_customers").exec(karateFeature("classpath:karate/get/customers.feature"))
	val create_customers = scenario("create_customers").exec(karateFeature("classpath:karate/create/customers.feature"))
	val create_pets = scenario("create_pets").exec(karateFeature("classpath:karate/create/pets.feature"))
	
	setUp(
		get_vets.inject(rampUsers(1000) during (10 seconds)).protocols(protocol),
		get_customers.inject(rampUsers(1000) during (5 seconds)).protocols(protocol),
		create_customers.inject(rampUsers(100) during (5 seconds)).protocols(protocol),
		create_pets.inject(rampUsers(1000) during (5 seconds)).protocols(protocol),
	)
}