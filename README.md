# Microservice

Project Plan (Spring Boot Microservices)

We’ll create:

User Service (Spring Boot + MySQL/MongoDB)

APIs: POST /users, GET /users

Order Service (Spring Boot + MySQL)

APIs: POST /orders, GET /orders

Communicates with User Service via REST (to validate user).

Docker Compose to run both services + databases. 


cd user-service -->   mvn clean package -DskipTests

cd ../product-service --> mvn clean package -DskipTests

cd ../order-service --> mvn clean package -DskipTests

To run in background:

docker-compose down -d

