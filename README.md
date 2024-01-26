# embedded-redis-test

Codemonstur  embedded Redis in docker container test

Forked from [codemonstur](https://github.com/codemonstur/embedded-redis)
fork from [ozimov](https://github.com/ozimov/embedded-redis),
forked from [kstyrc](https://github.com/kstyrc/embedded-redis)

Maven dependency

Maven Central:
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

For the rest of the documentation see the [codemonstur](https://github.com/codemonstur/embedded-redis)

The purpose of this project is the demonstrate the problem occuring when running the above code
in RHEL8-based image vs running in in a RHEL9-based image

* The original is unchanged, only instrumented with additional logs
* A client has been added to simulate the usage in the currently failing tests


Steps to reproduce run these steps in the root of the project

```bash
./gradlew build
```
```bash
docker build -t eps/build-container -f  docker/Dockerfile .
```

```bash
docker run -ti  --rm --name builder eps/build-container
```


