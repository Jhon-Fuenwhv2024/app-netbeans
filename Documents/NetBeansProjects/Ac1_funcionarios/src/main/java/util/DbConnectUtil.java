package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectUtil {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/db-caso-estudio";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1728";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
