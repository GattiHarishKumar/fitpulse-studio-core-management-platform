# Zumba Class Management System

A Java EE MVC web application for managing Zumba batches and participants with full CRUD operations.

## Tech Stack
- Java 11
- Java Servlets 4.0
- JSP + JSTL
- JDBC
- MySQL 8.x
- Maven
- Apache Tomcat 9.x
- HTML5 + CSS3

## Project Structure
```text
zumba-management-system/
├── pom.xml
├── schema.sql
├── README.md
└── src/main/
    ├── java/com/zumba/
    │   ├── model/
    │   ├── dao/
    │   ├── util/
    │   └── controller/
    └── webapp/
        ├── WEB-INF/web.xml
        ├── css/style.css
        ├── index.html
        └── *.jsp
```

## Requirements
1. JDK 11+
2. Maven 3.8+
3. MySQL 8.x
4. Apache Tomcat 9.x

## 1. Database
Run:
```bash
mysql -u root -p < schema.sql
```

## 2. Configure Database Credentials
The application reads:
- `ZUMBA_DB_USER`
- `ZUMBA_DB_PASSWORD`

Example on macOS/Linux:
```bash
export ZUMBA_DB_USER=root
export ZUMBA_DB_PASSWORD='your_mysql_password'
```

If your MySQL root account has no password, leave the password empty.

## 3. Build
From the project root:
```bash
mvn clean package
```

The WAR is generated at:
```text
target/zumba-management-system.war
```

## 4. Deploy to Tomcat
Copy the WAR into Tomcat's `webapps` directory:
```bash
cp target/zumba-management-system.war /path/to/tomcat/webapps/
```

Start Tomcat and open:
```text
http://localhost:8080/zumba-management-system/
```

## CRUD Features
### Batch Management
- Create batch
- List batches
- Edit batch
- Delete batch

### Participant Management
- Enroll participant
- List participants
- Edit participant
- Reassign participant to a batch
- Delete participant

## GitHub
```bash
git init
git add .
git commit -m "feat: complete zumba management system"
git branch -M main
git remote add origin https://github.com/<your-username>/<repo-name>.git
git push -u origin main
```

## Notes
- Do not commit database passwords.
- `target/` should not be committed.
- The application uses a WAR because it is a Tomcat web application.
# fitpulse-studio-core-management-platform
