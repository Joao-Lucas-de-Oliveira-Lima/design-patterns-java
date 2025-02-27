# Singleton  

## About the Pattern

The **Singleton** design pattern ensures that a class has only one instance and provides a global access point to that instance. 

## Implementation  

### Creating a Singleton  

In the `DatabaseConnection` class, the default constructor is private, preventing instances from being created outside the class. The class contains a static attribute of its own type, called `instance`, which stores the only allowed instance. Since `instance` and `getInstance()` are static, they belong to the class and can only be accessed through it.  

```java
public class DatabaseConnection {
    private static final DatabaseConnection instance = new DatabaseConnection();
    private final String connection;

    private DatabaseConnection() {
        // Example connection string
        connection = "jdbc:postgresql://localhost:8080/db";
    }

    public static DatabaseConnection getInstance() {
        return instance;
    }

    // Other methods, such as getters and setters, can be added here
}
```

### Accessing the Singleton Instance  

```java
DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
```