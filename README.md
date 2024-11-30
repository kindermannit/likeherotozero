
# LikeHeroToZero

## Description

LikeHeroToZero is a Java-based web application that demonstrates a modular structure with key components such as managed beans, DAOs, entities, and utilities. The application uses JSF for the front-end and JPA for database interactions, providing a clean and structured approach to web application development.

## Features

- User and Role Management
- Country and Emission Tracking
- Authentication and Authorization
- Database Persistence with JPA
- Modular and Maintainable Code Structure


## Project Structure

The project follows a modular architecture. Below is an overview of the main components:

- **src/main/java/de.kindermann.likeherotozero**:
    - `beans`: Contains managed beans for JSF (Java Server Faces) functionality.
    - `dao`: Data Access Objects for managing database interactions.
    - `entities`: JPA (Java Persistence API) entity classes representing database tables.
    - `utils`: Utility classes such as authorization and session management.
- **src/main/resources**:
    - `META-INF/beans.xml`: Configures dependency injection (CDI).
    - `META-INF/persistence.xml`: Defines database connection and JPA settings.
- **src/main/webapp**:
    - JSF (XHTML) pages for user interface interactions.
    - Configuration files in `WEB-INF` for web application setup.
- **pom.xml**:
    - Project Object Model for dependency management using Maven.


## Prerequisites

To run this project, ensure you have the following installed:

- JDK 11 or higher
- Apache Maven
- A compatible application server (e.g., WildFly, Payara, or Tomcat with CDI extensions)


## Live Version

The application is deployed and available as a live version. You can access it at:

[Live Application](http://java.iu.kio-service.de)

## Getting Started

1. Clone the repository.
2. Build the project using Maven:

   ```bash
   mvn clean install
   ```

3. Deploy the WAR file to your application server.
4. Access the application in your web browser at `http://localhost:8080/` (or your server's configured port).

## Contributing

Feel free to fork this project and contribute by submitting pull requests. Make sure to follow the coding standards and provide detailed descriptions of your changes.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.

---

### Existing README Content (if any)
Like Hero To Zero - Sustainability Project
This project is a web application prototype developed for the "Like Hero To Zero" sustainability initiative. The goal is to create a platform that displays publicly accessible data on global CO2 emissions, while offering a secure backend for registered scientists to manage and update the data.

Key Features:
Public CO2 Emissions Data: The homepage displays the most recent CO2 emissions data for each country, accessible without requiring a login.
Scientist Dashboard: Registered scientists can log in to add new climate research data or correct existing data.

Technology Stack:
Frontend: JSF with CDI/Beans
Backend: JPA with Hibernate for data persistence
Database: MySQL



Open MYSQL Workbench and create database as follows;

1. create_database

CREATE DATABASE IF NOT EXISTS like_hero_to_zero;
USE like_hero_to_zero;


2. create_tables

USE like_hero_to_zero;

CREATE TABLE IF NOT EXISTS users (
id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(50) NOT NULL UNIQUE,
password VARCHAR(255) NOT NULL,
role VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS co2_data (
id INT AUTO_INCREMENT PRIMARY KEY,
country VARCHAR(50) NOT NULL,
year INT NOT NULL,
emissions DECIMAL(10, 2) NOT NULL,
submitted_by INT,
FOREIGN KEY (submitted_by) REFERENCES users(id)
);

