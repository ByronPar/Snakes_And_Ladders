package org.byron.conexion;

import org.byron.beans.Jugador.Jugador;
import org.byron.beans.Jugador.JugadorImpl;
import org.byron.beans.Jugador.RepoJugador;
import org.byron.beans.Jugador_Tablero.Jugador_Tablero;
import org.byron.beans.Jugador_Tablero.Jugador_TableroImpl;
import org.byron.beans.Jugador_Tablero.RepoJugador_Tablero;
import org.byron.beans.Posicion.Posicion;
import org.byron.beans.Posicion.PosicionImpl;
import org.byron.beans.Posicion.RepoPosicion;
import org.byron.beans.Tablero.RepoTablero;
import org.byron.beans.Tablero.Tablero;
import org.byron.beans.Tablero.TableroImpl;
import org.byron.beans.Tipo.RepoTipo;
import org.byron.beans.Tipo.Tipo;
import org.byron.beans.Tipo.TipoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static Connection connection;
    private static RepoJugador<Jugador> repoJugador;
    private static RepoJugador_Tablero<Jugador_Tablero> repoJugador_tablero;
    private static RepoPosicion<Posicion> repoPosicion;
    private static RepoTablero<Tablero> repoTablero;
    private static RepoTipo<Tipo> repoTipo;

    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            String password = "byron%bot1";
            String username = "root";
            String url = "jdbc:mysql://localhost:3306/snakes_leadders?serverTimezone=UTC";
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    public static RepoJugador<Jugador> getRepoJugador() {
        if (repoJugador == null) {
            repoJugador = new JugadorImpl();
        }
        return repoJugador;
    }

    public static RepoJugador_Tablero<Jugador_Tablero> getRepoJugador_Tablero() {
        if (repoJugador_tablero == null) {
            repoJugador_tablero = new Jugador_TableroImpl();
        }
        return repoJugador_tablero;
    }

    public static RepoPosicion<Posicion> getRepoPosicion() {
        if (repoPosicion == null) {
            repoPosicion = new PosicionImpl();
        }
        return repoPosicion;
    }

    public static RepoTablero<Tablero> getRepoTablero() {
        if (repoTablero == null) {
            repoTablero = new TableroImpl();
        }
        return repoTablero;
    }

    public static RepoTipo<Tipo> getRepoTipo() {
        if (repoTipo == null) {
            repoTipo = new TipoImpl();
        }
        return repoTipo;
    }
}
