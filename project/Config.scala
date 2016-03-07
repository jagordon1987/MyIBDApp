import sbt._

object Config {
  def compile   (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "compile")
  def provided  (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "provided")
  def test      (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "test")

  val repos = Seq(
    "Central Maven Repository" at "https://repo1.maven.org/maven2",
    "Local Maven Repository" at Path.userHome.asFile.toURI.toURL + ".m2/repository",
    "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/"
  )
}
