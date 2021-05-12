package org.byron.beans;

public class Serpiente {
    private int id;
    private String nombre;
    private int id_pos;
    private int id_tablero;

    public Serpiente(int id, String nombre, int id_pos, int id_tablero) {
        this.id = id;
        this.nombre = nombre;
        this.id_pos = id_pos;
        this.id_tablero = id_tablero;
    }

    public Serpiente(){

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

    public int getId_pos() {
        return id_pos;
    }

    public void setId_pos(int id_pos) {
        this.id_pos = id_pos;
    }

    public int getId_tablero() {
        return id_tablero;
    }

    public void setId_tablero(int id_tablero) {
        this.id_tablero = id_tablero;
    }
}
