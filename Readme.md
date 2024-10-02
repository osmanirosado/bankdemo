# Bank demo

## Initialize Database

Run the database and initialize the bank database using the script `update-schema.sql`
```shell
docker compose up db
```

## Build app

Build the Docker image
```shell
docker compose build app
```

## Run app

Run the application
```shell
docker compose up app
```

## Test

HTTP Get request to get users
```shell
curl http://localhost:8080/users
```
```
[{"id":1,"username":"pedro","name":"Pedro","age":12},{"id":2,"username":"maria","name":"Maria","age":24}]
```

## References

- [Containerize a Java application - Docker Docs Guide](https://docs.docker.com/guides/language/java/containerize/)
- [Dockerfiles - Spring Boot Reference](https://docs.spring.io/spring-boot/reference/packaging/container-images/dockerfiles.html)
- [Spring Boot with Docker - Spring Boot Guide](https://spring.io/guides/gs/spring-boot-docker)
- [Profiles - Spring Boot Reference](https://docs.spring.io/spring-boot/reference/features/profiles.html)
- [Profile Specific Files - Spring Boot Reference](https://docs.spring.io/spring-boot/reference/features/external-config.html#features.external-config.files.profile-specific)
