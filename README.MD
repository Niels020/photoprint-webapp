# Final project java advanced course

In this app I build a spring-boot REST Api for a webshop of a photo printing store.
It was my final project after finishing the udemy course java advanced,
https://www.udemy.com/course/the-complete-spring-boot-development-bootcamp
The backend REST Api is done, although I would love to add some features at some point.
The frontend is a React app and is still a work in progress.

## install

front-end
* cd app/frontend
* npm install
* npm start

back-end
* cd app/backend
* mvn clean spring-boot:run

## Spring-boot REST Api 

For the project I added all requirements in the corresponding directory.
Also included is a Postman collection mapping all the endpoints.
The spring-boot app defaults to a Tomcat server on port 8080.
A h2 database is configured to test all sql tables on: http://localhost:8080/h2
With spring-doc openapi details api documentation can be found on: http://localhost:8080/swagger-ui/index.html#/

## React-app 

Work-in-progress...