addSbtPlugin("org.flywaydb" % "flyway-sbt" % "4.0.3")

resolvers += "Flyway" at "https://flywaydb.org/repo"


libraryDependencies += "org.mariadb.jdbc" % "mariadb-java-client" % "1.1.7"

addSbtPlugin("org.scalikejdbc" %% "scalikejdbc-mapper-generator" % "2.4.2")
