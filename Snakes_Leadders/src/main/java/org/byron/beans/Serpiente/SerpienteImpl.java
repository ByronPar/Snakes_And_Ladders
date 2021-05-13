package org.byron.beans.Serpiente;

import org.byron.beans.Jugador.Jugador;
import org.byron.conexion.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SerpienteImpl implements RepoSerpiente<Serpiente>{
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }


    @Override
    public void guardar(Serpiente serpiente) {
        String sql = "INSERT INTO serpiente(nombre, id_pos_ser, id_tab_ser) VALUES(?,?,?)";

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setString(1, serpiente.getNombre());
            stmt.setInt(2, serpiente.getPosicion().getId());
            stmt.setInt(3, serpiente.getTablero().getId_tablero());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void borrar(int id) {
        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM serpiente WHERE id=?")){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
