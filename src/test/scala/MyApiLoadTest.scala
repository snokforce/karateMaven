import com.intuit.karate.gatling.PreDef.*
import io.gatling.core.Predef.{Simulation, rampUsers, scenario}
import io.gatling.core.Predef.openInjectionProfileFactory

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class MyApiLoadTest extends Simulation {

  val protocol = karateProtocol(
    "/users/1" -> Nil
  )

  val myApiTest = scenario("get users").exec(karateFeature("classpath:examples"))

  setUp(
    myApiTest.inject(rampUsers(100) during (60 seconds))
  ).protocols(protocol)

}
