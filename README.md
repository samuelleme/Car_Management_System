# Car Management System – Java REST API

This repository contains a **simple RESTful API** written in Java 17 that stores a catalog of cars entirely **in-memory**.  
The project is educational and showcases the micro-framework **Spark Java**, DTO mapping with **ModelMapper**, JSON (de)serialization via **Jackson**, and integration tests using `HttpURLConnection`.

---

## Overview

| Layer | Responsibility | Key classes |
|-------|----------------|-------------|
| **Model** | Domain entity | `Carro` |
| **DTO** | API input/output data | `CarroDTOInput`, `CarroDTOOutput` |
| **Service** | Business rules + in-memory repository | `CarroService` |
| **Controller** | HTTP routes (Spark) + JSON serialization | `CarroController` |
| **Tests** | JUnit 4 service & HTTP integration tests | `ServiceTest` |
| **Main** | Application bootstrap (`port 4567`) | `Main` |

The API exposes **CRUD** (Create, Read, Update, Delete) operations for cars:

| Method | Route | Description |
|--------|-------|-------------|
| `GET` | `/carros` | List all cars |
| `GET` | `/carros/:id` | Fetch a car by ID |
| `POST` | `/carros` | Register a new car |
| `PUT` | `/carros` | Update an existing car |
| `DELETE` | `/carros/:id` | Delete a car |

---

## Running locally

1. **Prerequisites**  
   * Java 17+  
   * Maven 3.9+ *or* Gradle 8+  
     (the snippets below assume Maven)

2. **Clone & build**

   ```bash
   git clone https://github.com/samuelleme/Car_Management_System.git
   cd your-repo
   mvn clean package
   ```

---

## Start the API

  ```bash
  mvn exec:java -Dexec.mainClass="Main"
  ```

The server will run at http://localhost:4567.

---

## Sample requests

  ```bash
  # Create a car
  curl -X POST http://localhost:4567/carros \
       -H "Content-Type: application/json" \
       -d '{"id":1,"modelo":"Corolla","placa":"XYZ-1234","chassi":"9BWZZZ377VT004251"}'
  
  # List cars
  curl http://localhost:4567/carros
  ```

---

## Tests

ServiceTest (JUnit 4) covers:
- Direct insertion into CarroService
- Listing verification (GET /carros)
- POST integration using data fetched from a public API (freetestapi.com)
- Random 17-character VIN generation to avoid collisions

Run all tests with:
```bash
mvn test
```

---

## Directory structure
```text
src
 └─ main
    ├─ java
    │   ├─ controller/
    │   ├─ dto/
    │   ├─ model/
    │   ├─ service/
    │   └─ Main.java
    └─ test
        └─ ServiceTest.java
```
