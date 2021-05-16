/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.byron.juego;

import org.byron.beans.Jugador.Jugador;
import org.byron.beans.Jugador.RepoJugador;
import org.byron.beans.Jugador_Tablero.Jugador_Tablero;
import org.byron.beans.Jugador_Tablero.RepoJugador_Tablero;
import org.byron.beans.Posicion.Posicion;
import org.byron.beans.Tablero.RepoTablero;
import org.byron.beans.Tablero.Tablero;
import org.byron.conexion.ConexionDB;

import java.util.ArrayList;
import java.util.Scanner;


public class Juego {
    public static Tablero tablero = new Tablero();
    public static Jugador[] Jugadores = new Jugador[3];
    public static int canJugadores;
    static Scanner entrada = new Scanner(System.in);

    public static void IngresarJugadores() {

        boolean salir = false;
        do {
            String opciones = "     FASE 1"
                    + " "
                    + "     ¿Escoge cuantos jugadores jugaran?  --> "
                    + "     \n 1)  2 jugadores"
                    + "     \n 2)  3 jugadores";
            System.out.println(opciones);
            var option = entrada.nextLine();
            switch (option) {
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

    public static void registroJugadores(int num) {  // metodo para registrar los nombres de los jugadores
        canJugadores = num;
        for (int i = 0; i < num; i++) {
            System.out.println("Ingrese el nombre del jugador " + (i + 1));
            String name = entrada.nextLine();
            if (!name.trim().isEmpty()) {
                Jugador jug = new Jugador();
                jug.setNombre(name);
                jug.setNumero(i + 1);
                Jugadores[i] = jug;
            } else {
                System.out.println("     ERROR , VUELVA A INTENTARLO ");
                System.out.println(" ");
                registroJugadores(num);
            }

        }
        RepoJugador<Jugador> conn = ConexionDB.getRepoJugador();
        RepoTablero<Tablero> connt = ConexionDB.getRepoTablero();
        RepoJugador_Tablero<Jugador_Tablero> connt2 = ConexionDB.getRepoJugador_Tablero();
        Tablero t = new Tablero();
        connt.guardar(t);
        tablero = connt.ultimo();
        for (int i = 0; i < num; i++) {
            conn.guardar(Jugadores[i]);
            Jugador_Tablero partida = new Jugador_Tablero();
            partida.setTablero(tablero);
            partida.setJugador(conn.porNombre(Jugadores[i].getNombre()));
            connt2.guardar(partida);
        }
        conn.listar().forEach(System.out::println);
        configuracionJuego();

    }

    public static void configuracionJuego() { // ingresara las 3 coordenadas
        String opciones1 = "             FASE 2"
                + " "
                + "             CONFIGURACIÓN DEL TABLERO  --> "
                + "     \n "
                + "     \n      Ingrese las coordenas de las serpientes . Ejemplo : x1,y1;x2,y2;x3,y3"
                + "     \n\n      Solamente puede Ingresar 6 coordenas (x,y) como maximo y 2 como minimo , ingrese valores entre  0 y 10";
        String opciones2 = "             FASE 2"
                + " "
                + "             CONFIGURACIÓN DEL TABLERO  --> "
                + "     \n "
                + "     \n      Ingrese las coordenas de las escaleras . Ejemplo : x1,y1;x2,y2;x3,y3"
                + "     \n\n      Solamente puede Ingresar 6 coordenas (x,y) como maximo y 2 como minimo , ingrese valores entre  0 y 10";
        System.out.println(opciones1);

        System.out.println(" ");
        String coordenadas = entrada.nextLine();
        valCoordenadas(coordenadas, true);
        System.out.println(opciones2);
        System.out.println(" ");
        coordenadas = entrada.nextLine();
        valCoordenadas(coordenadas, false);
    }

    public static void valCoordenadas(String coordenadas, boolean serpientes) { // metodo para verificar que la información que se haya ingresado haya sido correcta
        String[] pos = coordenadas.split(";");
        if (pos.length < 2 || pos.length > 6) { // solamente verifico que sean >= 2 o <= 6 cooordenadas  “1,2;2,3;4,4”
            System.out.println("        Error al ingresar coordenadas, vuelva a intentarlo.");
            configuracionJuego();
        } else {
            try {
                ArrayList posiciones = new ArrayList();
                for (int i = 0; i < pos.length; i++) {// recorro cada coordenada x,y
                    String[] momentaneo = pos[i].split(",");
                    if (momentaneo.length == 2 && Integer.parseInt(momentaneo[0]) > 0 && Integer.parseInt(momentaneo[1]) <= 10) { // means that all it´s ok
                        if (serpientes){
                            ArrayList listaSerpiente = new ArrayList();
                            Posicion posi = new Posicion();
                            posi.setCoor_x(Integer.parseInt(momentaneo[0]));
                            posi.setCoor_y(Integer.parseInt(momentaneo[1]));

                        }else{

                        }
                    } else {
                        System.out.println("        Error al ingresar coordenadas, vuelva a intentarlo.");
                        configuracionJuego();
                    }
                }
                //si culmina all bien, debo crear las serpientes y escaleras del tablero
            } catch (Exception e) {
                System.out.println("        Error al ingresar coordenadas, vuelva a intentarlo.");
                configuracionJuego();
//                posiciones.add(momentaneo[0]);
//                posiciones.add(momentaneo[1]);
            }
        }
    }
}
