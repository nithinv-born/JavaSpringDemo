📘 Spring Boot User Management API

This project is a Spring Boot backend demo application built as part of Java J2EE + Spring Boot Foundations learning.
It demonstrates REST APIs, Spring Data JPA, pagination, sorting, filtering, and H2 database integration.

🛠 Tech Stack

Java 17

Spring Boot

Spring Web (REST APIs)

Spring Data JPA

H2 In-Memory Database

Maven

VS Code

🚀 Features Implemented

Create user (POST API)

Retrieve users (GET API)

Pagination

Sorting

Filtering / Search

Transaction management

In-memory database using H2

Data verification via H2 Console

📂 Project Structure
src/main/java
 └── com.example.demo
     ├── controller
     │    └── UserController.java
     ├── service
     │    └── UserService.java
     ├── repository
     │    └── UserRepository.java
     ├── entity
     │    └── User.java
     ├── dto
     │    └── UserRequest.java
     └── DemoApplication.java

⚙️ Application Configuration
application.properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

🧪 API Testing URLs
Base URL
http://localhost:8080/api/users

➕ Create User (POST)
POST /api/users


Request Body

{
  "name": "Nithin",
  "email": "nithin@test.com"
}

📄 Get Users (Default)
GET /api/users

📑 Pagination
Page 0, Size 3
GET /api/users?page=0&size=3

Page 1, Size 3
GET /api/users?page=1&size=3

🔀 Sorting
Sort by Name (Ascending)
GET /api/users?sortBy=name&direction=asc

Sort by Name (Descending)
GET /api/users?sortBy=name&direction=desc

Sort by Email
GET /api/users?sortBy=email

🔍 Filtering / Search
Filter by Name
GET /api/users?name=nithin

Filter by Email
GET /api/users?email=test.com

🔗 Combined Queries
Filter + Pagination
GET /api/users?name=nithin&page=0&size=2

Filter + Sort
GET /api/users?name=nithin&sortBy=name&direction=asc

Filter + Sort + Pagination
GET /api/users?page=0&size=2&sortBy=name&direction=asc&name=nithin

🗄 H2 Database Console
Open H2 Console
http://localhost:8080/h2-console


JDBC URL

jdbc:h2:mem:testdb

Verify Data
SELECT * FROM USERS;