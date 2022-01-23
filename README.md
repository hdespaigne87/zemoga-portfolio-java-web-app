# Zemoga portfolio java web app
Simple portfolio Java web app that displays the profile image, name, some text with the experience and a 5 tweet list of the user’s Twitter timeline.

##Software prerequisites

- Java 11 installed
- Git installed
- Any Java IDE installed

##Technologies used

- MySQL
- Java 11
- Spring Boot 2.5.5
- Spring Data JPA
- Thymeleaf Template Engine
- Spring Social Twitter
- Mapstruct
- Lombok

##How to get the application up and running?

### 1. Clone the project from [GitHub](https://github.com/hdespaigne87/zemoga-portfolio-java-web-app) using the following command

```shell
$ git clone https://github.com/hdespaigne87/zemoga-portfolio-java-web-app.git
```

### 2. Go into the application root folder

```shell
$ cd zemoga-portfolio-java-web-app
```

### 3. Create a file named local_env_variables.env and put them all the values for the environment variables the project needs, that are:

```
SERVER_HTTP_PORT_WEB_FRONTEND=SPECIFY_THE_VALUE
SERVER_HTTP_PORT_REST_API=SPECIFY_THE_VALUE
DB_HOST=SPECIFY_THE_VALUE
DB_PORT=SPECIFY_THE_VALUE
DB_NAME=SPECIFY_THE_VALUE
DB_USER=SPECIFY_THE_VALUE
DB_PASSWORD=SPECIFY_THE_VALUE
SHOW_SQL=SPECIFY_THE_VALUE
TWITTER_API_KEY=SPECIFY_THE_VALUE
TWITTER_API_SECRET_KEY=SPECIFY_THE_VALUE
TWITTER_ACCESS_TOKEN=SPECIFY_THE_VALUE
TWITTER_ACCESS_TOKEN_SECRET=SPECIFY_THE_VALUE
PROFILE_MAX_TWEETS=SPECIFY_THE_VALUE
```

#### NOTE: For each entry you have to replace the text SPECIFY_THE_VALUE for the specific value of the property. Don't use quotes. Example: SERVER_HTTP_PORT_WEB_FRONTEND=8080 

### 4. Export all the previous environment variables to the operating system. Example for MacOS:

```shell
$ export SERVER_HTTP_PORT_WEB_FRONTEND=8080
```

### 5. Build and install the application

```shell
$ ./mvnw clean install
```

### 6. Run Test Suite

```shell
$ ./mvnw test
```

### 7. Run the REST API application

```shell
$ cd rest-api
```

```shell
$ .././mvnw spring-boot:run
```

### 8. Run the Web Frontend application

```shell
$ cd web-frontend
```

```shell
$ .././mvnw spring-boot:run
```

#### NOTE: Steps 7 and 8 can be performed in parallel in different terminals 

### 9. Open the application in the browser

####NOTE: Supposing the Web Frontend is exposed on port 8080 and the REST API on port 8081. The URLs to access are:

- Web Frontend [http://localhost:8080/](http://localhost:8080/)
- REST API [http://localhost:8081/swagger-ui/](http://localhost:8081/swagger-ui/)

##Total time to complete the test

The total time dedicated to this application was 5 hours. The main performed activities were:

- Architecture definition
- Development of features
- Creation of test suite
- Documentation
