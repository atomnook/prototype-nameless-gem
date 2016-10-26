# nameless-gem

[![Build Status](https://travis-ci.org/atomnook/nameless-gem.svg?branch=master)](https://travis-ci.org/atomnook/nameless-gem)

## Local

### Setup
```
$ vagrant up

$ sbt -Dflyway.url=jdbc:mariadb://192.168.33.10:3306/ \
      -Dflyway.user=admin \
      -Dflyway.password=admin \
      -Dflyway.schemas=flyway \
      -Dflyway.locations=classpath:db/migration \
      mysql/flywayMigrate
```

### Reverse Engineering
```
$ sbt "mysql/scalikejdbcGen TODO"
```
