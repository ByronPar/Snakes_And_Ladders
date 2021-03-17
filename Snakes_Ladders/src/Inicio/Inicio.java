/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import java.util.Scanner;


/**
 *
 * @author 32379
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        iniciar();
    }
    
    public static void iniciar(){
        System.out.println("-----------------------  JUEGO SERPIENTES Y ESCALERAS  -----------------------");
        for (int i = 0; i < 3; i++) {
            System.out.println(" ");
        }
        String menu = "     Ingrese el número de la opción que desee:  --> "
                    + "     \n1) Iniciar Juego"
                +     "     \n2) Regresar al Juego"
                +     "     \n3) Salir";
        System.out.println(menu);
        Scanner entrada = new Scanner(System.in);
        try{  // eligire las opciones a realizar
           String opcion =entrada.nextLine();
           switch(opcion){
               case "1":
                   
                   break;
               case "2":
                   System.out.println("Regresar a la partida ");
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
        }catch(Exception e){
            System.out.println("\n\nSelecciono una opción incorrecta , vuelva  a intentarlo");
            iniciar();
            
        }
        
    }
    
    public void otro(){
        }
    
    
    
}
