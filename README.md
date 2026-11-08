# Web Services with Spring Boot, JPA and Hibernate

A RESTful API developed by me for **learning and practice**, using Java and Spring Boot.

The application works with entities related to users, categories, products and orders, using JPA/Hibernate for persistence and a layered architecture.

The goal of this project was to practice backend development concepts, CRUD operations, entity relationships, database access and exception handling.

## Technologies

- Java 25
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Maven
- H2 Database
- MySQL Driver

## Features

### Users
- List users
- Find a user by ID
- Create a user
- Update a user
- Delete a user

### Categories
- List categories
- Find a category by ID

### Products
- List products
- Find a product by ID

### Orders
- List orders
- Find an order by ID

The domain model also includes entities related to order items, payments and order status.

## Architecture

The project is organized into layers, separating the responsibilities of the application.

```text
src/
└── main/
    ├── java/
    │   └── com/esley/web_services_springboot/
    │       ├── config/
    │       ├── entities/
    │       ├── repositories/
    │       ├── resources/
    │       │   └── exceptions/
    │       ├── services/
    │       │   └── exceptions/
    │       └── WebServicesSpringbootApplication.java
    │
    └── resources/
        ├── application.properties
        └── application-test.properties
```

### Layers

- **Entities:** Domain entities and their relationships using JPA.
- **Repositories:** Data access and persistence operations using Spring Data JPA.
- **Services:** Application operations and business logic.
- **Resources:** REST endpoints responsible for handling HTTP requests.
- **Exceptions:** Exception handling and appropriate error responses.

## Database

The project is configured to use the H2 in-memory database with the test profile.

### H2 Database

- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: empty
- Console path: `/h2-console`

H2 is used to run the application locally and make it easier to test its features.

While the application is running, the console is available at:

```text
http://localhost:8080/h2-console
```

Use the following connection settings:

```text
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:
```

The database is temporary, and its data may be recreated when the application starts again.

### MySQL

The project also includes the MySQL driver dependency in the Maven configuration.

However, MySQL has not been used by the application yet. The current database configuration uses H2.

## Getting Started

### Prerequisites

- Java 25
- Git
- Maven

### Clone the repository

```bash
git clone https://github.com/Esley-Bertoldo/web-services.git
```

Navigate to the project directory:

```bash
cd web-services
```

### Run the application

On Windows:

```bash
mvnw.cmd spring-boot:run
```

On Linux or macOS:

```bash
./mvnw spring-boot:run
```

You can also run the main application class from your IDE.

Once the application starts, the API will be available locally at:

```text
http://localhost:8080
```

## Endpoints

### Users

| Method | Endpoint | Description |
|---|---|---|
| GET | `/users` | List all users |
| GET | `/users/{id}` | Find a user by ID |
| POST | `/users` | Create a user |
| PUT | `/users/{id}` | Update a user |
| DELETE | `/users/{id}` | Delete a user |

### Categories

| Method | Endpoint | Description |
|---|---|---|
| GET | `/categories` | List all categories |
| GET | `/categories/{id}` | Find a category by ID |

### Products

| Method | Endpoint | Description |
|---|---|---|
| GET | `/products` | List all products |
| GET | `/products/{id}` | Find a product by ID |

### Orders

| Method | Endpoint | Description |
|---|---|---|
| GET | `/orders` | List all orders |
| GET | `/orders/{id}` | Find an order by ID |

## Example Request

### Create a user

**POST** `/users`

```json
{
  "name": "Bob Brown",
  "email": "bob@gmail.com",
  "phone": "977557755",
  "password": "123456"
}
```

Example request for testing the user creation operation.

For POST and PUT requests, send the body as JSON with the following header:

```text
Content-Type: application/json
```

## Exception Handling

The application handles exceptions for situations such as:

- Resource not found;
- Attempting to delete a resource that does not exist;
- Database integrity violations;
- Issues related to entity updates.

The implementation uses specific exception classes and an exception handler to return appropriate HTTP responses.

## Deployment

The application has not been deployed yet.

Currently, the project can be run locally, and its source code is available on GitHub.

## Repository

[GitHub - web-services](https://github.com/Esley-Bertoldo/web-services)

---

**Developed by Esley Bertoldo for learning and practice.**
