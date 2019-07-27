/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador.lexico;

import java.util.Scanner;

/**
 *
 * @author Christian Ramirez
 */
public class AnalizadorLexico {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//se créo una instancia de la libreria Scanner para almacenar y leer valores en variables
        System.out.println("Inserte texto:");//se le pide al usuario insertar una cadena de texto para separar
        String cadena = scanner.next();//se lee y se guarda en una vareable la cadena de texto
        if(cadena.matches("((\\()(\\d*)(\\,)(\\d*)(\\))(\\w*))*")){//con la funcion matches se valida si cumple con el patron de caracteres asignados
           String[] cadenaArray;//se crea un array de las separaciones echas por la función 
        cadenaArray = cadena.split("\\(");//se separa la información asignada en la cadena
        for (int i = 1; i < cadenaArray.length; i++) {//se imprime la informacion guardada y separada que se almaceno en el array
            System.out.println("(" + cadenaArray[i]);
        } 
        }
        
    }
}
