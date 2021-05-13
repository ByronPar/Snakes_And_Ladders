package org.byron.beans.Jugador_Tablero;

import org.byron.beans.Jugador.Jugador;
import org.byron.beans.Tablero.Tablero;

public class Jugador_Tablero {
    private int id_J_T;
    private Tablero tablero;
    private Jugador jugador;


    public Jugador_Tablero(){

    }

    public Jugador_Tablero(int id_J_T, Tablero tablero, Jugador jugador) {
        this.id_J_T = id_J_T;
        this.tablero = tablero;
        this.jugador = jugador;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getId_J_T() {
        return id_J_T;
    }

    public void setId_J_T(int id_J_T) {
        this.id_J_T = id_J_T;
    }
}
