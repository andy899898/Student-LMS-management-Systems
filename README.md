# Student LMS Management System

A Java-based **Student LMS Management System** that uses **MySQL** to manage student records through CRUD operations. The application follows the **DAO (Data Access Object) design pattern** to separate database operations from application logic.

## 📌 Features

* ➕ Add new student records
* ✏️ Update student's course using University Number
* 🗑️ Delete students using Roll Number
* 🔍 Search students by Roll Number
* 📋 Display all student records
* 🗄️ MySQL database integration using JDBC
* 💻 Menu-driven console interface

## 🛠️ Technologies Used

* **Java**
* **MySQL**
* **JDBC**
* **DAO Design Pattern**
* **Eclipse / VS Code**

## 🗃️ Database Operations

The project uses `PreparedStatement` for executing SQL queries and performs the following operations:

* `INSERT` – Add a new student
* `UPDATE` – Update student's course
* `DELETE` – Delete a student
* `SELECT` – Search and display student records

## 🏗️ Project Structure

```text
src
└── com.studentportal.clg
    ├── models
    │   └── Student.java
    │
    ├── repositories
    │   ├── Studentdao.java
    │   └── StudentdaoImp.java
    │
    └── test
        └── StudentManagement.java
```

## 🔄 Application Flow

```text
StudentManagement
       ↓
   Studentdao
       ↓
 StudentdaoImp
       ↓
     JDBC
       ↓
     MySQL
```

The `StudentManagement` class handles user interaction, while `StudentdaoImp` performs database operations using JDBC.

## ⚙️ CRUD Operations

### 1. Add Student

Users can enter:

* Student Name
* Course
* Roll Number

The information is inserted into the MySQL `student` table.

### 2. Update Course

Users provide:

* University Number
* New Course

The student's course is updated using the University Number.

### 3. Delete Student

Users provide the student's Roll Number, and the corresponding student record is deleted from the database.

### 4. Search Student

Users can search for a student by entering their Roll Number.

### 5. Display All Students

The application retrieves and displays all student records stored in the database.

## 🗄️ Database Setup

Create the database in MySQL:

```sql
CREATE DATABASE studentcrud;

USE studentcrud;
```

Create the `student` table:

```sql
CREATE TABLE student (
    university_no INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    courses VARCHAR(100),
    rollno INT UNIQUE
);
```

## 🔌 JDBC Configuration

Update the database credentials in `StudentdaoImp.java` according to your MySQL configuration:

```java
String user = "root";
String password = "root";
String url = "jdbc:mysql://localhost:3306/studentcrud";
```

Make sure the **MySQL Connector/J JDBC driver** is added to the project.

## ▶️ How to Run

1. Clone the repository.
2. Open the project in **Eclipse or VS Code**.
3. Create the `studentcrud` database in MySQL.
4. Create the `student` table using the SQL query above.
5. Add the MySQL Connector/J dependency.
6. Update your MySQL username and password.
7. Run `StudentManagement.java`.
8. Select an option from the menu.

## 📚 Concepts Demonstrated

This project demonstrates practical implementation of:

* Java OOP
* Classes and Objects
* Constructors
* Interfaces
* DAO Design Pattern
* JDBC
* MySQL
* CRUD Operations
* PreparedStatement
* ResultSet
* Exception Handling
* ArrayList
* Loops and Switch Case
* Database Connectivity

## 🚀 Future Improvements

The project can be further enhanced by adding:

* Student login and authentication
* Attendance management
* Fee management
* Exam and marks management
* Assignment management
* Student profile management
* GUI using Java Swing or JavaFX
* Web application using Spring Boot
* REST APIs

## 👨‍💻 Author

**Anshu Kumar**

B.Tech – Computer Engineering

---

⭐ If you find this project useful, consider giving the repository a star!

