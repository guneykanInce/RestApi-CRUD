# User Account Management API
CRUD operations with RestApi services and RobotFramework for BDD, JUNIT5 for unit test, Docker, CI with GitHub Actions

## Requirements

* Java 8+
* Maven 4+

## Tech Stack

* [Spring Boot](https://projects.spring.io/spring-boot/)
* [H2 Database](https://www.h2database.com/html/main.html)
* [Junit5](https://junit.org/junit5/)
* [Robot Framework](https://robotframework.org/)
* [Docker](https://hub.docker.com/)

## Setup 

Clone the repository from git

```bash
git clone https://github.com/guneykanInce/RestApi-CRUD.git 
```
Download  libraries  with Maven

```bash
mvn clean install
```

## Run

```bash
mvn spring-boot:run
```
Go http://localhost:8080/

## Run with Docker

```bash
docker pull guneykanince/useraccountapi:latest
```

```bash
docker run -p 8080:8080 -t guneykanince/useraccountapi:latest
```
