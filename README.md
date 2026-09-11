# 🚀 DevCollab

**DevCollab** is a modern, full-stack platform designed for developers to showcase their side projects, discover what others are building, and connect with potential collaborators based on shared technology stacks.

---

## 🛠️ Tech Stack

* **Backend:** Spring Boot 3.2.5, Spring Security, Spring Data JPA / Hibernate, Lombok
* **Database:** PostgreSQL (Hosted on Supabase)
* **Authentication:** Stateless JWT (JSON Web Tokens)
* **Build Tool:** Maven
* **Frontend:** HTML5, Tailwind CSS, JavaScript (Axios)

---

## ✨ Core Features

* **Secure Authentication:** User registration and login powered by Spring Security and JWT-based stateless tokens.
* **Dynamic Project Feed:** Browse all developer project posts sorted chronologically by recency.
* **Tech Stack Filtering:** Filter projects instantly by specific tags (e.g., Java, Spring Boot, React, DevOps).
* **Project Creation:** Authenticated users can publish new projects complete with title, description, tech stack, GitHub repository link, and live URL.
* **Robust Database Integration:** Optimized Hibernate mapping with proper lazy loading proxy handling and cascade controls.

---

## ⚙️ Getting Started & Local Setup

Follow these instructions to run the **DevCollab** backend locally on your machine.

### Prerequisites
* **Java Development Kit (JDK 17+):** Ensure Java 17 is installed and added to your system path.
* **Maven:** For dependency management and building the project.
* **PostgreSQL / Supabase:** A running PostgreSQL instance.

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/devcollab.git
cd devcollab
```

### 2. Configure Database & Properties
Update your `src/main/resources/application.properties` with your PostgreSQL database credentials and JWT secret key:

```properties
spring.datasource.url=jdbc:postgresql://your-supabase-host:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=your_db_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# JWT Configuration
jwt.secret=your_secure_jwt_secret_key_here_min_256_bits
jwt.expiration=86400000
```

### 3. Build and Run via Maven
Run the clean install command to compile the project and resolve all dependencies:

```bash
mvn clean install
```

Then, start the application:

```bash
mvn spring-boot:run
```

The server will launch at `http://localhost:8080`.

---

## 📌 API Endpoints Overview

| Method | Endpoint | Description | Access Level |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/auth/register` | Register a new user account | Public |
| `POST` | `/api/auth/login` | Authenticate user and return JWT | Public |
| `GET` | `/api/projects` | Fetch all projects (optional `?tag=`) | Public |
| `GET` | `/api/projects/{id}` | Get project details by ID | Public |
| `POST` | `/api/projects` | Create a new project post | Authenticated (Bearer Token) |

---

## 💡 Future Enhancements
* Interactive comment sections on project posts.
* Dedicated developer profile pages showcasing individual portfolios.
* Advanced keyword search and pagination support.

---

## 🛡️ License
Distributed under the MIT License. See `LICENSE` for more information.
