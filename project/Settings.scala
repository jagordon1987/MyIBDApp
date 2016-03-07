import sbt.Keys._

object Settings {
  lazy val basicSettings = Seq(
    scalaVersion := "2.11.7",
    scalaBinaryVersion := "2.11",
    autoScalaLibrary := false,
    resolvers ++= Config.repos,
    scalacOptions := Seq(
      "-encoding", "utf8",
      "-feature",
      "-unchecked",
      "-deprecation",
      "-target:jvm-1.8",
      "-language:_",
      "-Xlog-reflective-calls",
      "-Ylog-classpath"
    )
  )
}
