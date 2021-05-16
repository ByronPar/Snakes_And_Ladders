package org.byron.beans.Tablero;

import org.byron.conexion.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableroImpl implements RepoTablero<Tablero> {

    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }

    @Override
    public void guardar(Tablero tablero) {
        String sql = "INSERT INTO tablero() VALUES()";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Tablero ultimo() {
        Tablero tablero = null;
        try (PreparedStatement stmt = getConnection().
                prepareStatement("SELECT * FROM tablero WHERE id= (SELECT MAX(id) FROM tablero)")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tablero = crearTablero(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tablero;
    }

    private Tablero crearTablero(ResultSet rs) throws SQLException {
        Tablero t = new Tablero();
        t.setId(rs.getInt("id"));
        return t;
    }


}
