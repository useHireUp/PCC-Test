# Medication Request System – Backend Engineering Challenge

## Overview

You are provided with a working frontend that allows nurses to:
- View a list of medications
- Submit requests for medications
- Admins can approve or reject those requests

Your task is to **build the backend API** and **secure it properly**.

---

##  Requirements

- Implement the following endpoints:
  - `GET /medications` – Public
  - `POST /requests` – Nurses can submit a request
  - `GET /requests` – Admins can view all requests
  - `PUT /requests/:id/approve` or `/reject` – Admin actions

- Add security:
  - Only nurses can submit requests
  - Only admins can approve/reject
  - Use headers like `x-user-role: nurse` or `admin` to simulate auth

- Validate all input (prevent bad/malformed requests)

- Write tests for:
  - Core functionality
  - One case of security (e.g., nurse trying to approve a request)

---

## Setup Instructions

### Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/medication-request-api.git
cd medication-request-api
```

### 🐳 Run Using Docker

```bash
docker-compose up --build
```

This will:
- Spin up MySQL
- Build the Spring Boot backend
- Frontend runs separately via Node

### Run Frontend Locally

```bash
cd frontend
npm install
npm start
```

Frontend runs on `http://localhost:3000`

###  Run Backend Tests

```bash
cd backend
./mvnw test
```

---

##  Notes

- Use Spring Boot for the backend
- Use MySQL (via Docker)
- No external services or auth needed — keep it simple
- Focus on REST design, validation, and clean architecture

---

Good luck, and happy building!
