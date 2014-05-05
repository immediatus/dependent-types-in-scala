import sbt._

object Dependencies {
  val resolutionRepos = Seq(
    "Typesafe repo" at "http://repo.typesafe.com/typesafe/releases/"
  )

  def compile   (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "compile")
  def provided  (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "provided")
  def test      (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "test")
  def runtime   (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "runtime")
  def container (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "container")

  object V {
    val scala         = "2.10.3"
    val specs2        = "2.0"
  }

  val specs2          = "org.specs2"                    %%  "specs2"              % V.specs2
}
