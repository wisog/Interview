package a_lexico;

import java.util.Scanner;
import java.util.regex.Pattern;

public class A_Lexico {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Analizador Lexico");
        System.out.println("");
        System.out.println("Introduzca la cadena de texto: ");
        String ctext = read.next();
        //Separar texto
        String separa = Pattern.quote("(");
        //Text Array
        String[] spart = ctext.split(separa);
        //Imprimir Array
        for (String spart1 : spart) {
            if (spart1 == null ? spart[0] == null : spart1.equals(spart[0])) {
                System.out.println("");
            } else {
                System.out.println("(" + spart1);
            }
        }

    }

}
