package pawsshopsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/pawsshopdb";
    private static final String USER = "root";  // Change if necessary
    private static final String PASSWORD = "";  // Change if necessary

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}//"root123"
