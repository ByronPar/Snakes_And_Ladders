package org.byron.beans;

public class Jugador_Tablero {
    private int id_J_T;
    private int id_Tablero;
    private int id_Jugador;

    public Jugador_Tablero(int id_J_T, int id_Tablero, int id_Jugador) {
        this.id_J_T = id_J_T;
        this.id_Tablero = id_Tablero;
        this.id_Jugador = id_Jugador;
    }

    public Jugador_Tablero(){

    }

    public int getId_J_T() {
        return id_J_T;
    }

    public void setId_J_T(int id_J_T) {
        this.id_J_T = id_J_T;
    }

    public int getId_Tablero() {
        return id_Tablero;
    }

    public void setId_Tablero(int id_Tablero) {
        this.id_Tablero = id_Tablero;
    }

    public int getId_Jugador() {
        return id_Jugador;
    }

    public void setId_Jugador(int id_Jugador) {
        this.id_Jugador = id_Jugador;
    }
}
