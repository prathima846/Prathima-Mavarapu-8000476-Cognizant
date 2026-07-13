# Microservices with API Gateway

This folder contains hands-on exercises for building microservices with an API Gateway using Spring Boot and Spring Cloud.

## Key Topics Covered:

### Enterprise Application Architecture
- Understanding bank services and product hierarchies
- Monolithic vs Microservices architecture comparison
- Real-world scenarios and use cases

### Microservices Implementation:

#### 1. Creating Account and Loan Microservices
- Account Microservice (Port 8080)
  - GET /accounts/{number} endpoint
  - Returns account details in JSON format
  
- Loan Microservice (Port 8081)
  - GET /loans/{number} endpoint
  - Returns loan details in JSON format

#### 2. Service Discovery with Eureka
- Eureka Discovery Server setup (Port 8761)
- Registering microservices with Eureka
- Dynamic service discovery

#### 3. API Gateway with Logging
- Spring Cloud API Gateway implementation (Port 9090)
- Global filter for request logging
- Service-to-gateway routing
- URL mapping and request handling

#### 4. Greet Microservice
- Simple microservice returning "Hello World"
- Service registration with Eureka
- Access through API Gateway

## Architecture Flow:
```
Client → API Gateway (9090) → Eureka Discovery Server → Microservices (8080, 8081, etc.)
```

## Step-by-Step Implementation:
1. Set up Eureka Discovery Server
2. Create Account and Loan microservices
3. Create Greet microservice
4. Configure API Gateway
5. Implement global logging filter
6. Test service-to-gateway communication

## Testing URLs:
- Direct greet service: http://localhost:8080/greet
- Through API Gateway: http://localhost:9090/greet-service/greet
- Eureka Dashboard: http://localhost:8761

