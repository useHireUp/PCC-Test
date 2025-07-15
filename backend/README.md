# Backend Implementation Task

## Overview
This is a Spring Boot application for a medication request system. The frontend is already implemented and functional. Your task is to implement the missing backend functionality and write comprehensive tests.

## Application Architecture
- **Controllers**: Handle HTTP requests and delegate to Services
- **Services**: Contain business logic and use Repositories for data access
- **Repositories**: Handle database operations using Spring Data JPA
- **Models**: JPA entities representing database tables

## What You Need to Implement

### 1. Controllers
- **MedicationController**: Implement the `getAll()` method to return all medications
- **RequestController**: Implement the `submitRequest()` and `getAll()` methods

### 2. Services
- **MedicationService**: Implement all methods for medication management
- **RequestService**: Implement all methods for request management

### 3. Repository
- **RequestRepository**: The `findByPatientId()` method is already defined but you may need to implement it properly

### 4. Tests
You must implement comprehensive tests for all components:
- **Controller Tests**: Test all API endpoints using MockMvc
- **Service Tests**: Test all service methods using Mockito
- **Repository Tests**: Test repository methods using DataJpaTest
- **Test Coverage**: Write tests covering both success and error scenarios for all public methods

## API Endpoints to Implement

### GET /medications
- Returns a list of all available medications
- Should use the MedicationService

### GET /requests  
- Returns a list of all medication requests
- Should use the RequestService

### POST /requests
- Creates a new medication request
- Accepts a Request object in the request body
- Should use the RequestService

## Database
The application uses H2 in-memory database with JPA. The database schema is already defined in the model classes:
- `Medication`: id, name, dosage
- `Request`: id, patientId, medicationId

**Note**: The database starts empty. You may need to add some test data or handle empty database scenarios in your implementation.

## Getting Started
1. Make sure you have Java 17+ and Maven installed
2. Run `mvn spring-boot:run` to start the application
3. The application will start on `http://localhost:8080`
4. The frontend is configured to connect to this backend

## Testing
Run tests with: `mvn test`

You can test your implementation using:
- The frontend application
- Postman or any REST client
- The H2 console at `http://localhost:8080/h2-console` (if enabled)

## Test Requirements
- All controller endpoints must have tests
- All service methods must have tests
- Repository methods must have tests
- Tests should cover both success and failure scenarios
- Use appropriate testing annotations (@WebMvcTest, @ExtendWith(MockitoExtension.class), @DataJpaTest)
- Write comprehensive tests that validate the expected behavior of each method

## Implementation Guidelines
- Controllers should delegate to Services, Services should use Repositories
- Handle null cases and add appropriate error handling where needed
- Follow Spring Boot best practices for dependency injection and layering
- The application.properties file is already configured for H2 database
- For testing, use MockMvc for controllers, Mockito for services, and TestEntityManager for repositories

Good luck! 