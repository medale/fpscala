name := "fpscala"
organization := "com.uebercomputing"
version := "1.0"

scalaVersion := "2.13.6"

lazy val commonOverrides: Seq[ModuleID] = Seq(
 "org.typelevel" %% "discipline-core" % "1.1.5"
)

// https://www.scala-lang.org/2019/10/17/dependency-management.html
conflictManager := ConflictManager.strict

libraryDependencies += "org.typelevel" %% "cats-core" % "2.6.1"
libraryDependencies += "org.typelevel" %% "cats-laws" % "2.6.1"
libraryDependencies += "org.typelevel" %% "discipline-core" % "1.0.0"
libraryDependencies += "org.typelevel" %% "discipline-scalatest" % "2.1.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9"

dependencyOverrides ++= commonOverrides