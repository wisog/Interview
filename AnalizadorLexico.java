import java.util.LinkedList;
import java.util.Scanner;

public class AnalizadorLexico {

    private static LinkedList<Character> lista = new LinkedList<Character>();

    public static void main(String[] args) {
        String cad, cadena;
        Scanner sc = new Scanner(System.in);
        cadena = sc.nextLine();
        // Elimina espacios, tabuladores, retornos de la cadena ingresada por el usuario
        cad = cadena.replaceAll("\\s", "");
        /**
         * Verificamos si la cadena ingresada no excede de 256 caracteres,
         * despues agregamos a la lista de caracteres todos los caracteres de la
         * cadena e instansiamos un objeto de la clase Token, le pasamos la
         * lista de caracteres a analizar y con ese objeto mandamos llamar al
         * método de analizarCadena
         */
        if (cad.length() <= 256) {
            for (int i = 0; i < cad.length(); i++) {
                lista.add(cad.charAt(i));
            }
            Token t = new Token(lista);
            t.analizarCadena();
        } else {
            System.out.println("Debe ingresar una cadena con no mas de 256 caracteres");
        }

    }

}
