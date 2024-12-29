package db;

public class DatabaseConnection {
    private static final DatabaseConnection instance = new DatabaseConnection();
    private final String connection;

    private DatabaseConnection() {
        //Example connection
        connection = "jdbc:postgresql://localhost:8080/db";
    }

    public String getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance(){
        return instance;
    }
}
