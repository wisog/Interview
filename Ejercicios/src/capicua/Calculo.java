/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capicua;

/**
 *
 * @author Geny
 */
public class Calculo {
    private long n1, n2;
    private long resto; 
    private int ciclos;
    private long resultado,invResultado;
    private boolean capicua; // se utiliza como bandera para saber si se deben realizar más operaciones
                             // falso si el número obtenido no es capicúa
    
    Calculo(){
        n1 = 0;
        n2 = 0;
        resultado = 0;
        ciclos = 0;
        invResultado = 0;
        capicua = false;
    }
    
    public long invierte(long n){
        long inv = 0; // variable que guarda el valor invertido del número
        // el número original se divide entre 10 y el residuo se guarda en la variable inv
        // en donde se va multiplicando por 10 para invertir su posición
        while(n>0){
            resto = n % 10;
            inv = inv * 10 + resto;
            n = n/10;
        }
        return inv;
    }
    
    public void reiniciaVariables(){
        n2 = 0;
        resultado = 0;
        ciclos = 0;
        capicua = false;
        invResultado = 0;
    }
    
    public void calculo(long num){
       reiniciaVariables();
       n1 = num;
        do{
            n2 = invierte(n1);
            resultado = n1 + n2;
            invResultado = invierte(resultado);
            
            ciclos++;
            if(resultado!=invResultado){
                n1 = resultado;  
            }else{
                capicua = true;
            }
        }while(!capicua);
        System.out.println(resultado+" "+ciclos);
    }
}
