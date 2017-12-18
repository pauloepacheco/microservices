# Product Recommendation Microservices

This is an example of microservices using **Spring Cloud** and **Netflix OSS** stack. 

Each microservice is developed as standalone Spring Boot application using Gradle for continuous integration.

This app is intended to compose a view of recommendations of a product.

There are three spring boot apps to support this functionality using the Microservice approach.
   
   Two core services responsible for handling information regarding products and its recommendations
   
   A composite service, product-composite-tms that is used to compose a view of a product with its recommendations. This module is also used for communication between the infrastructure services and core services to avoid calling the core services directly one by one.
 
Netflix OSS Stack is used to support the infrastructure services and components along with other technologies described below.

| Component            | Description                             |
| ----------           | ------------------------                |
| Netflix Eureka       | Service Discovery                       |
| Netflix Ribbon       | Dynamic Routing and Load Balancer       |
| Netflix Hystrix      | Circuit Breaker                         |
| Turbine and Hystrix  | Dashbord for monitoring                 |
| Netflix Zuul         | Gateway to filter requests from outside |
| MongoDB              | NoSQL database                          |
 
