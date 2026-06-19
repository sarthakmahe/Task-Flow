# TaskFlow - Task Management Application

## Overview

<<<<<<< HEAD
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
=======
TaskFlow is a Spring Boot task management application for creating, searching, sorting, tracking, and deleting daily tasks. It includes a responsive Thymeleaf web interface and REST APIs for task operations.

## Features

- Create and delete tasks
- Mark tasks as completed or pending
- Search tasks by title
- Sort tasks by newest, oldest, title, or status
- Paginated task listing
- Input validation using Bean Validation
- Global exception handling for web and REST flows
- RESTful APIs
- Swagger/OpenAPI documentation
- Dark mode with saved user preference
- Responsive Thymeleaf user interface
- MySQL database integration
>>>>>>> 9a04615 (Add readme file)

## Tech Stack

### Backend

<<<<<<< HEAD
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
=======
- Java 17
- Spring Boot 4
- Spring MVC
- Spring Data JPA
- Hibernate
- MySQL
- Bean Validation

### Frontend

- Thymeleaf
- HTML
- CSS
- JavaScript

### Tools

- Maven
- Swagger/OpenAPI
- Git and GitHub

## Project Structure

```text
src/main/java/in/sarthak
├── config
├── controller
├── dto
├── exception
├── models
├── repository
└── services

src/main/resources
├── application.properties
└── templates
    └── tasks.html
```
>>>>>>> 9a04615 (Add readme file)

## Getting Started

### Prerequisites

<<<<<<< HEAD
* Java 17+
* Maven
* MySQL
=======
- Java 17+
- Maven
- MySQL
>>>>>>> 9a04615 (Add readme file)

### Clone the Repository

```bash
git clone https://github.com/sarthakmahe/Task-Flow.git
cd Task-Flow
```

### Configure Database

<<<<<<< HEAD
Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskflow
=======
Create a MySQL database, then update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todoapp
>>>>>>> 9a04615 (Add readme file)
spring.datasource.username=root
spring.datasource.password=your_password
```

<<<<<<< HEAD
### Run the Application

=======
The project currently uses:

```properties
spring.jpa.hibernate.ddl-auto=update
```

### Run the Application

Using Maven:

>>>>>>> 9a04615 (Add readme file)
```bash
mvn spring-boot:run
```

<<<<<<< HEAD
Application URL:

```text
http://localhost:8080
=======
Or using the included Maven wrapper on Windows:

```bash
.\mvnw.cmd spring-boot:run
```

Application URL:

```text
http://localhost:8080/tasks
>>>>>>> 9a04615 (Add readme file)
```

Swagger UI:

```text
http://localhost:8080/swagger-ui.html
```

<<<<<<< HEAD
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
=======
OpenAPI docs:

```text
http://localhost:8080/api-docs
```

## API Endpoints

| Method | Endpoint               | Description                         |
| ------ | ---------------------- | ----------------------------------- |
| GET    | `/api/tasks`           | Get tasks with search and pagination |
| GET    | `/api/tasks/{id}`      | Get task by ID                      |
| POST   | `/api/tasks`           | Create a task                       |
| PATCH  | `/api/tasks/{id}/toggle` | Toggle task completed status      |
| DELETE | `/api/tasks/{id}`      | Delete a task                       |

### Create Task Request

```json
{
  "title": "Buy groceries"
}
```

## Web Routes

| Method | Endpoint             | Description                  |
| ------ | -------------------- | ---------------------------- |
| GET    | `/tasks`             | View, search, sort, and page tasks |
| POST   | `/tasks`             | Create a new task            |
| GET    | `/tasks/{id}/toggle` | Toggle task completed status |
| GET    | `/tasks/{id}/delete` | Delete a task                |

## Validation and Exception Handling

- Task titles are required and must be between 1 and 200 characters.
- Task IDs must be positive.
- Page numbers cannot be negative.
- REST validation errors return JSON error responses.
- Web validation errors redirect back to `/tasks` with a flash error message.

## Future Enhancements

- Edit/update task title
- Task priority management
- Due dates and reminders
- Status filters
- Spring Security authentication
- User-specific tasks
- Docker support
- Unit and integration testing
>>>>>>> 9a04615 (Add readme file)

## Author

Sarthak Maheshwari
<<<<<<< HEAD

GitHub: https://github.com/sarthakmahe
=======
>>>>>>> 9a04615 (Add readme file)
