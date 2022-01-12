package org.aguzman.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//ctrl + B => nos vamos a la implementacion del metodo
// alt + ctrl + t -> da opciones para el i, while, runnable etc
//ctrl + tab ->  mover entre clases
//alt +enter => implementa los metodos de una implementacion
//alt + insert -> getter and setter
//alt + 1 => ecxplorer
//shift + f10 => compilar y correr
public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Santiago";
    private static String username = "root";
    private static String password = "123456";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
