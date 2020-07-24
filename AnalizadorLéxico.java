
package analizadorléxico;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalizadorLéxico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader= new Scanner(System.in);
        String cadena;
        
        do{
            System.out.println("Ingresa una linea de texto con el siguiente formato: '(x1,y1)texto1(x2,y2)texto2(x3,y3)texto3'");
            cadena=reader.nextLine();
        }while(cadena.length()>250);
        
        Pattern pat = Pattern.compile("(([0-9]*,[0-9]*)){1}([A-Za-z0-9-_]+)*");   
        Matcher mat = pat.matcher(cadena);
       
       
        if(mat.find()){
            System.out.println(mat.group());
            StringTokenizer st;
            st = new StringTokenizer(cadena);
            while (st.hasMoreTokens())                                                                                        
                System.out.println(st.nextToken(mat.group()));
       }else{
          System.out.println("Formato invalido");
       }
                
    }
}
