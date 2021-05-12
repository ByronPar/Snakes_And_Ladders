package org.byron.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static Connection connection;
    
    public static Connection getInstance() throws SQLException {
        if(connection == null){
            String password = "byron%bot1";
            String username = "root";
            String url = "jdbc:mysql://localhost:3306/snakes_leadders?serverTimezone=UTC";
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
