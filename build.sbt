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

lazy val tests = (project in file("unit-tests"))
  .settings(
    libraryDependencies += "org.scala-native" %%% "test-interface" % "0.3.8",
    testFrameworks += new TestFramework("tests.NativeFramework"),
    envVars in (Test, test) ++= Map(
      "USER"                           -> "scala-native",
      "HOME"                           -> baseDirectory.value.getAbsolutePath,
      "SCALA_NATIVE_ENV_WITH_EQUALS"   -> "1+1=2",
      "SCALA_NATIVE_ENV_WITHOUT_VALUE" -> "",
      "SCALA_NATIVE_ENV_WITH_UNICODE"  -> 0x2192.toChar.toString,
      "SCALA_NATIVE_USER_DIR"          -> System.getProperty("user.dir")
    )
  ).dependsOn(cmark)
  .enablePlugins(ScalaNativePlugin)

