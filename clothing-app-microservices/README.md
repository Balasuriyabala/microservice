# Clothing App Microservices (Spring Boot + Nginx Frontend)

This is a beginner-friendly microservices demo for a Clothing Store:
- **User Service** (Spring Boot, port 5000)
- **Product Service** (Spring Boot, port 6000)
- **Order Service** (Spring Boot, port 7000) — calls User and Product services
- **Frontend + API Gateway** (Nginx, port 8080) — serves a static UI and proxies `/api/*` to the services

## Run Locally

Prereqs: Docker, Docker Compose, Maven, JDK 17

1. Build JARs for each service:
   ```bash
   mvn -f user-service/pom.xml clean package -DskipTests
   mvn -f product-service/pom.xml clean package -DskipTests
   mvn -f order-service/pom.xml clean package -DskipTests
   ```

2. Start everything:
   ```bash
   docker-compose up --build
   ```

3. Open the app:
   - Frontend/UI: http://localhost:8080
   - Alternatively test APIs directly:
     - `POST http://localhost:5000/users`
     - `POST http://localhost:6000/products`
     - `POST http://localhost:7000/orders`

## How Microservices Communicate
- The **Order Service** uses `RestTemplate` to call User and Product services by their Docker Compose service names:
  - `http://user-service:5000/users/{id}`
  - `http://product-service:6000/products/{id}`

## Next Steps (Optional Enhancements)
- Replace in-memory lists with MySQL (JPA) per service
- Add API Gateway (Spring Cloud Gateway) & Service Discovery (Eureka)
- Add CI/CD (GitHub Actions) to build & push Docker images
- Deploy to Kubernetes (Ingress for `/api/*` and a Service for the frontend)
