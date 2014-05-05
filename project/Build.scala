import sbt._
import Keys._

object Build extends sbt.Build {
  import Dependencies._

  lazy val commonSettings = Defaults.defaultSettings ++ Seq(
    organization  := "com.immediatus",
    version       := "0.1",
    scalaVersion  := V.scala,
    scalacOptions := Seq("-deprecation", "-unchecked", "-encoding", "utf8"),
    resolvers     ++= Dependencies.resolutionRepos
  )

  lazy val core = Project("dependent-types-in-scala", file("."), settings = commonSettings)
    .settings {
      libraryDependencies ++=
        compile() ++
        test(specs2)
    }
}
