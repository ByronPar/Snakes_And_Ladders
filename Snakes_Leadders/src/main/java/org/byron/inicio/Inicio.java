package org.byron.inicio;

import org.byron.conexion.ConexionDB;

import java.sql.*;

public class Inicio {
    public static void main(String[] args) {

        try (Connection conn = ConexionDB.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet resultado = stmt.executeQuery("SELECT * FROM jugador")) {
            while (resultado.next()) {
                System.out.println(resultado.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
