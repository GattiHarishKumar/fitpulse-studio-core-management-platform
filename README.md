

# FitPulse Studio — Core Management Platform

A Java EE MVC-based fitness studio management platform for managing classes, batches, and participants with complete CRUD operations.

Built using Java Servlets, JSP, JSTL, JDBC, MySQL, Maven, and Apache Tomcat.

---

## 📌 Overview

**FitPulse Studio** is a server-side Java web application designed to streamline the management of fitness studio batches and participants.

The application provides a structured management workflow for creating fitness batches, enrolling participants, updating records, reassigning participants between batches, and maintaining data in a MySQL database.

The project follows a layered **MVC architecture** with dedicated Model, Controller, DAO, and Utility layers.

---

## ✨ Features

### 🏋️ Batch Management

- Create new fitness batches
- View all available batches
- Edit batch details
- Delete batches
- Manage batch schedules
- Manage batch capacity

### 👥 Participant Management

- Enroll new participants
- View registered participants
- Edit participant information
- Reassign participants to different batches
- Delete participants
- Maintain participant-to-batch relationships

### ⚙️ Application Features

- MVC architecture
- Complete CRUD operations
- JDBC-based database access
- JSP and JSTL server-side rendering
- Servlet-based request handling
- MySQL database persistence
- Maven build management
- WAR-based deployment
- Environment-based database configuration

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Programming Language | Java 11 |
| Architecture | Java EE MVC |
| Backend | Java Servlets 4.0 |
| View Layer | JSP + JSTL |
| Database Access | JDBC |
| Database | MySQL 8.x |
| Build Tool | Maven |
| Application Server | Apache Tomcat 9.x |
| Frontend | HTML5 + CSS3 |

---

## 🏗️ Application Architecture

```text
                         ┌──────────────────────┐
                         │       Browser        │
                         │     HTML / JSP       │
                         └──────────┬───────────┘
                                    │
                                    ▼
                         ┌──────────────────────┐
                         │   Controller Layer   │
                         │    Java Servlets     │
                         └──────────┬───────────┘
                                    │
                                    ▼
                         ┌──────────────────────┐
                         │      DAO Layer       │
                         │        JDBC          │
                         └──────────┬───────────┘
                                    │
                                    ▼
                         ┌──────────────────────┐
                         │      MySQL 8.x       │
                         │       Database       │
                         └──────────────────────┘

                         ┌──────────────────────┐
                         │      Model Layer     │
                         │    Java Entities     │
                         └──────────────────────┘
````

---

## 📂 Project Structure

```text
fitpulse-studio-core-management-platform/
│
├── pom.xml
├── schema.sql
├── README.md
├── .gitignore
│
└── src/
    └── main/
        │
        ├── java/
        │   └── com/
        │       └── zumba/
        │           │
        │           ├── model/
        │           │   └── ...
        │           │
        │           ├── dao/
        │           │   └── ...
        │           │
        │           ├── util/
        │           │   └── ...
        │           │
        │           └── controller/
        │               └── ...
        │
        └── webapp/
            │
            ├── WEB-INF/
            │   └── web.xml
            │
            ├── css/
            │   └── style.css
            │
            ├── index.html
            └── *.jsp
```

---

# 🚀 Getting Started

Follow the steps below to run the application locally.

---

## 📋 Prerequisites

Make sure the following software is installed:

* JDK 11 or later
* Maven 3.8+
* MySQL 8.x
* Apache Tomcat 9.x

### Verify Java

```bash
java -version
```

Expected:

```text
java version "11..."
```

### Verify Maven

```bash
mvn -version
```

---

# 1. Clone the Repository

Clone the project:

```bash
git clone https://github.com/<your-username>/fitpulse-studio-core-management-platform.git
```

Navigate into the project:

```bash
cd fitpulse-studio-core-management-platform
```

---

# 2. Configure MySQL

Make sure MySQL is installed and running.

Create the required database and tables using the provided SQL schema:

```bash
mysql -u root -p < schema.sql
```

Enter your MySQL password when prompted.

You can also run the SQL manually using MySQL Workbench.

---

# 3. Configure Database Credentials

The application reads the database credentials from environment variables.

### macOS / Linux

```bash
export ZUMBA_DB_USER=root
export ZUMBA_DB_PASSWORD='your_mysql_password'
```

If your MySQL root account does not have a password:

```bash
export ZUMBA_DB_USER=root
export ZUMBA_DB_PASSWORD=''
```

Verify the configured username:

```bash
echo $ZUMBA_DB_USER
```

> **Security:** Never hard-code database passwords in the source code or commit them to GitHub.

---

# 4. Build the Application

From the project root, run:

```bash
mvn clean package
```

If the build succeeds, Maven generates the WAR file:

```text
target/zumba-management-system.war
```

---

# 5. Deploy to Apache Tomcat

Copy the generated WAR file into the Tomcat `webapps` directory.

Example:

```bash
cp target/zumba-management-system.war /path/to/apache-tomcat-9/webapps/
```

Replace the path with the actual location of your Tomcat installation.

For example:

```bash
cp target/zumba-management-system.war ~/apache-tomcat-9.0.xx/webapps/
```

---

# 6. Start Apache Tomcat

### macOS / Linux

```bash
/path/to/apache-tomcat-9/bin/startup.sh
```

Example:

```bash
~/apache-tomcat-9.0.xx/bin/startup.sh
```

### Windows

```cmd
C:\path\to\apache-tomcat-9\bin\startup.bat
```

---

# 7. Open the Application

After Tomcat starts successfully, open:

```text
http://localhost:8080/zumba-management-system/
```

The FitPulse Studio application should now be available locally.

---

# 🔄 CRUD Operations

## Batch Management

| Operation | Description                       |
| --------- | --------------------------------- |
| Create    | Create a new fitness batch        |
| Read      | View all available batches        |
| Update    | Modify existing batch information |
| Delete    | Remove an existing batch          |

## Participant Management

| Operation | Description                         |
| --------- | ----------------------------------- |
| Create    | Enroll a new participant            |
| Read      | View registered participants        |
| Update    | Modify participant information      |
| Reassign  | Move a participant to another batch |
| Delete    | Remove a participant                |

---


# 💡 Engineering Concepts Demonstrated

This project demonstrates practical Java web-development concepts including:

* Object-Oriented Programming
* MVC Architecture
* Java Servlets
* JSP
* JSTL
* JDBC
* DAO Pattern
* CRUD Operations
* HTTP Request Handling
* Form Processing
* Relational Database Design
* MySQL
* Maven Dependency Management
* WAR Packaging
* Apache Tomcat Deployment
* Environment-Based Configuration
* Separation of Concerns

---

# 🔮 Future Enhancements

The platform can be extended with:

* User authentication
* Role-based access control
* Admin dashboard
* Trainer management
* Membership management
* Attendance tracking
* Payment management
* Subscription management
* Search and filtering
* Pagination
* REST API integration
* React-based frontend
* Unit testing
* Integration testing
* Docker support
* CI/CD pipeline
* Cloud deployment
* Application monitoring and logging

---

# 📈 Project Highlights

### Backend

* Java 11
* Java Servlets
* JDBC
* DAO architecture
* MySQL
* Maven

### Frontend

* JSP
* JSTL
* HTML5
* CSS3
* Server-side rendering

### Deployment

* WAR packaging
* Apache Tomcat
* Environment-based configuration

---
