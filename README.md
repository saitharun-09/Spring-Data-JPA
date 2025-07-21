This is a **Java project** built with **Spring Boot** and **Spring Data JPA** to demonstrate how to:

- Create JPA entities.
- Map **One-to-One**, **One-to-Many**, **Many-to-One**, and **Many-to-Many** relationships.
- Use repositories for CRUD operations.
- Test repository methods and relationships.

## 📌 Features

✅ Spring Boot project 
✅ Entities
✅ Mappings:
-   One-to-One: `Course` ↔ `CourseMaterial`
-   One-to-Many: `Teacher` → `Course`
-   Many-to-Many: `Student` ↔ `Course`
✅ Repository interfaces using `JpaRepository`
✅ Pagination and Sorting for Queries
✅ Tests for saving, fetching and verifying relationships  
✅ MySql database for testing  

---

## 🛠️ Tech Stack

- Java 24
- Spring Boot
- Spring Data JPA
- MySql Database
- JUnit Tests

---

## 🚀 How to Run

1️⃣ Clone the repository:  
```bash
git clone https://github.com/<your-username>/spring-data-jpa-relationships.git
