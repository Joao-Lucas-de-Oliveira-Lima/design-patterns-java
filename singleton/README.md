# Singleton Design Pattern

## About the Pattern
The **Singleton** design pattern ensures that a class has only one instance and provides a global point of access to that instance. This is particularly useful when exactly one object is needed to coordinate actions across a system, such as managing database connections or application settings.

- **Type:** Creational

---

## Project Structure
```
singleton/
├── src/
│   ├── App.java                    # Main application logic
│   └── db/DatabaseConnection.java  # Singleton implementation for database connection
└── README.md                       # Project documentation
```

---

## Solution
This project demonstrates the Singleton pattern in the context of a database connection.

### Singleton Class
The `DatabaseConnection` class implements the Singleton pattern to ensure that only one instance of the database connection exists throughout the application lifecycle.

- **Private Constructor:** Prevents direct instantiation of the class by other classes.
- **Static Instance:** A private, static instance of the class is eagerly initialized and ensures thread safety.
- **Public Accessor Method:** The `getInstance()` method provides global access to the single instance of the class.


**Code Example:**
```java
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

### Main Application
The `App` class demonstrates how to use the Singleton pattern. It retrieves the single instance of `DatabaseConnection` and displays the connection string.

**Code Example:**
```java
public class App {
    public static void main(String[] args) throws Exception {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        String connection = databaseConnection.getConnection();

        System.out.println(connection);
    }
}
```

## References
- [Refactoring Guru - Singleton Pattern](https://refactoring.guru/design-patterns/singleton)
- *Design Patterns: Elements of Reusable Object-Oriented Software*

