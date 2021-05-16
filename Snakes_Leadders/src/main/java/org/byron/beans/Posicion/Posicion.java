package org.byron.beans.Posicion;

import org.byron.beans.Jugador.Jugador;
import org.byron.beans.Tipo.Tipo;

public class Posicion {
    private int id;
    private int coor_x;
    private int coor_y;
    private Tipo tipo;
    private Jugador jugador;

    public Posicion() {

    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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

    public int getCoor_x() {
        return coor_x;
    }

    public void setCoor_x(int coor_x) {
        this.coor_x = coor_x;
    }

    public int getCoor_y() {
        return coor_y;
    }

    public void setCoor_y(int coor_y) {
        this.coor_y = coor_y;
    }
}
