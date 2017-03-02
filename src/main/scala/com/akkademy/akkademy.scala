package com.akkademy.messages


/**
  * SetRequest creates an immutable message with a string key and object value.
  *
  * This is a case class, which is what scala uses to create immutable messages.
  * Values can only be set once by the constructor, and from then on are read from the fields.
  *
  * @author Tom Heuer on 3/2/17.
  */


case class SetRequest ( key: String, value: Object)



