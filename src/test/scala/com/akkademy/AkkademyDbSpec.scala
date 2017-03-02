package com.akkademy

import akka.actor.ActorSystem
import akka.util.Timeout
import org.scalatest.{BeforeAndAfterEach, FunSpecLike, Matchers}
import com.akkademy.messages.SetRequest
import akka.testkit.TestActorRef
import scala.concurrent.duration

/**
  * This class extends [[http://doc.scalatest.org/2.2.1/index.html#org.scalatest.FunSpecLike FunSpecLike]]
  *
  * FunSpecLike is a trait for the class FunSpec, which is used to create tests and combine them
  * with text that specifies what the tests are verifying.
  *
  * @author Tom Heuer on 2017-3-2.
  *
  *
  */
class AkkademyDbSpec extends FunSpecLike with Matchers with BeforeAndAfterEach {
  /**
    * Holds a reference to an actor system
    *
    * Actor systems hold actors and their addresses.  This particular system contains an AkkademyDb actor
    * and the TestActorRef for manipulating it.
    *
    */
  implicit val system = ActorSystem()
  describe ("akkademyDb") {
    describe ("given SetRequest") {
      it ("should place key/value into map") {
        /**
          * Holds a TestActorRef of the AkkademyDb Actor
          *
          * TestActorRefs are similar to actors, but allow the user to interact with it for testing.
          * Normal actors do not allow users to manipulate them so easily.
          *
          * A new AkkademyDb Actor is created for use in the TestActorRef.
          */
        val actorRef = TestActorRef (new AkkademyDb)
        //The ! stands for tell, and sends a request to the actor.
        //The fact that there is nobody to respond to for this message
        //is implicit in scala. Note that tell is normally asynchronous,
        //but the use of TestActor means that the call will not continue until the
        //request is processed.
        actorRef ! SetRequest("key","value")

        //Inspects the map to ensure that the key processed successfully and is present
        val akkademyDb = actorRef.underlyingActor
        akkademyDb.map.get("key") should equal (Some("value"))
      }
    }
  }
}
