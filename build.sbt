import com.typesafe.sbt.SbtStartScript

name := "myproject"

organization := "my.org"

version := "0.1"

scalaVersion := "2.11.0"

//Define dependencies. These ones are only required for Test and Integration Test scopes.
libraryDependencies ++= Seq(
    "org.scalatest"   %% "scalatest"    % "2.1.7"   % "test,it",
    "org.scalacheck"  %% "scalacheck"   % "1.11.4"      % "test,it",
    "com.typesafe.akka" %% "akka-actor" % "2.3.3",
    "org.scala-lang" % "scala-swing" % "2.11.0-M7",
    "commons-io" % "commons-io" % "2.4"
)

// For Settings/Task reference, see http://www.scala-sbt.org/release/sxr/sbt/Keys.scala.html

// Compiler settings. Use scalac -X for other options and their description.
// See Here for more info http://www.scala-lang.org/files/archive/nightly/docs/manual/html/scalac.html 
scalacOptions ++= List("-feature","-deprecation", "-unchecked", "-Xlint")

// ScalaTest settings.
// Ignore tests tagged as @Slow (they should be picked only by integration test)
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-l", "org.scalatest.tags.Slow", "-u","target/junit-xml-reports", "-oD", "-eS")

//Style Check section 
org.scalastyle.sbt.ScalastylePlugin.Settings

org.scalastyle.sbt.PluginKeys.config <<= baseDirectory { _ / "src/main/config" / "scalastyle-config.xml" }
