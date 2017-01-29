# Microservices

This is an example of microservices with <b>Spring Cloud</b> and <b>Netflix OSS</b>. 
<br/><br/>
Each microservice is developed as standalone Spring Boot application using Gradle
<br/>
The project contains the following structure:

Two core services responsible for handling information regarding products and recommendations.
One composite service, product-composite-tms, that can aggregate information from the two core services and compose a view of product information together with recommendations of a product.
To support the business services we use the following infrastructure services and components:

<b>Netflix Eureka</b> - Used for Service Discovery<br/>
<b>Netflix Ribbon</b> - Dynamic Routing and Load Balancer<br/>
<b>Netflix Hystrix</b> - Circuit Breaker<br/>
<b>Turbine and Hystrix</b> - Monitoring <br/>
<b>Edge Server (Netflix Zuul)</b> -  It's used for communication to the outside world. Services are registered at runtime, so it is used to call services internally using service discovery.
 
