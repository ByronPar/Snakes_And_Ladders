package org.byron.beans.Tablero;

import org.byron.beans.Jugador_Tablero.Jugador_Tablero;
import org.byron.beans.Posicion.Posicion;

import java.util.ArrayList;

public class Tablero {
    private int id;
    private ArrayList<Jugador_Tablero> jugadores;
    private Posicion matriz[][] = new Posicion[10][10];

    public Tablero() {
    }

    public Posicion[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(Posicion[][] matriz) {
        this.matriz = matriz;
    }

    public ArrayList<Jugador_Tablero> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador_Tablero> jugadores) {
        this.jugadores = jugadores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
