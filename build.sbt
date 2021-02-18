version in ThisBuild := "0.1.0"

lazy val root = (project in file("."))
  .settings(
    name := "playground",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.3" % Test,
    ),
    scalaVersion := "2.12.12"
  )
