# Microservice

Project Plan (Spring Boot Microservices)

We’ll create:

User Service (Spring Boot + MySQL/MongoDB)

APIs: POST /users, GET /users

Order Service (Spring Boot + MySQL)

APIs: POST /orders, GET /orders

Communicates with User Service via REST (to validate user).

Docker Compose to run both services + databases. 


microservices-springboot/

│── user-service/
|
│   ├── src/main/java/com/example/user/...
|
│   ├── pom.xml
|
│── order-service/
|
│   ├── src/main/java/com/example/order/...
|
│   ├── pom.xml
|
│── docker-compose.yml

