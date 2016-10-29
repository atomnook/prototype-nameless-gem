val defaultSetting = Seq(scalaVersion := "2.11.8")

val mariadbSetting = Seq(libraryDependencies += "org.mariadb.jdbc" % "mariadb-java-client" % "1.1.7")

val scalazSetting = Seq(libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.2.6")

val scalikejdbcSetting = Seq(
  libraryDependencies ++= Seq(
    "org.scalikejdbc" %% "scalikejdbc" % "2.4.2",
    "ch.qos.logback" % "logback-classic" % "1.1.7")) ++ mariadbSetting ++ scalikejdbcSettings

val scalapbSetting = Seq(
  PB.targets in Compile := Seq(scalapb.gen(flatPackage = true, singleLineToString = true) ->
    (sourceManaged in Compile).value),
  libraryDependencies += "com.trueaccord.scalapb" %% "scalapb-runtime" % "0.5.42" % "protobuf")

lazy val proto = (project in file("proto")).settings(defaultSetting ++ scalapbSetting: _*)

lazy val mysql = (project in file("mysql")).settings(defaultSetting ++ scalikejdbcSetting: _*)

lazy val domain = (project in file("domain")).settings(defaultSetting ++ scalazSetting: _*)

lazy val core = (project in file("core")).settings(defaultSetting: _*)
