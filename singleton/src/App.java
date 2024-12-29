import db.DatabaseConnection;

public class App {
    public static void main(String[] args) throws Exception {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        String connection = databaseConnection.getConnection();

        System.out.println(connection);
    }
}
