GMU Tutors Web Application
==========================
> A full stack web application to connect students with peer mentors on campus.

This project is an application of things I learn about the technologies I learn at work and in my free time.

### Why make the application?

- The idea for this application stemmed from an Amazon Alexa hack contest. 
  The idea of the contest was to develop an Amazon Alexa skill-kit that enabled improved access to 
  services on college campuses.
- I came up with the idea to use Alexa to inform users about what tutors are available on campus 
  for specified subjects / times / locations.
- Ultimately, this idea turned into what this project was - a playground for me to learn developing a web app,
  as well as learning how to use `MongoDB and NoSQL`.
- As of now, the project is just for me to continue practicing what I learn about Spring Boot and Angular 2+.
  
### What's the technology stack?

- MySQL database
- Java Backend:
    - Uses [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
    - [Spring Framework](https://spring.io/)
    - Gradle is used to build this project
- Angular 2 Frontend:
    - Built with [Angular CLI](https://cli.angular.io/)
    - [Bootstrap 4 Angular 2 directives](https://ng-bootstrap.github.io/#/home)
    - [PrimeNG](https://www.primefaces.org/primeng/)
- Containerized with [Docker](https://docs.docker.com/engine/installation/)    

## How do I run the project?

#### Setup
- Download/Setup Docker and Docker Compose
- Set environment variables
  - note: NODE_SETUP_REQUIRED value depends on whether or not you have nodejs and/or yarn set up on your host machine
  
  - On Linux and Unix (in ~/.bashrc file)
    ```bash
    export MYSQL_USERNAME=myUsername
    export MYSQL_PASSWORD=myPassword
    export NODE_SETUP_REQUIRED=true
    ```
    - Then source the variables with `source ~/.bashrc`
  
  - On Windows (in command line)
    ```cmd
    set MYSQL_USERNAME=myUsername
    set MYSQL_PASSWORD=myPassword
    set NODE_SETUP_REQUIRED=false
    ```

#### Running the Project
- Run the entire application with `./gradlew composeUp`
- Navigate to `localhost:8080` to see the application at work
- Terminate the application with `./gradlew composeDown`
