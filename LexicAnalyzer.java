import java.util.Scanner;

public class LexicAnalyzer {

    public static void main(String[] args) {

        String text = "";
        char chars;
        Scanner read = new Scanner(System.in);
        //1.-Do while que permite corroborar que se ingrese una cadena menor a 250 carácteres.
        do {
            
            System.out.println("Escribe la cadena a analizar (solo 250 carácteres por cadena): ");
            //Lee la cadena y almacena.
            text = read.nextLine();
            //Analiza que no sean más de 250 carácteres la cadena.
            if (text.length() > 250) {
                //De ser mayor manda un mensaje y el ciclo repite la operación de lectura de cadena.
                System.err.println("Cadena mayor a 250 carácteres.");
                System.out.println("Reingrese el texto.");
            } else {
                //De no ser mayor, envía la cadena al método strProcedure y acaba con el ciclo.
                strProcedure(text);
                break;
            }
        } while (true);

    }

    public static boolean isCoordenade(String var) {
        /*En ésta parte extrae las posiciones de los paréntesis de la expresión obtenida del
        método strProcedure, para evaluar el texto dentro*/
        int n = var.indexOf('(');

        int m = var.indexOf(')', n);
        
        //Aquí busca si hay o no una coma, que es lo que identifica a una coordenada
        //Pero si hubiera una coma dentro sin números no lo sería.
        int a = var.indexOf(',');
        //Por lo tanto evalúa el indíce de ésta coma para corroborar, primeramente si existe
        if (a > 1) {
            /*Si existe la coma, evalúa los términos que están antes y despues de ella
            si logra realizar éste fragmento del código, es que ambos son numéricos
            y por lo tanto son coordenadas, con cualquiera que no lo sea, pasa
            directo al catch*/
            try {
                int one = Integer.parseInt(var.substring(n + 1, a));
                int two = Integer.parseInt(var.substring(a + 1, m));
                /*Envía un true a strProcedure, indicando que son coordenadas*/
                return true;

            } catch (Exception e) {
                /*si entra a éste catch, es que alguno de los dos términos, o ambos, no fueron
                números, lo que significa que no son coordenadas, enviando un false.*/
                return false;

            }
        } else {
            /*Si el index de la coma, o sea la variable a, es mayor a 1, significa que no es
            ni -1, indicando que no hay tal coma entre los paréntesis analizados, y tampoco es 1, 
            lo que implicaría que está en la posición inmediatamente desúés del paréntesis, 
            por lo que no sería coordenada. Envía éste false a strProcedure*/
            return false;
        }
    }

    public static void strProcedure(String text) {
        String st = "", nwst = "", nwtxt = text;
        int x;
        //La variable flat nos ayudará a identificar coordenadas antes de texto
        //Se explica más adelante.
        boolean b, flat = true;
        //For que analiza la cadena para detectar coordenadas o texto.
        for (int i = 0; i < text.length(); i++) {
            /*Si el primer caractér en la posición i es un paréntesis
            entonces entra*/
            if (text.charAt(i) == '(') {
                /*Busca el correspondiente paréntesis que cierra*/
                x = text.indexOf(')', i);
                /*crea una sub cadena con lo que hay dentro de los paréntesis y la encierra
                en la variable nwst, ejemplo: (<cadena dentro>)*/
                nwst = text.substring(i, x + 1);
                
                /*Aquí la bandera nos dice si se está analizando una subcadena
                entre paréntesis, luego de haber impreso unas coordenadas con
                su texto correspondiente anteriormente, o si es la primera vez que evalúa.*/
                if (flat) {
                    
                    /*Si entró a éste punto,deja el valor almacenado en nwst
                    e iguala i a x, para continúar analizando desde ese punto.
                    */
                    i = x;
                    
                    /*Como ya entró una vez, la bandera ya es false, será true
                    hasta que imprima una coordenada con su respectivo texto
                    */
                    flat = false;

                } else {
                    /*Si entró a éste punto, significa que no es la primera vez que analiza
                    una cadena encerrada entre paréntesis, por lo que debe identificar si
                    son o no coordenadas, con lo cuál envía al método isoordenade
                    (Véase el método isCoordenade)*/
                    
                    b = isCoordenade(nwst);
                    if (b) {
                        /*si b es verdadera, es que son coordenadas, por lo que lo que
                        está inmediatemente antes de ello se publica, que es
                        la cadena encerrada entre paréntesis en nwst, y el texto 
                        que analizó en else*/
                        
                        System.out.println(st);
                        st = "";
                        flat = true;
                        
                        /*Disminuye el valor de i, para comenzar desde el caracter siguiente
                        a lo último impreso*/
                        i--;

                    } else {
                        /*Si no es coordenada, se adjunta al texto analizado en else, para
                        continuar evaluando la expresión*/
                        
                        st += nwst;

                        i = x;
                    }
                }
            } else {
                /*aquí analiza todo lo que está después de una cadena encerrada entre
                paréntesis, por ejemplo texto*/
                try {
                    /*trata de encontrar un paréntesis que abre después del texto*/
                    x = text.indexOf('(', i);
                    
                    //Si lo encuentra, aísla el texto antes de ése paréntesis y lo agrega para
                    //su seguir procesando lo siguiente.
                    st += nwst + " " + text.substring(i, x);
                    
                    /*Aquí resta 1 a x e iguala a i, para que i comience a partir
                    de donde encontro el paréntesis en la próxima vuelta y evalúe*/
                    i = x - 1;

                } catch (Exception e) {
                    /*De no encontrar un paréntesis, implica que la cadena acabó, y todo lo demás
                    será texto, así que adjunta al string st e imprime
                    */
                    st += nwst + " " + text.substring(i);
                    System.out.println(st);
                    break;

                }

            }
        }
    }

}
