# Singleton Pattern

## Description
- Type of Pattern: Creational

The Singleton pattern ensures that a class has only one instance and provides a global point of access to that instance. This is useful when exactly one object is needed to coordinate actions across the system. The Singleton pattern is often used for logging, database connections, and configuration settings.


## Implementation
The `DatabaseConnection` class represents a fictitious connection to a PostgreSQL database. The private constructor, along with the `getInstance` method and the instance attribute being part of the class itself, ensures that the class can only be instantiated once per JVM execution. By using the `private static final` instance, the class is initialized at class loading time, ensuring thread safety without requiring explicit synchronization.

### DatabaseConnection.java
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
