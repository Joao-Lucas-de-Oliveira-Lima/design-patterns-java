# Singleton Pattern

## 📚 References

- [Refactoring Guru - Singleton Pattern](https://refactoring.guru/design-patterns/singleton)
- Design Patterns: Elements of Reusable Object-Oriented Software

---

## 📖 Description

The **Singleton Pattern** is a creational design pattern that ensures a class has only one instance and provides a global point of access to that instance. This is useful when exactly one object is needed to coordinate actions across the system.

- **Category:** Creational Pattern  
- **Intent:** Ensure a class has only one instance and provide a global point of access to it.

---

## 🔧 Problem

When a class should have exactly one instance, and clients can access this instance from anywhere in the program.

---

## 💡 Solution

The **Singleton Pattern** restricts the instantiation of a class to one "single" instance. This is achieved by:
- Making the constructor private.
- Creating a static method that returns the instance.

- **Advantages:**
  - Controlled access to the single instance.
  - Reduced namespace pollution.
  - Permits refinement of operations and representation.
  - Permits a variable number of instances.
  - More flexible than class operations.

---

## 🛠 Structure

1. **Singleton Class:** Declares a static method to provide a single instance and a private constructor to prevent direct instantiation.

---

## 📋 Implementation

### `DatabaseConnection.java`
Represents a fictitious connection to a PostgreSQL database.
```java
package db;

public class DatabaseConnection {
    private static final DatabaseConnection instance = new DatabaseConnection();
    private final String connection;

    private DatabaseConnection() {
        // Example connection
        connection = "jdbc:postgresql://localhost:8080/db";
    }

    public String getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() {
        return instance;
    }
}
```
In the `App` class, you can access the single instance of `DatabaseConnection`:
```java
import db.DatabaseConnection;

public class App {
    public static void main(String[] args) throws Exception {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        String connection = databaseConnection.getConnection();

        System.out.println(connection);
    }
}
```
