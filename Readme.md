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
