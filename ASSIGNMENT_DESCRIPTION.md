# Medication Request System - Full Assignment Description

## Project Overview

You are tasked with building a **Medication Request System** for a healthcare facility. This system allows nurses to submit medication requests for patients, which are then reviewed and approved/rejected by administrative staff. The system must be secure, user-friendly, and follow healthcare compliance standards.

### What You Need to Build

**Frontend (COMPLETE - No work needed)**
- The React frontend is already built and working
- It includes medication list display and request submission forms
- It's ready to connect to your backend API

**Backend (YOUR TASK - Build this)**
- Create a Spring Boot application with REST API endpoints
- Implement database models and repositories
- Add business logic services
- Implement security and validation
- Create comprehensive tests

**Database (YOUR TASK - Design and implement this)**
- Design and create MySQL database tables
- Set up proper relationships between tables
- Add sample data for testing

**Testing (YOUR TASK - Write this)**
- Unit tests for all business logic
- Integration tests for API endpoints
- Security tests for role-based access

**Documentation (YOUR TASK - Write this)**
- API documentation
- Setup instructions
- Architecture documentation

## Business Context

In a healthcare environment, medication requests are critical workflows that require proper authorization, tracking, and audit trails. Nurses need to request medications for patients, and administrators need to review these requests to ensure proper medication management and patient safety.

## Use Cases

### What the System Does

#### 1. **View Medications**
- **Who**: Anyone (nurses, admins, etc.)
- **What**: See a list of all available medications
- **How**: Open the medication list page
- **Result**: Shows medication names and dosages

#### 2. **Submit a Request**
- **Who**: Nurses only
- **What**: Request a medication for a patient
- **How**: 
  1. Enter patient ID
  2. Select medication from list
  3. Click submit
- **Result**: Request is sent and marked as "pending"

#### 3. **Review Requests**
- **Who**: Admins only
- **What**: See all medication requests
- **How**: Open the requests page
- **Result**: Shows list of all requests with patient info and status

#### 4. **Approve or Reject Requests**
- **Who**: Admins only
- **What**: Decide whether to approve or reject a request
- **How**: 
  1. Click on a pending request
  2. Choose approve or reject
  3. Add optional notes
- **Result**: Request status changes and is logged

#### 5. **Check Request Status**
- **Who**: Nurses and admins
- **What**: See if a request was approved or rejected
- **How**: Look at the request in the system
- **Result**: Shows current status and any notes from admin

#### 6. **View Activity Logs**
- **Who**: Admins only
- **What**: See what actions were taken in the system
- **How**: Access the audit log page
- **Result**: Shows who did what and when

## Technical Requirements

### Backend API Endpoints

#### Public Endpoints
- `GET /medications` - Retrieve all available medications
  - **Response**: List of medications with ID, name, and dosage
  - **Authentication**: None required
  - **Rate Limiting**: 100 requests per minute

#### Protected Endpoints
- `POST /requests` - Submit a new medication request
  - **Headers**: `x-user-role: nurse`
  - **Body**: `{ "patientId": "string", "medicationId": "number" }`
  - **Response**: Request confirmation with request ID
  - **Validation**: Patient ID format, medication existence, user role

- `GET /requests` - Retrieve medication requests
  - **Headers**: `x-user-role: admin`
  - **Response**: List of all requests with status
  - **Filtering**: Optional query parameters for status, date range

- `PUT /requests/{id}/approve` - Approve a medication request
  - **Headers**: `x-user-role: admin`
  - **Response**: Updated request status
  - **Validation**: Request exists, not already processed

- `PUT /requests/{id}/reject` - Reject a medication request
  - **Headers**: `x-user-role: admin`
  - **Response**: Updated request status
  - **Validation**: Request exists, not already processed

### Security Requirements

#### Authentication & Authorization
- **Role-based Access Control (RBAC)**:
  - **Nurse Role**: Can submit requests, view own requests
  - **Admin Role**: Can view all requests, approve/reject requests, view audit logs
- **Header-based Authentication**: Use `x-user-role` header for role identification
- **Input Validation**: All inputs must be validated and sanitized
- **SQL Injection Prevention**: Use parameterized queries
- **XSS Prevention**: Sanitize all user inputs

#### Data Protection
- **Patient Data**: Patient IDs must be handled securely
- **Audit Logging**: All actions must be logged with timestamp and user role
- **Data Encryption**: Sensitive data must be encrypted at rest
- **Access Logging**: All API access must be logged

### Database Design Requirements

You need to design and create three main database tables. Think about what information each table should store:

#### 1. Medications Table
This table stores information about available medications. You need to decide:
- How to identify each medication (primary key)
- What medication information to store (name, dosage, etc.)
- How to track when medications were added or updated
- What data types and constraints to use

#### 2. Medication Requests Table
This table tracks requests that nurses submit. You need to decide:
- How to identify each request (primary key)
- How to link requests to medications (foreign key)
- How to track the request status (pending, approved, rejected)
- How to record who submitted the request and when
- How to record who processed the request and when
- How to store any notes or comments from admins

#### 3. Audit Logs Table
This table keeps a record of all actions in the system for security and compliance. You need to decide:
- How to identify each log entry (primary key)
- How to record who performed the action (user role)
- How to record what action was performed
- How to record what was acted upon (which medication, request, etc.)
- How to store additional details about the action
- How to record when the action happened

#### Database Design Considerations
When designing your tables, think about:
- **Data types**: Choose appropriate types for each field (VARCHAR, INT, TIMESTAMP, etc.)
- **Constraints**: Add NOT NULL, UNIQUE, or other constraints where needed
- **Relationships**: Use foreign keys to link related data
- **Indexing**: Consider which fields might need indexes for better performance
- **Security**: Think about how to protect sensitive data like patient IDs

## Deliverables

### 1. **Backend API Implementation**
- **Spring Boot Application** with all required endpoints
- **Proper error handling** and HTTP status codes
- **Input validation** and sanitization
- **Database integration** with MySQL
- **Role-based security** implementation
- **Audit logging** for all actions

### 2. **Testing Suite**
- **Unit Tests**: Test all service layer methods
- **Integration Tests**: Test API endpoints with proper authentication
- **Security Tests**: Test role-based access control
- **Test Coverage**: Minimum 80% code coverage
- **Test Cases**:
  - Nurse submitting valid request
  - Nurse submitting invalid request (missing data)
  - Admin approving request
  - Admin rejecting request
  - Unauthorized access attempts
  - Invalid role headers

### 3. **Documentation**
- **API Documentation**: Complete OpenAPI/Swagger documentation
- **Setup Instructions**: Clear deployment and testing instructions
- **Architecture Documentation**: System design and security considerations
- **README**: Comprehensive project overview

### 4. **Code Quality**
- **Clean Architecture**: Proper separation of concerns
- **Code Standards**: Follow Java/Spring Boot best practices
- **Error Handling**: Comprehensive exception handling
- **Logging**: Appropriate logging levels and messages

## Technical Stack

### Backend
- **Framework**: Spring Boot 3.x
- **Language**: Java 17+
- **Database**: MySQL 8.0
- **Build Tool**: Maven
- **Testing**: JUnit 5, Mockito, Spring Boot Test

### Frontend (Provided)
- **Framework**: React 18
- **Language**: TypeScript
- **HTTP Client**: Axios
- **Build Tool**: npm

### Infrastructure
- **Containerization**: Docker & Docker Compose
- **Database**: MySQL container
- **Ports**: Backend (8080), Database (3306), Frontend (3000)



## Submission Requirements

### Repository Structure
```
medication-request-system/
├── backend/
│   ├── src/
│   ├── pom.xml
│   ├── Dockerfile
│   └── README.md
├── frontend/ (provided)
├── docker/
│   └── docker-compose.yml
├── docs/
│   ├── API.md
│   ├── SETUP.md
│   └── ARCHITECTURE.md
└── README.md
```

### Submission Checklist
- [ ] All API endpoints implemented and tested
- [ ] Security requirements met
- [ ] Database schema implemented
- [ ] Unit and integration tests passing
- [ ] Docker setup working
- [ ] Documentation complete
- [ ] Code follows best practices
- [ ] Repository is clean and well-organized



## Getting Started

### Step 1: Environment Setup

#### Prerequisites
- **Java 17 or higher** installed on your system
- **Maven 3.6+** for building the project
- **Docker and Docker Compose** for running the database and services
- **Git** for version control
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code with Java extensions)

#### Verify Your Setup
```bash
# Check Java version
java -version

# Check Maven version
mvn -version

# Check Docker version
docker --version
docker-compose --version

# Check Git version
git --version
```

### Step 2: Project Initialization

#### Clone and Explore
```bash
# Clone the repository (replace with your actual repo URL)
git clone <your-repository-url>
cd medication-request-system

# Explore the project structure
ls -la
tree -L 3  # If tree is installed
```

#### Understand the Existing Code
1. **Review the frontend** (`frontend/` directory):
   - `src/App.tsx` - Main application component
   - `src/components/` - React components for medication list and request form
   - `src/api.ts` - API client that shows the expected backend endpoints

2. **Review the backend structure** (`backend/` directory):
   - `src/main/java/com/medsecure/` - Main Java package
   - `src/main/resources/` - Configuration files
   - `pom.xml` - Maven dependencies and build configuration

3. **Review Docker setup** (`docker/` directory):
   - `docker-compose.yml` - Defines MySQL database and backend services

### Step 3: Database Setup

#### Start the Database
```bash
# Navigate to the docker directory
cd docker

# Start only the database service
docker-compose up db -d

# Verify the database is running
docker-compose ps

# Check database logs
docker-compose logs db
```

#### Database Connection Details
- **Host**: localhost
- **Port**: 3306
- **Database**: medrequest
- **Username**: user
- **Password**: password
- **Root Password**: root

#### Optional: Connect to Database
```bash
# Connect using MySQL client
mysql -h localhost -P 3306 -u user -p medrequest
# Enter password: password

# Or connect as root
mysql -h localhost -P 3306 -u root -p
# Enter password: root
```

### Step 4: Backend Development Setup

#### Initialize the Backend Project
```bash
# Navigate to backend directory
cd backend

# Clean and compile the project
mvn clean compile

# Run tests to see current state
mvn test
```

#### Database Schema Setup
You'll need to create the database tables based on the schema requirements specified in the Technical Requirements section above. The database should include tables for medications, medication requests, and audit logs.

Consider what fields would be needed for:
- Storing medication information (name, dosage, etc.)
- Tracking request status and workflow
- Maintaining audit trails for compliance
- Supporting the role-based access control system

### Step 5: Implement Core Backend Components

#### 1. Complete the Model Classes
Enhance the existing model classes to support the full functionality required by the system. Consider what additional fields and annotations would be needed for:

- Input validation and data integrity
- Request status tracking
- Audit trail information
- Proper JPA entity mapping

#### 2. Create Repository Interfaces
Create repository interfaces that extend JpaRepository for data access. Consider what custom query methods might be useful for:

- Finding requests by status
- Filtering requests by user role
- Supporting the audit trail functionality

#### 3. Implement Service Layer
Create service classes that implement the business logic for the medication request system. The services should handle:

- Business rule validation
- Role-based authorization
- Data persistence operations
- Error handling and exception management

#### 4. Implement Controller Layer
Create REST controllers that expose the API endpoints specified in the requirements. The controllers should:

- Handle HTTP requests and responses
- Extract and validate request headers for authentication
- Map to appropriate service methods
- Return proper HTTP status codes

### Step 6: Testing Your Implementation

#### 1. Start the Backend
```bash
# In the backend directory
mvn spring-boot:run
```

#### 2. Test API Endpoints
Test your API endpoints to ensure they work correctly. You should test:

- The medications endpoint for retrieving medication data
- Request submission with proper authentication headers
- Authorization failures when using incorrect roles
- Input validation and error handling

#### 3. Start the Frontend
```bash
# In a new terminal, navigate to frontend directory
cd frontend

# Install dependencies
npm install

# Start the development server
npm start
```

#### 4. Test the Full Application
1. Open `http://localhost:3000` in your browser
2. Verify the medication list loads correctly
3. Test submitting a request using the form
4. Check the browser's developer tools for any errors

### Step 7: Implement Security and Validation

#### 1. Add Input Validation
Implement comprehensive input validation for all user inputs. Consider:

- Required field validation
- Data format validation (e.g., patient ID format)
- Business rule validation
- Custom validation annotations where needed

#### 2. Implement Security Interceptor
Create security mechanisms to enforce role-based access control. Consider:

- Intercepting requests to validate authentication headers
- Checking user roles for protected endpoints
- Returning appropriate HTTP status codes for unauthorized access
- Logging security events for audit purposes

### Step 8: Write Tests

#### 1. Unit Tests
Write comprehensive unit tests for your service layer. Focus on testing:

- Business logic validation
- Role-based authorization
- Error handling scenarios
- Edge cases and boundary conditions

#### 2. Integration Tests
Write integration tests that test the full request-response cycle. Include tests for:

- API endpoint functionality
- Authentication and authorization
- Database interactions
- Error responses and status codes

### Step 9: Documentation

#### 1. API Documentation
Add API documentation to your project. Consider using:

- Swagger/OpenAPI for interactive API documentation
- Clear endpoint descriptions and examples
- Request/response schemas
- Authentication requirements

#### 2. Create Documentation Files
```bash
# Create docs directory
mkdir docs

# Create documentation files
touch docs/API.md
touch docs/SETUP.md
touch docs/ARCHITECTURE.md
```

### Step 10: Final Testing and Deployment

#### 1. Run All Tests
```bash
# Run unit tests
mvn test

# Run integration tests
mvn verify

# Check test coverage
mvn jacoco:report
```

#### 2. Test with Docker
```bash
# Build and run the full stack
cd docker
docker-compose up --build

# Test all services are running
docker-compose ps
```

#### 3. Performance Testing
Consider testing your application's performance:

- Response times under normal load
- Behavior with concurrent requests
- Database query performance
- Memory usage patterns

### Common Issues and Solutions

#### Issue 1: Database Connection Failed
```bash
# Check if MySQL is running
docker-compose ps

# Check MySQL logs
docker-compose logs db

# Restart MySQL
docker-compose restart db
```

#### Issue 2: Backend Won't Start
```bash
# Check if port 8080 is available
lsof -i :8080

# Kill process using port 8080
kill -9 <PID>

# Check backend logs
mvn spring-boot:run
```

#### Issue 3: Frontend Can't Connect to Backend
```bash
# Check CORS configuration in backend
# Add @CrossOrigin annotation to controllers

# Check if backend is running
curl http://localhost:8080/medications
```

#### Issue 4: Tests Failing
```bash
# Run tests with debug output
mvn test -X

# Check test database configuration
# Ensure test data is properly set up
```

### Next Steps

1. **Implement remaining endpoints** following the API specification
2. **Add comprehensive error handling** and logging
3. **Implement audit logging** for all actions
4. **Write security tests** for role-based access
5. **Complete documentation** with examples
6. **Perform final testing** with the frontend
7. **Prepare submission** following the checklist

### Development Tips

- **Use Git effectively**: Commit frequently with meaningful messages
- **Test early and often**: Don't wait until the end to test
- **Ask for help**: Use the provided resources and documentation
- **Focus on security**: Healthcare applications require strict security measures

## Support & Resources

- Spring Boot Documentation: https://spring.io/projects/spring-boot
- Spring Security Documentation: https://spring.io/projects/spring-security
- MySQL Documentation: https://dev.mysql.com/doc/
- Docker Documentation: https://docs.docker.com/

## Notes

- **Focus on security**: Healthcare applications require strict security measures
- **Test thoroughly**: Ensure all edge cases are covered
- **Document everything**: Clear documentation is crucial for healthcare systems
- **Follow best practices**: Use established patterns and conventions
- **Consider scalability**: Design for future growth and requirements

Good luck with your implementation! 