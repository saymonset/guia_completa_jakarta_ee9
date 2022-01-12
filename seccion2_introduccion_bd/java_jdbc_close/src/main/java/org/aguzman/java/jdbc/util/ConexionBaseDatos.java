package org.aguzman.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Santiago";
    private static String username = "root";
    private static String password = "123456";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
