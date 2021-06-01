package org.byron.juego;

import org.byron.beans.Jugador.Jugador;
import org.byron.beans.Posicion.Posicion;
import org.byron.beans.Tablero.Tablero;

import java.util.Scanner;

public class Tiro {
    public static Tablero tablero = Juego.tablero;
    public static Jugador[] Jugadores = Juego.Jugadores;
    public static int canJugadores = Juego.canJugadores;
    public static int turno = 1;
    public static int ronda = 1;
    static Scanner entrada = new Scanner(System.in);
    public static String vista_tablero;

    public static void llenarTablero() {
        System.out.println("" +
                "" +
                "");

        vista_tablero = "  Turno del jugador: " + turno + "        Jugador: " + Jugadores[turno - 1].getNombre() + "        Ronda: " + ronda;
        vista_tablero += "\n                                                                  ";
        for (int i = 9; i > -1; i--) {
            vista_tablero += "\n---------------------------------------------------------------------------------";
            vista_tablero += "\n";
            for (int j = 9; j > -1; j--) {
                vista_tablero += "|" + tablero.get_Posicion(i, j).getSimbolo();
            }
            vista_tablero += "|";
        }
        vista_tablero += "\n---------------------------------------------------------------------------------";
        if (turno < Jugadores.length) {
            turno += 1;
        } else {
            turno = 1;
        }
        ronda += 1;
        System.out.println(vista_tablero);


    }

    public static void iniciar() {
        for (int i = 0; i < Jugadores.length; i++) {
            if(Jugadores[i] != null){
                Posicion agregar = tablero.get_Posicion(0, 0);
                agregar.setSimbolo(String.valueOf(i+1));
            }

        }
        llenarTablero();
    }

    public static void continuar() {
        llenarTablero();
    }

}
