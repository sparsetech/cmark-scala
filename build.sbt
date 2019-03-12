scalaVersion in ThisBuild := "2.11.12"

nativeLinkStubs := true

lazy val root = (project in file("."))
  .aggregate(cmark, tests)

lazy val commonSettings = Seq(
  organization := "tech.sparse",
  version := "0.1.0-SNAPSHOT"
)

lazy val cmark = (project in file("cmark"))
  .settings(commonSettings)
  .enablePlugins(ScalaNativePlugin)

lazy val tests = (project in file("tests"))
  .settings(
    libraryDependencies += "org.scala-native" %%% "test-interface" % "0.3.8",
    testFrameworks += new TestFramework("tests.NativeFramework")
  ).dependsOn(cmark)
  .enablePlugins(ScalaNativePlugin)
