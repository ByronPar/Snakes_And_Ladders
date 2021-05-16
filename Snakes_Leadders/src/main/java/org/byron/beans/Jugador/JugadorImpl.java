package org.byron.beans.Jugador;

import org.byron.conexion.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JugadorImpl implements RepoJugador<Jugador> {

    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }

    @Override
    public List<Jugador> listar() {
        List<Jugador> jugadores = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM jugador")) {
            while (rs.next()) {
                Jugador p = crearJugador(rs);
                jugadores.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugadores;
    }


    @Override
    public void guardar(Jugador jugador) {
        String sql;
        Jugador prueba = porNombre(jugador.getNombre());
        if (prueba != null) {
            return;
        } else {
            sql = "INSERT INTO jugador(nombre, numero) VALUES(?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, jugador.getNombre());
            stmt.setInt(2, jugador.getNumero());

            if (jugador.getId() > 0) {
                stmt.setInt(3, jugador.getId());
            }
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Jugador porNombre(String nombre) {
        Jugador jugador = null;
        try (PreparedStatement stmt = getConnection().
                prepareStatement("SELECT * FROM jugador WHERE nombre = ?")) {
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                jugador = crearJugador(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugador;
    }


    private Jugador crearJugador(ResultSet rs) throws SQLException {
        Jugador p = new Jugador();
        p.setId(rs.getInt("id"));
        p.setNombre(rs.getString("nombre"));
        p.setNumero(rs.getInt("numero"));
        return p;
    }
}
