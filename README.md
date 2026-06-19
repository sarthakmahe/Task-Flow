# TaskFlow - Task Management Application

## Overview

TaskFlow is a Spring Boot-based task management application that helps users create, update, track, and manage daily tasks efficiently. The application provides a clean user interface along with REST APIs for task operations.

## Features

* Create, update, and delete tasks
* Mark tasks as completed or pending
* Pagination for task listing
* Input validation using Bean Validation
* Global exception handling
* RESTful APIs
* Swagger/OpenAPI documentation
* Dark mode support
* Responsive user interface
* MySQL database integration

## Tech Stack

### Backend

* Java 17
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate
* MySQL

### Frontend

* Thymeleaf
* HTML
* CSS
* Bootstrap
* JavaScript

### Tools

* Maven
* Swagger/OpenAPI
* Git & GitHub

## Project Structure

src/main/java

* controller
* service
* repository
* entity
* exception

src/main/resources

* templates
* static
* application.properties

## Getting Started

### Prerequisites

* Java 17+
* Maven
* MySQL

### Clone the Repository

```bash
git clone https://github.com/sarthakmahe/Task-Flow.git
cd Task-Flow
```

### Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskflow
spring.datasource.username=root
spring.datasource.password=your_password
```

### Run the Application

```bash
mvn spring-boot:run
```

Application URL:

```text
http://localhost:8080
```

Swagger UI:

```text
http://localhost:8080/swagger-ui.html
```

## API Endpoints

| Method | Endpoint        | Description    |
| ------ | --------------- | -------------- |
| GET    | /api/tasks      | Get all tasks  |
| GET    | /api/tasks/{id} | Get task by ID |
| POST   | /api/tasks      | Create task    |
| PUT    | /api/tasks/{id} | Update task    |
| DELETE | /api/tasks/{id} | Delete task    |

## Future Enhancements

* Task priority management
* Sorting and filtering
* Spring Security authentication
* Docker support
* Unit and integration testing

## Author

Sarthak Maheshwari

GitHub: https://github.com/sarthakmahe
