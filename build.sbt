name := "fpscala"
organization := "com.uebercomputing"
version := "1.0"

scalaVersion := "2.12.11"

// https://www.scala-lang.org/2019/10/17/dependency-management.html
conflictManager := ConflictManager.strict

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.4"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.3" % "test"
