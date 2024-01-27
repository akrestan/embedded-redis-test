# embedded-redis-test

Codemonstur  embedded Redis in docker container test

Forked from [codemonstur](https://github.com/codemonstur/embedded-redis) (forked from [ozimov](https://github.com/ozimov/embedded-redis), (forked from [kstyrc](https://github.com/kstyrc/embedded-redis)))

Maven dependency

```xml
<dependency>
  <groupId>com.github.codemonstur</groupId>
  <artifactId>embedded-redis</artifactId>
  <version>1.3.0</version>
</dependency>
```

Usage in a project is as follows

```java
RedisServer redisServer = new RedisServer(6379);
redisServer.start();
// do some work
redisServer.stop();
```

For the rest of the documentation see the original [codemonstur](https://github.com/codemonstur/embedded-redis)

## Purpose

The purpose of this project is the demonstrate the problem occuring when running the above code
in RHEL8-based image vs running in a RHEL9-based image

* The original is unchanged, only instrumented with additional logs
* A client has been added to simulate the usage in the currently failing tests


Steps to reproduce run these steps in the root of the project (java 17 and docker is needed)

```bash
./gradlew build
```
```bash
docker build -t eps/build-container -f  docker/Dockerfile .
```

```bash
docker run -ti  --rm --name builder eps/build-container
```

Run first as it is to see the expected output when everything works just fine, then edit the [docker/Dockerfile](docker/Dockerfile) 
to replace RHEL9/ubi9 base image with RHEL8/ubi8

```bash
docker build -t eps/build-container -f  docker/Dockerfile .
```

```bash
docker run -ti  --rm --name builder eps/build-container
```

You will see the error that it can be seen in the current  Betradar unifier build