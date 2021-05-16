package org.byron.beans.Tipo;

import org.byron.conexion.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoImpl implements RepoTipo<Tipo> {

    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }

    @Override
    public Tipo forName(String type_name) {
        Tipo tipo = null;
        try (PreparedStatement stmt = getConnection().
                prepareStatement("SELECT * FROM tipo WHERE nombre= ?")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tipo = crearTipo(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipo;
    }

    private Tipo crearTipo(ResultSet rs) throws SQLException {
        Tipo t = new Tipo();
        t.setId(rs.getInt("id"));
        t.setNombre(rs.getString("nombre"));
        return t;
    }
}
