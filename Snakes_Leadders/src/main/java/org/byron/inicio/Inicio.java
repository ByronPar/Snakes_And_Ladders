package org.byron.inicio;

import org.byron.beans.Jugador.JugadorImpl;
import org.byron.beans.Jugador.RepoJugador;
import org.byron.beans.Jugador.Jugador;
import org.byron.conexion.ConexionDB;

import java.sql.*;

public class Inicio {
    public static void main(String[] args) {

        try (Connection conn = ConexionDB.getInstance()) {
            RepoJugador<Jugador> repositorio = new JugadorImpl();
            System.out.println("============ listar ============");

            repositorio.listar().forEach(System.out::println);
            System.out.println("============ obtener por Nombre ============");
            System.out.println(repositorio.porNombre("Byron Par"));

            System.out.println("============ eliminar jugador ============");
            repositorio.eliminar(3);
            System.out.println("Jugador eliminado con exito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
