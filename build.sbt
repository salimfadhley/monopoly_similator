name := "monopoly"

version := "1.0"

scalaVersion := "2.12.1"


val scalatestVersion = "3.0.1"
val main = "simulation.Main"

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-simple" % "1.6.4",

  "org.scalactic" %% "scalactic" % scalatestVersion,
  "org.scalatest" %% "scalatest" % scalatestVersion % "test"
)

mainClass in (Compile, packageBin) := Some(main)

mainClass in (Compile, run) := Some(main)