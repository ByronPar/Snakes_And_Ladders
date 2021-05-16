
package org.byron.beans.Jugador;

public class Jugador {
    private String nombre;
    private int id;
    private int numero;

    public Jugador() {

    }

    @Override
    public String toString() {
        return  id +
                " | " +
                nombre +
                " | " +
                numero;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
