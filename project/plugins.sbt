logLevel := Level.Warn

// https://github.com/jrudolph/sbt-dependency-graph/releases
// invoke via: dependencyTree
// invoke via: whatDependsOn <org> <module> <revision>
// whatDependsOn commons-beanutils commons-beanutils-core 1.8.0
addDependencyTreePlugin

// https://bintray.com/sbt/sbt-plugin-releases
// invoke via: sbt assembly
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.15.0")

// https://scalacenter.github.io/scalafix/
// invoke via: fix alias
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.9.15")

// https://github.com/scalameta/sbt-scalafmt
// invoke via: scalafmtAll
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.3.4")

// https://github.com/rtimush/sbt-updates
// invoke via: dependencyUpdates
// invoke via: dependencyUpdatesReport (default output target/dependency-updates.txt)
// dependencyUpdatesFilter -= moduleFilter(organization = "org.scala-lang")
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.5.1")

