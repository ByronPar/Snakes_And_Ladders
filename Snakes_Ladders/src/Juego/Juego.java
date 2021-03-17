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
    public void IngresarJugadores(){
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
        
        do {
        String opciones = "     ¿Escoge cuantos jugadores jugaran?  --> "
                    + "     \n 1)  2 jugadores"
                +     "     \n 2)  3 jugadores";
        System.out.println(opciones);
        var option = entrada.nextLine();
        switch(option){
            case "1":
                registroJugadores(2);
                break;
            case "2":
                registroJugadores(3);
                break;
            default:
                System.out.println("Opción incorrecta , Vuelve a intentarlo  --->");
                salir = true;
                break;
        }
        } while (!salir);
        
    }
    
    public void registroJugadores(int num){
    boolean quiere = true;
        int intentos = 0;
        do {
            intentos ++;
        } while (quiere && intentos < 3 && intentos > 1);
        if(intentos < 2){
            System.out.println("Debe ingre");
        }
    }
    
}
