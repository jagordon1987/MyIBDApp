import Config._

lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .settings(Settings.basicSettings: _*)
  .settings(libraryDependencies ++= Seq(
    javaJpa,
    cache,
    javaWs,
    evolutions,
    jdbc,
    "org.hibernate" % "hibernate-entitymanager" % "4.3.9.Final"
  ) ++ Config.test(
    "junit" % "junit" % "4.11"
  ))

ivyScala := ivyScala.value map {
  _.copy(overrideScalaVersion = true)
}

fork in run := true
routesGenerator := InjectedRoutesGenerator
