package org.byron.inicio;

import org.byron.juego.Juego;

import java.util.Scanner;

public class Inicio {
    public static void main(String[] args) {
        iniciar();
    }

    public static void iniciar() {
        System.out.println("-----------------------  JUEGO SERPIENTES Y ESCALERAS  -----------------------");
        for (int i = 0; i < 3; i++) {
            System.out.println(" ");
        }
        String menu = "     Ingrese el número de la opción que desee:  --> "
                + "     \n1) Iniciar Juego"
                + "     \n2) Regresar al Juego"
                + "     \n3) Salir";
        System.out.println(menu);
        Scanner entrada = new Scanner(System.in);
        try {  // eligire las opciones a realizar
            String opcion = entrada.nextLine();
            switch (opcion) {
                case "1":
                    Juego.IngresarJugadores();
                    break;
                case "2":
                    System.out.println("Regresar a la partida ");
                    //Juego.RegresarPartida();
                    break;
                case "3":
                    System.out.println("\n\n         Fin del Programa, Gracias Por Jugar ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n\n     Selecciono una opción incorrecta , vuelva  a intentarlo");
                    iniciar();
                    break;

            }
        } catch (Exception e) {
            System.out.println("\n\nSelecciono una opción incorrecta , vuelva  a intentarlo");
            iniciar();

        }

    }
}
