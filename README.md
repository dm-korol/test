# Senselize Data Processing Service
This service provides REST API to create fields and crops, get crop prediction, status of the service and documentation:

* add new field:
```
POST /api/field
```

* add new crop:
```
POST /api/crop
```

* get crop by id:
```
GET /api/crop/{id}
```

* check service status:
```
GET /api/live
```

* get API documentation:
```
GET /docs
```

## Stack
Java 11\
Gradle\
PostgreSQL\
OpenAPI\
Lombok\
TestNg\
RestAssured

## Setup & Build

1. Clone this repository
2. Run PostgreSql server
3. To start application run EntryPoint class from:
```
/src/main/java/EntryPoint.java
```
4. On the first run application will init database structure automatically by:
```
/resources/database/init_db.sql
```
NOTE: tables will be created if not exists

5. To build the application run:
```
gradle build -x testIntegration
```
6.To run integration tests
```
gradle testIntegration
* Database should be up and have all neded data for aplication
* Application should be running and listing on localhost:8080
```
7. To start with docker run:
```
docker-compose build && docker-compose-debug up
```
8. To start docker in debug mode (only database) run:
```
docker-compose -f docker-compose.debug.yaml up --build
```
JAR/WAR file will be placed in 'build' folder

## API documentation

1. JSON format - http://localhost:8080/docs

2. UI - http://localhost:8080/swagger-ui.html

## Requests examples:

Create field JSON example:
```
{
    "longitude": 222.333,
    "width": 1111.8888,
    "fieldId": 234
}
```

Create crop JSON example:
```
{
    "fieldId": 1,
    "startDate": 1619534504,
    "culture": "wheat",
    "type": "winter",
    "currentStage": 0,
    "depth": 42,
    "fngcd": true,
    "rate": 1,
    "strt": 2,
    "pod": 3
}
```