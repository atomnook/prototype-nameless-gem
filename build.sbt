val defaultSettings = Seq(scalaVersion := "2.11.8")

val mariadb = Seq(libraryDependencies += "org.mariadb.jdbc" % "mariadb-java-client" % "1.1.7")

val scalaz = Seq(libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.6")

val scalikejdbc = Seq(
  libraryDependencies ++= Seq(
    "org.scalikejdbc" %% "scalikejdbc" % "2.4.2",
    "ch.qos.logback" % "logback-classic" % "1.1.7")) ++ mariadb ++ scalikejdbcSettings

lazy val mysql = (project in file("mysql")).settings(scalikejdbc: _*)

lazy val domain = (project in file("domain")).settings(defaultSettings ++ scalaz: _*)

lazy val core = (project in file("core")).settings(defaultSettings: _*)
