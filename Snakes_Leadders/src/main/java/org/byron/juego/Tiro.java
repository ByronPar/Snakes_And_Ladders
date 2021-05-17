package org.byron.juego;

import org.byron.beans.Jugador.Jugador;
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
                vista_tablero=   "  Turno del jugador: "+turno+"                         Ronda: "+ronda;
        vista_tablero += "\n                                                                  ";
        for (int i = 9; i > -1; i--) {
            vista_tablero += "\n-------------------------------------------------------------";
            vista_tablero += "\n";
            for (int j = 9; j > -1; j--) {
                vista_tablero += "|  "+tablero.get_Posicion(i,j).getSimbolo()+"  ";
            }
            vista_tablero += "|";
        }
        System.out.println(vista_tablero);
    }

    public static void iniciar(){

    }

}
