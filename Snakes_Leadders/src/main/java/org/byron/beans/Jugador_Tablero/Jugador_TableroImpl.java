package org.byron.beans.Jugador_Tablero;

import org.byron.conexion.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jugador_TableroImpl implements RepoJugador_Tablero<Jugador_Tablero> {
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }

    @Override
    public void guardar(Jugador_Tablero jugador_tablero) {
        String sql = "INSERT INTO jugador_tablero(id_jug,id_tab) VALUES(?,?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setInt(1, jugador_tablero.getJugador().getId());
            stmt.setInt(2, jugador_tablero.getTablero().getId());

            if (jugador_tablero.getId() > 0) {
                stmt.setInt(3, jugador_tablero.getId());
            }
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
