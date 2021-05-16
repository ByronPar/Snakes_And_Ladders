package org.byron.beans.Jugador_Tablero;

import org.byron.beans.Jugador.Jugador;
import org.byron.beans.Tablero.Tablero;

public class Jugador_Tablero {
    private int id;
    private Tablero tablero;
    private Jugador jugador;


    public Jugador_Tablero(){

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
