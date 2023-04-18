package simulations

import com.intuit.karate.gatling.PreDef.*
import io.gatling.core.Predef.*

import scala.concurrent.duration.*
import scala.language.postfixOps

class LoadTest extends Simulation {

  val protocol = karateProtocol(
    "/users" -> Nil
  )

  val myApiTest = scenario("Get user data").exec(karateFeature("classpath:simulations/api/myApiTest.feature"))

  setUp(
    myApiTest.inject(rampUsers(10) during (10 seconds)).protocols(protocol)
  )
}
