# GMU Tutors Web Application
>**Why make the application?**

+ The idea for this application stemmed from an Amazon Alexa hack contest. 
  The idea of the contest was to develop an Amazon Alexa skill-kit that enabled improved access to 
  services on college campuses.
+ I came up with the idea to use Alexa to inform users about what tutors are available on campus 
  for specified subjects / times / locations.
+ Ultimately, this idea turned into what this project is now - a playground for me to learn developing a web app,
  as well as learning how to use ```MongoDB and NoSQL```.
  
>**What's the technology stack?**

* NoSQL Database:
    * [MongoDB](https://www.mongodb.com/)
* Java Backend:
    * Uses [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
    * [Spring Framework](https://spring.io/)
    * Maven is used to build the project.
* Angular 2 Frontend:
    * Built with [Angular CLI](https://cli.angular.io/)
    * [Bootstrap 4 Angular 2 directives](https://ng-bootstrap.github.io/#/home)
    * [PrimeNG](https://www.primefaces.org/primeng/)

>**How do I run the project?**

1. Start MongoDB service 
2. Start up the Spring app: 
    * ```mvn spring-boot:run```
3. ```cd``` into the webapp module
    * If starting from root directory, ```cd src/main/webapp``` should suffice.
4. Start up the web-app: 
    * ```ng serve``` 
    * Navigate to ```localhost:4200``` to view the web-app.
    * Navigate to ```localhost:8150/swagger-ui.html``` to view the `Swagger` generated 
      `REST API` documentation.
    
**_And then you're done!_**

# Thanks for reading :smile: