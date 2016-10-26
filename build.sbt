val defaultSettings = Seq(scalaVersion := "2.11.8")

val scalaz = Seq(libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.6")

lazy val domain = (project in file("domain")).settings(defaultSettings ++ scalaz: _*)

lazy val core = (project in file("core")).settings(defaultSettings: _*)
