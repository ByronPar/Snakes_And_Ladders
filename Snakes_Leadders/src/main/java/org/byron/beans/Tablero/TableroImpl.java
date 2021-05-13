package org.byron.beans.Tablero;

import org.byron.beans.Jugador.Jugador;
import org.byron.conexion.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableroImpl implements RepoTablero<Tablero> {

    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }


    @Override
    public Tablero getTablero(int id) {
        Tablero t = null;
        try (PreparedStatement stmt = getConnection().
                prepareStatement("SELECT * FROM tablero WHERE id_tablero = ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    t = crearTablero(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public void guardar(Tablero tablero) {
        String sql = "INSERT INTO tablero() VALUES()";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setInt(1, tablero.getId_tablero());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM tablero WHERE id_tablero=?")){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Tablero crearTablero(ResultSet rs) throws SQLException {
        Tablero t = new Tablero();
        t.setId_tablero(rs.getInt("id_tablero"));
        return t;
    }
}
