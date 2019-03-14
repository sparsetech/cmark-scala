enablePlugins(ScalaNativePlugin)

name := "cmark-scala"

version := "0.1.0-SNAPSHOT"

organization := "tech.sparse"

scalaVersion := "2.11.12"

libraryDependencies += "io.monix" %%% "minitest" % "2.3.2" % "test"

testFrameworks += new TestFramework("minitest.runner.Framework")
