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
git clone [https://github.com/your-username/devcollab.git](https://github.com/your-username/devcollab.git)
cd devcollab

