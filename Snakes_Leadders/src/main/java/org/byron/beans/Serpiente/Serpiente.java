package org.byron.beans.Serpiente;

import org.byron.beans.Posicion.Posicion;
import org.byron.beans.Tablero.Tablero;

public class Serpiente {
    private int id;
    private String nombre;
    private Posicion posicion;
    private Tablero tablero;


    public Serpiente(){

    }

    public int getId() {
        return id;
    }

    public Serpiente(int id, String nombre, Posicion posicion, Tablero tablero) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
        this.tablero = tablero;
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
