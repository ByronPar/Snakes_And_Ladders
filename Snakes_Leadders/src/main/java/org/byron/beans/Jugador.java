
package org.byron.beans;

public class Jugador {
    private String nombre;
    private int id;
    private String numero;

    public Jugador(String nombre, int id, String numero) {
        this.nombre = nombre;
        this.id = id;
        this.numero = numero;
    }

    public Jugador() {

    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
