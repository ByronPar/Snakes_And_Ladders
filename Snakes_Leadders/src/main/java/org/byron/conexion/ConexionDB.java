package org.byron.conexion;

import org.byron.beans.Escalera.Escalera;
import org.byron.beans.Escalera.EscaleraImpl;
import org.byron.beans.Escalera.RepoEscalera;
import org.byron.beans.Jugador.Jugador;
import org.byron.beans.Jugador.JugadorImpl;
import org.byron.beans.Jugador.RepoJugador;
import org.byron.beans.Jugador_Tablero.Jugador_Tablero;
import org.byron.beans.Jugador_Tablero.Jugador_TableroImpl;
import org.byron.beans.Jugador_Tablero.RepoJugador_Tablero;
import org.byron.beans.Posicion.Posicion;
import org.byron.beans.Posicion.PosicionImpl;
import org.byron.beans.Posicion.RepoPosicion;
import org.byron.beans.Serpiente.RepoSerpiente;
import org.byron.beans.Serpiente.Serpiente;
import org.byron.beans.Serpiente.SerpienteImpl;
import org.byron.beans.Tablero.RepoTablero;
import org.byron.beans.Tablero.Tablero;
import org.byron.beans.Tablero.TableroImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static Connection connection;
    private static RepoEscalera<Escalera> repoEscalera;
    private static RepoJugador<Jugador> repoJugador;
    private static RepoJugador_Tablero<Jugador_Tablero> repoJugador_tablero;
    private static RepoPosicion<Posicion> repoPosicion;
    private static RepoSerpiente<Serpiente> repoSerpiente;
    private static RepoTablero<Tablero> repoTablero;

    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            String password = "byron%bot1";
            String username = "root";
            String url = "jdbc:mysql://localhost:3306/snakes_leadders?serverTimezone=UTC";
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    public static RepoEscalera<Escalera> getRepoEscalera() {
        if (repoEscalera == null) {
            repoEscalera = new EscaleraImpl();
        }
        return repoEscalera;
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

    public static RepoSerpiente<Serpiente> getRepoSerpiente() {
        if (repoSerpiente == null) {
            repoSerpiente = new SerpienteImpl();
        }
        return repoSerpiente;
    }

    public static RepoTablero<Tablero> getRepoTablero() {
        if (repoTablero == null) {
            repoTablero = new TableroImpl();
        }
        return repoTablero;
    }
}
