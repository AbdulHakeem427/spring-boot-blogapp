# Blog Application API

This is a RESTful API for a simple blog application built with Spring Boot. It allows users to create accounts, write articles, and comment on them.

## Features

*   **User Management:**
    *   User registration
    *   User login with JWT-based authentication
    *   View user profiles
*   **Articles:**
    *   Create, read, update, and delete articles
    *   View all articles
    *   View articles by a specific author
*   **Comments:**
    *   Add comments to articles
    *   View all comments for an article
*   **API Documentation:**
    *   Interactive API documentation using Swagger UI.

## Technologies Used

*   **Framework:** Spring Boot 2.6.7
*   **Language:** Java 17
*   **Database:**
    *   H2 (for development)
    *   PostgreSQL (for production)
*   **Security:** Spring Security with JWT
*   **API Documentation:** SpringDoc OpenAPI UI (Swagger)
*   **Object Mapping:** ModelMapper
*   **Build Tool:** Gradle

## Getting Started

### Prerequisites

*   Java 17 or later
*   Gradle 7.x

### Installation

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/blogapp-springboot-java.git
    ```
2.  **Navigate to the project directory:**
    ```bash
    cd blogapp-springboot-java
    ```
3.  **Build the project:**
    ```bash
    ./gradlew build
    ```
4.  **Run the application:**
    ```bash
    ./gradlew bootRun
    ```

The application will be available at `http://localhost:8080`.

## API Documentation

Once the application is running, you can access the interactive API documentation (Swagger UI) at the following URL:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Database

The application uses an in-memory H2 database for development by default. The database console can be accessed at:

[http://localhost:8080/h2-console](http://localhost:8080/h2-console)

**JDBC URL:** `jdbc:h2:mem:blogdb`
**Username:** `sa`
**Password:** `password`

The application can be configured to use a PostgreSQL database for production. The database configuration can be found in the `src/main/resources/application.properties` file.
