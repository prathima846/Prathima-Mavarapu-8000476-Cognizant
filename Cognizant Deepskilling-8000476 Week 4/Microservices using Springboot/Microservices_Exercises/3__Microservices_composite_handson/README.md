# Microservices Composite Hands-on Exercises

This folder contains comprehensive hands-on exercises combining all microservices concepts into practical implementations.

## Topics Covered:

### 1. Enterprise Application Concepts
- Understanding complex enterprise systems (Banking example)
- Multiple services and sub-services architecture
- Different channels and devices serving the same business logic
- Service-level management in enterprise applications

### 2. Monolithic Architecture Challenges
- Single point of failure issues
- Memory leaks affecting entire system
- Performance bottlenecks across services
- Inability to scale individual components
- Technology stack limitations

### 3. Microservices Benefits
- Decentralized architecture
- Independent service scaling
- Isolated failures
- Technology flexibility
- Agility in development
- Continuous delivery capabilities

### 4. Building Multiple Microservices
- Account Microservice
  - Port: 8080
  - Endpoint: GET /accounts/{number}
  - Response: Account details (number, type, balance)

- Loan Microservice
  - Port: 8081
  - Endpoint: GET /loans/{number}
  - Response: Loan details (number, type, loan amount, EMI, tenure)

### 5. Service Registry & Discovery
- Eureka Discovery Server (Port 8761)
- Service registration and discovery
- Automatic service lookup
- Health checks and monitoring

### 6. API Gateway Implementation
- Centralized entry point (Port 9090)
- Request routing to appropriate services
- Logging and monitoring
- Cross-cutting concerns handling

## Architecture Diagram:
```
┌─────────────────────────────────────────────────┐
│                   Clients                       │
└────────────────────┬────────────────────────────┘
                     │
                     ▼
         ┌─────────────────────────┐
         │   API Gateway (9090)    │
         │  - Route requests       │
         │  - Log requests         │
         │  - Security             │
         └────────┬────────────────┘
                  │
                  ▼
         ┌──────────────────────────┐
         │ Eureka Server (8761)     │
         │ - Service Registry       │
         │ - Discovery              │
         └──────────────────────────┘
                  │
        ┌─────────┴─────────┐
        ▼                   ▼
   ┌─────────────┐   ┌─────────────┐
   │   Account   │   │    Loan     │
   │ Service     │   │ Service     │
   │ (8080)      │   │ (8081)      │
   └─────────────┘   └─────────────┘
```

## Key Implementation Steps:

1. **Create Microservices**
   - Set up Spring Boot projects
   - Implement REST endpoints
   - Configure ports

2. **Register with Eureka**
   - Add Eureka Discovery Client dependency
   - Configure application properties
   - Enable discovery client annotation

3. **Set up API Gateway**
   - Create Gateway microservice
   - Configure routes
   - Implement filters

4. **Testing & Validation**
   - Test direct service endpoints
   - Test through API Gateway
   - Verify Eureka registration
   - Check logging and monitoring

## Commands & URLs:

### Start Services:
1. Start Eureka Server first
2. Start Account Service (8080)
3. Start Loan Service (8081)
4. Start API Gateway (9090)

### Access Services:
- Eureka Dashboard: http://localhost:8761
- Account Direct: http://localhost:8080/accounts/00987987973432
- Loan Direct: http://localhost:8081/loans/H00987987972342
- Through Gateway: http://localhost:9090/greet-service/greet

## Troubleshooting:
- Port conflicts: Change server.port in application.properties
- Eureka not showing services: Check Eureka client configuration
- Gateway routing issues: Verify spring.cloud.gateway.discovery.locator settings
- Connection issues: Ensure all services are running before starting gateway

