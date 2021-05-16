package org.byron.beans.Tablero;

import org.byron.beans.Jugador_Tablero.Jugador_Tablero;
import org.byron.beans.Posicion.Posicion;
import org.byron.beans.Tipo.RepoTipo;
import org.byron.beans.Tipo.Tipo;
import org.byron.beans.Tipo.TipoImpl;

import java.util.ArrayList;

public class Tablero {
    private int id;
    private ArrayList<Jugador_Tablero> jugadores;
    private final Posicion[][] matriz = new Posicion[10][10];
    private static int fila = 0;
    private static int columna = 0;

    public Tablero() {
    }

    public Posicion[][] getMatriz() {
        return matriz;
    }

    public void addPosicon(Posicion new_posicion) {
        this.matriz[fila][columna] = new_posicion;
        fila++;
        columna++;
    }

    public void llenar_tablero() {
        Tipo algo = new Tipo();
        algo.setNombre("normal");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (matriz[i][j] == null) {
                    Posicion new_posicion = new Posicion();
                    new_posicion.setCoor_x(i);
                    new_posicion.setCoor_y(j);
                    new_posicion.setTipo(algo);
                    matriz[i][j] = new_posicion;
                }
            }
        }
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
