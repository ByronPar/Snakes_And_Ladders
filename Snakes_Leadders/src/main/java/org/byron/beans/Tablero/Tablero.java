package org.byron.beans.Tablero;

import org.byron.beans.Escalera.Escalera;
import org.byron.beans.Jugador_Tablero.Jugador_Tablero;
import org.byron.beans.Serpiente.Serpiente;

import java.util.ArrayList;

public class Tablero {
    private int id_tablero;
    private ArrayList<Escalera> escaleras;
    private ArrayList<Serpiente> serpientes;
    private ArrayList<Jugador_Tablero> jugadores;

    public Tablero(int id_tablero, ArrayList<Escalera> escaleras, ArrayList<Serpiente> serpientes, ArrayList<Jugador_Tablero> jugadores) {
        this.id_tablero = id_tablero;
        this.escaleras = escaleras;
        this.serpientes = serpientes;
        this.jugadores = jugadores;
    }

    public Tablero() {
    }

    public ArrayList<Escalera> getEscaleras() {
        return escaleras;
    }

    public void setEscaleras(ArrayList<Escalera> escaleras) {
        this.escaleras = escaleras;
    }

    public ArrayList<Serpiente> getSerpientes() {
        return serpientes;
    }

    public void setSerpientes(ArrayList<Serpiente> serpientes) {
        this.serpientes = serpientes;
    }

    public ArrayList<Jugador_Tablero> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador_Tablero> jugadores) {
        this.jugadores = jugadores;
    }

    public int getId_tablero() {
        return id_tablero;
    }

    public void setId_tablero(int id_tablero) {
        this.id_tablero = id_tablero;
    }
}
