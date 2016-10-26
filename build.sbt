val defaultSettings = Seq(scalaVersion := "2.11.8")

lazy val core = (project in file("core")).settings(defaultSettings: _*)
