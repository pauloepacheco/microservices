# microservices

This is an example of microservices with Spring Cloud and Netflix OSS.
Each microservice is developed as standalone Spring Boot application using Gradle.

The project contains the following structure:

Two core services responsible for handling information regarding products and recommendations.
One composite service, product-composite-tms, that can aggregate information from the two core services and compose a view of product information together with recommendations of a product.
To support the business services we use the following infrastructure services and components:

Netflix Eureka - Used for Service Discovery
Netflix Ribbon - Dynamic Routing and Load Balancer 
Edge Server (Netflix Zuul) -  It's used for communication to the outside world. Services are registered at runtime, so it is used to call services internally using service discovery.
 
