/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capicúas;

import java.util.Scanner;
        
public class Capicúas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        long n=0, uN, inverso=0, suma, NC=0, aux, ni=0, auxS;
        
	//asegura que la entrada sea de almenos dos dígitos y menor o igual a 10000
        while(n<10 || n>10000){
            System.out.println("Ingresa un número de mas de una cifra (máximo 10000): ");
            n=reader.nextInt();
        }
        
	//sacar el inverso del  número de entrada 
        do{   
            aux=n;
        
            while(aux>0){
                uN=aux%10;
                inverso= inverso*10+uN;
                aux=aux/10;
            }
        
	//suma del número original y su inverso	
            suma=n+inverso;
        
            auxS=suma;
      	
	//inverso de la suma     
            while(auxS>0){
                uN=auxS%10;
                NC= NC*10+uN;
                auxS=auxS/10;
            }
        
	//Comprueba si el número de la suma es Capicúa y va acumulando el número de iteraciones
            if(suma != NC){
                n=suma;
                inverso=0;
                NC=0;
                ni++;
            }
        

	//Ésto mientras el número de la suma no sea igual a su inverso 
        }while(n==suma);
            System.out.println(NC + " " + (ni+1) );
    }
    
}
