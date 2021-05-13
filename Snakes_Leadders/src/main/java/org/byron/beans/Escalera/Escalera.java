package org.byron.beans.Escalera;

import org.byron.beans.Posicion.Posicion;
import org.byron.beans.Tablero.Tablero;

public class Escalera {
    private int id;
    private String nombre;
    private Posicion posicion;
    private Tablero tablero;

    public Escalera(int id, String nombre, Posicion posicion, Tablero tablero) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
        this.tablero = tablero;
    }

    public Escalera(){

    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
