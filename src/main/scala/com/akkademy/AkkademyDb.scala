package com.akkademy

import akka.actor.Actor
import akka.event.Logging
import scala.collection.mutable.HashMap
import com.akkademy.messages.SetRequest

/**
  * An actor which will make use of the [[com.akkademy.messages.SetRequest SetRequest]] message.
  *
  * The actor logs the message, and stores the contents of any SetRequest message for later retrieval.
  *
  */
class AkkademyDb extends Actor {
  val map = new HashMap [String, Object]
  val log = Logging(context.system, this)

  /**
    * This function defines how the actor should respond to different message types.
    *
    * If the message is a SetRequest, it will log that it received a SetRequest message with key and value.
    * If it is any other message, it will log 'unknown message' and the received message.
    *
    * @return Returns the Recieve, a partial function defined as: type Recieve = scala.ParialFunction[scala.Any, scala.Unit]
    *
    *
    */
  override def receive = {
    //Pattern Matching Semantings are used
    //to extract the key and value for easy use.
    case SetRequest (key, value) => {
      log.info("received SetRequest - key: {} value: {}", key, value)
      map.put(key,value)
    }
    case o => log.info("received unknown message: {}",o)
  }
}
