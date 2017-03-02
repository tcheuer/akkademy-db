name := """akkademy-db"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
  ,"com.typesafe.akka" %% "akka-actor" % "2.3.3"
  ,"com.typesafe.akka" %% "akka-testkit" % "2.3.6" % "test"
)

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

