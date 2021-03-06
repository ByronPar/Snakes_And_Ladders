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
import org.byron.beans.Posicion.PosicionImpl;
import org.byron.beans.Posicion.RepoPosicion;
import org.byron.beans.Tablero.RepoTablero;
import org.byron.beans.Tablero.Tablero;
import org.byron.beans.Tipo.RepoTipo;
import org.byron.beans.Tipo.Tipo;
import org.byron.beans.Tipo.TipoImpl;
import org.byron.conexion.ConexionDB;
import org.byron.inicio.Inicio;

import java.util.ArrayList;
import java.util.Scanner;


public class Juego {
    public static Tablero tablero = new Tablero();
    public static Jugador[] Jugadores = new Jugador[3];
    public static int canJugadores;
    static Scanner entrada = new Scanner(System.in);
    public static RepoTipo<Tipo> tipo = new TipoImpl();
    public static RepoPosicion<Posicion> addPos = new PosicionImpl();
    public static ArrayList<Posicion> agregar_pos = new ArrayList<>();

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
        boolean pasar;
        for (int i = 0; i < 2; i++) {
            do {
                if (i == 0) pasar = hacer(opciones1, true);
                else pasar = hacer(opciones2, false);
            } while (!pasar);
            llenar();  //llena los datos
        }
        tablero.llenar_tablero(); // culmino de llenar all my tablero
        Tiro.iniciar();

    }

    public static boolean hacer(String msj, boolean hacer) {
        System.out.println(msj);
        System.out.println(" ");
        String coordenadas = entrada.nextLine();
        return valCoordenadas(coordenadas, hacer);
    }

    public static void llenar() {
        addPos = new PosicionImpl();
        for (Posicion elemento : agregar_pos) {
            addPos.guardar(elemento, tablero.getId());// almaceno en base de datos
            tablero.addPosicion(elemento);    //  almaceno en mi tablero que manejo para jugar

        }
    }

    public static boolean valCoordenadas(String coordenadas, boolean serpientes) { // metodo para verificar que la información que se haya ingresado haya sido correcta
        String[] pos = coordenadas.split(";");
        if (pos.length < 2 || pos.length > 6) { // solamente verifico que sean >= 2 o <= 6 cooordenadas  “1,2;2,3;4,4”
            System.out.println("        Error al ingresar coordenadas, vuelva a intentarlo.");
            return false;
        } else {
            try {
                agregar_pos = new ArrayList<>();
                for (int i = 0; i < pos.length; i++) {   // recorro cada coordenada x,y
                    String[] momentaneo = pos[i].split(",");
                    if (momentaneo.length == 2 && Integer.parseInt(momentaneo[0]) > 0 && Integer.parseInt(momentaneo[1]) <= 10) { // means that all it´s ok
                        if ((Integer.parseInt(momentaneo[0]) == 1 && Integer.parseInt(momentaneo[1]) == 1) ||
                                (Integer.parseInt(momentaneo[0]) == 10 && Integer.parseInt(momentaneo[0]) == 10)) {
                            System.out.println("        No puede ingresar escaleras o serpientes al inicio o final del tablero.");
                            return false;
                        }
                        Posicion posi = new Posicion();
                        posi.setCoor_x(Integer.parseInt(momentaneo[0]) - 1);
                        posi.setCoor_y(Integer.parseInt(momentaneo[1]) - 1);
                        if (!tablero.verificarPos(posi)) {
                            if (serpientes) {
                                posi.setTipo(tipo.forName("serpiente"));
                                posi.setSimbolo("S");
                            } else {
                                posi.setTipo(tipo.forName("escalera"));
                                posi.setSimbolo("E");
                            }
                            agregar_pos.add(posi);
                        } else {
                            System.out.println("        Coordenada " + (posi.getCoor_x()+1) + "," + (posi.getCoor_y()+1) + "  Ya estaba registrada.");
                        }


                    } else {
                        System.out.println("        Error al ingresar coordenadas, vuelva a intentarlo.");
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                System.out.println("        Error al ingresar coordenadas, vuelva a intentarlo.");
                return false;
            }
        }
    }

}
