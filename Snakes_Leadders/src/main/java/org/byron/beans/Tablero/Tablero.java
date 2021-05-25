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

    public Tablero() {
    }

    public Posicion[][] getMatriz() {
        return matriz;
    }

    public void addPosicion(Posicion new_posicion) {
        this.matriz[new_posicion.getCoor_x()][new_posicion.getCoor_y()] = new_posicion;
    }

    public void llenar_tablero() {
        Tipo algo = new Tipo();
        algo.setNombre("normal");
        for (int i = 9; i > -1; i--) {
            for (int j = 9; j > -1; j--) {
                if (matriz[i][j] == null) {
                    Posicion new_posicion = new Posicion();
                    new_posicion.setCoor_x(i);
                    new_posicion.setCoor_y(j);
                    new_posicion.setTipo(algo);
                    if (i == 0 && j== 0){
                        new_posicion.setSimbolo("*");
                    }else if (i==9 && j==9){
                        new_posicion.setSimbolo("$");
                    }else{
                        new_posicion.setSimbolo(" ");
                    }
                    matriz[i][j] = new_posicion;
                }
            }
        }
    }

    public Posicion get_Posicion(int x, int y) {
        return matriz[x][y];
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
