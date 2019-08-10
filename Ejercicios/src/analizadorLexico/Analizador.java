/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorLexico;

/**
 *
 * @author Geny
 */
public class Analizador {
    private String varAux; // guarda el valor de la expresión que corresponde a una coordenada
    private int estado; // guarda valores del 1 al 6 dependiendo del caracter actual en la posicion i
    private char caracter; // caracter en la posición de i
    
    
    public Analizador(){
        varAux = "";
        estado = 0;
    }
    
    /*
        Para encontrar la solcución se utilizó un autómata de estados finitos con 6 estados
        Los estados del 1 al 5 se utilizan para identificar coordenadas.
        Cuando el autómata llega al estado 5 muestra la coordenada encontrada
        El estado 6 identifica cadenas de texto, si se encuentra un parentesis de apertura 
        se reresa al estado 1 porque puede haber una coordenada nueva.
        Si en los estados del 1 al 5 se encuentra una letra que haga que la expresión ya no pueda
        ser una coordenada, el estado cambia de nuevo a 6.
    */
    public void analiza(String cadena){
        for(int i=0;i<cadena.length();i++){
            caracter = cadena.charAt(i);
            switch(estado){
                case 0:
                    if(caracter=='('){
                        estado = 1;
                        varAux += caracter;                                                             
                    }
                    break;
                case 1:
                    // en el estado 1 se recibió '(' como entrada, 
                    // lo que puede ser una coordeana o texto, dependiendo de
                    // los siguiente caracteres de entrada
                    if(caracter>='0'&&caracter<='9'){
                        estado = 2;
                        varAux += caracter;
                    }
                    if(caracter>='a' && caracter<='z'||caracter>='A' && caracter<='Z'){
                        estado = 6;
                        System.out.print(varAux);
                        varAux = "";
                    }
                    break;
                case 2:
                    if(caracter>='0' && caracter<='9'){
                        varAux += cadena.charAt(i);
                    }
                    if(caracter==','){
                        estado = 3;
                        varAux += cadena.charAt(i);
                    }
                    if(caracter>='a' && caracter<='z'||caracter>='A' && caracter<='Z'){
                        estado = 6;
                        System.out.print(varAux);
                        varAux = "";
                    }
                    break;
                case 3:
                    if(caracter>='0'&&caracter<='9'){
                        varAux += cadena.charAt(i);
                        estado = 4;
                    }
                    if(caracter>='a' && caracter<='z'||caracter>='A' && caracter<='Z'){
                        estado = 6;
                        System.out.print(varAux);
                        varAux = "";
                    }
                    break;
                case 4:
                    if(caracter>='0'&&caracter<='9'){
                        varAux += cadena.charAt(i);
                    }
                    if(caracter==')'){
                        estado = 5;
                        varAux += caracter;
                    }
                    if(caracter>='a' && caracter<='z'||caracter>='A' && caracter<='Z'){
                        estado = 6;
                        System.out.print(varAux);
                        varAux = "";
                    }
                    break;
                case 5:
                    // Hay una coordenada identificada
                    // se muestra en consola y la varAux se inicializa
                    // se pasa al estado 6 para analizar el texto que sigue a la coordenada
                    System.out.print("\n"+varAux+ " ");
                    varAux = "";
                    if(caracter>='0'&&caracter<='9'||caracter>='a'&&caracter<='z'||caracter>='A'&&caracter<='Z'
                       ||caracter=='('){
                        
                        estado = 6;
                        System.out.print(caracter);
                    }
                    break;
                case 6:
                    // en el estado 6 la expresion acepta letras y numeros,
                    // si se encuentra un '(' se pasa al estado 1 porque puede ser
                    // el inicio de otra coordenada nueva
                    if(caracter>='0'&&caracter<='9'||caracter>='a'&&caracter<='z'
                      ||caracter>='A'&&caracter<='Z'||caracter==')'){
                        System.out.print(caracter);
                    }
                    if(caracter=='('){
                        estado = 1;
                        varAux += caracter;
                    }
                    break;
            }
        }
        System.out.println();
    }
}
