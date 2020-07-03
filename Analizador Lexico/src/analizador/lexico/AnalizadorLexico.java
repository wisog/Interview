package analizador.lexico;
import java.util.Scanner;

/**
 *
 * @author gumaro
 */
public class AnalizadorLexico {

    
    public static void main(String[] args) {
        //Declaracion de objetos 
        AnalizadorLexico obj = new AnalizadorLexico();
        Scanner read = new Scanner(System.in);
        
        //Variable para guradara la frase 
        String sentence;
        
        //Pedimos la cadena a nalizar
        System.out.println("Dame una cadena");
        sentence=read.next();
        
        //Expresion para separar la palabra con sus coordenadas
        String regex = "(?=\\(+[0-9]+,[0-9]+\\))";
        //Almacenamos las palabaras en el arreglo
        String[] parts = sentence.split(regex);
        
        //Se recorre el arreglo y se manda llamar al metodo calcular para agregar el espacio
        for (int i = 0; i < parts.length; i++) {
            System.out.println(obj.Espace(parts[i]));
        }
    }

    public StringBuilder Espace(String word) {
        //creamos objeto de la clase StringBuilder para manipular la cadena
        StringBuilder result = new StringBuilder(word);
        //Se Recorre la cadena en busca de un caracte no  numerico
        for (int i = 0; i < word.length(); i++) {
            //if para encontrar el caracter no numerico y encotrar la posicion para a gregar el espacio 
            if ((result.charAt(i) >= 'a' && result.charAt(i) <= 'z') || (result.charAt(i) >= 'A' && result.charAt(i) <= 'Z')) {
                //se agrega el espacio y se sale del ciclo
                result.insert(i, " ");
                break;
            }
        }
        //retornamos el valor 
        return result;
    }
}
