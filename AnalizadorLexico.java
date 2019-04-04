import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author danmn
 */
public class AnalizadorLexico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
			 String str = in.nextLine(), tmp = str, tmpInit_position;
			 
			 //Lista de elementos.
       List<Element> elements = new ArrayList<>();
			 
			 //Mientras exista una pareja de parentesis.
       while (tmp.indexOf('(') != -1 && tmp.indexOf(')') != -1) {
           int end_position = tmp.indexOf(')');
					 String coords = tmp.substring(tmp.indexOf('(') + 1 , end_position);
					 
					 //Si son coordenadas validas se crea un objeto Element
           if (Element.isValidCoords(coords)) {
               tmpInit_position = tmp.substring(tmp.indexOf(')') + 1);
               System.out.println(tmpInit_position);
               elements.add(new Element(Element.setCoords(coords), end_position, 0 )); //Falta la variable, iría en lugar del 0.
           }
           tmp = tmp.substring(end_position + 1);
			 }
			 
			 //Se imprimen sus respectivos valores.
       for (Element elt : elements) {
           System.out.println((elt.toString()));
       }
       
       
    }
}

//Clase que contiene las coordenadas x & y, y su texto especifico.
class Element {
    
    int x, y;
    int init_position, end_position;
    String text;
    
    Element(int[] coords, int init_position, int end_position) {
        this.x = coords[0] ;
        this.y = coords[1];
        this.init_position = init_position;
        this.end_position = end_position;
    }
		
    public void setPositions(int init_position, int end_position) {
        this.init_position = init_position;
        this.end_position = end_position;
    }
		
		//Definición del texto con las respectivas posiciones.
    public void setText(String str) {
        
    }
		
		//Sobrecarga de la función toString.
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ") " + this.text;
    }
		
		//Validación de que las coordenadas sean válidas, es decir, sean numeros entre parentesis.
    public static boolean isValidCoords(String pair) {
        boolean pass = true;
        String numbers[] = pair.split(",");
        if (numbers.length != 2) {
            return false;
        } else {
            for (String number : numbers) {
                try {
                    Integer.parseInt(number);
                }catch (NumberFormatException e) {
                    pass = false;
                }
            }
        }
        return pass;
    }
		
		//Convertir coordenadas a enteros.
    public static int[] setCoords(String pair) {
        String numbers[] = pair.split(",");
        int[] coords = new int[2];
        
        for (int i = 0; i < 2; i++) {
            coords[i] = Integer.parseInt(numbers[i]);
        }
        return coords;
    }
}
