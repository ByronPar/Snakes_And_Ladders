/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import beans.Jugador;
import java.util.Scanner;

/**
 *
 * @author 32379
 */

public class Juego {
    public static String tablero [][] = new String[10][10];
    public static Jugador Jugadores [] = new Jugador[3];
    public static int canJugadores ;
    static Scanner entrada = new Scanner(System.in);
    public static void IngresarJugadores(){
        boolean salir = false;
        do {
        String opciones = "     FASE 1"
                + " "
                + "     ¿Escoge cuantos jugadores jugaran?  --> "
                    + "     \n 1)  2 jugadores"
                +     "     \n 2)  3 jugadores";
        System.out.println(opciones);
        var option = entrada.nextLine();
        switch(option){
            case "1":
                registroJugadores(2);
                salir = true;
                break;
            case "2":
                registroJugadores(3);
                salir = true;
                break;
            default:
                System.out.println("Opción incorrecta , Vuelve a intentarlo  --->");
                break;
        }
        } while (!salir);
        
    } // metodo para pedir la cantidad de jugadores que jugaran
    
    public static void registroJugadores(int num){  // metodo para registrar los nombres de los jugadores
        canJugadores = num;
        for (int i = 0; i < num; i++) {
            System.out.println("Ingrese el nombre del jugador " + (i+1));
            String name = entrada.nextLine();
            Jugador jug = new Jugador(name);
            Jugadores[i] = jug;
        }
        configuracionJuego();
        
    }
    
    public static void configuracionJuego(){ // ingresara las 3 coordenadas
    String opciones = "             FASE 2"
                + " "
                +     "             CONFIGURACIÓN DEL TABLERO  --> "
                    + "     \n "
                +     "     \n      Ingrese las coordenas de las serpientes y Escaleras. Ejemplo : x1,y1;x2,y2;x3,y3"
                +     "     \n\n      Solamente puede Ingresar 6 coordenas (x,y) como maximo  y 2 como minimo";
        System.out.println(opciones);
        System.out.println(" ");
        String coordenadas = entrada.nextLine();
        valCoordenadas(coordenadas);
    }
    
    public static void valCoordenadas(String coordenadas){ // metodo para verificar que la información que se haya ingresado haya sido correcta
        String[] pos = coordenadas.split(";");
        if (pos.length < 2 || pos.length > 6){
            System.out.println("        Error al ingresar coordenadas, vuelva a intentarlo.");
            configuracionJuego();
        }else{
            for()
        }
    }
    
    
    
    
}
