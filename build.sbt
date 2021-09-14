enablePlugins(ScalaNativePlugin)

name := "cmark-scala"

version := "0.2.0-SNAPSHOT"

organization := "tech.sparse"

scalaVersion := "2.13.6"

libraryDependencies += "org.scalameta" %%% "munit" % "0.7.29" % Test

testFrameworks += new TestFramework("munit.Framework")
