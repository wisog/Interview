/* Editor que realiza un análisis léxico sobre una cadena de caracteres*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Token {

    // coordenadas encontradas en el texto
    private String coordenada;
    //posición actual
    private int i;
    //estado actual
    private int estado;
    // Se analizará carácter por carácter el String fuente. 'caracter'
    // representará el simbolo.
    private char caracter;
    //lista de caracteres fuente del análisis.
    private LinkedList<Character> listaC = new LinkedList<>();
    //lista completa de posibles coordenadas encontradas en el linkedList listaC
    private final LinkedList<String> analizadorLexico = new LinkedList<>();
    //contiene las coordenadas encontradas y ordenadas de manera correcta
    private final ArrayList<String> listaToken = new ArrayList<>();

    /**
     * Inicia el proceso de análisis. Inicia los valores que corresponden a cada
     * atributo.
     *
     * @param caracter
     */
    public Token(LinkedList<Character> caracter) {
        listaC = caracter;
        coordenada = "";
        i = 0;
        estado = 0;
        analizadorLexico.clear();
        listaToken.clear();
        //(79,34)Holaafklndfoi(10asldkfj)(98,902843)lnkjasdlnkfjas(34,56)Bingopingolingo
    }

    /**
     * Método que verifica si la cadena es valida, es decir, sí comienza con
     * coordenada, sí inicia con coordenada, invoca al metodo principal de
     * verificación de tokens de lo contrario envia un mensaje de formato
     * incorrecto y termina el programa
     */
    public void analizarCadena() {
        if (listaC.getFirst().equals('(') && Character.isDigit(listaC.get(1))) {
            obtenerCoordenadas();
        } else {
            System.out.println("Formato incorrecto");
        }
    }

    /**
     * Método principal del proceso de verificación de tokens, cambia de estados
     * dependiendo del caracter encontrado, en el estado '(' no cambia de estado
     * con los caracteres que son digito; los toma como signos de aceptación
     * (unicamente los agrega al listado de coordenadas). El cambio de estado se
     * realiza cuando en el estado '(' aparecen caracteres que no son digitos.
     */
    public void obtenerCoordenadas() {
        /**
         * indice y contador que nos serviran para ordenar las coordenadas y
         * mostrarlas en formato correcto
         */
        int indice, cont = 0;
        for (i = 0; i < listaC.size(); i++) {
            caracter = listaC.get(i);
            switch (caracter) {
                case '(':
                    /**
                     * Estado '(', inicia cuando se encuentra un parentisis que
                     * abre.
                     */
                    coordenada += caracter;
                    estado = 0;
                    i++;
                    esDigito(i);
                    break;
                case ',':
                    /**
                     * Estado ',', inicia cuando se encuentra una coma.
                     */
                    coordenada += caracter;
                    i++;
                    estado = 0;
                    esDigito(i);
                    break;
                case ')':
                    /**
                     * Estado ')', inicia cuando se encuentra un parentisis que
                     * cierra.
                     */
                    coordenada += caracter + " ";
                    i++;
                    estado = 0;
                    esAlfanumerico(i);
                    break;
            }
        }

        /**
         * obtenemos una posible coordenadas cada vez que encontramos un salto
         * de linea.
         */
        String[] coordenadasP = coordenada.split("\n");
        analizadorLexico.clear();
        /**
         * En este caso el salto de linea("\n") queda eliminado, copiamos el
         * array de coordenadas en la lista analizadorLexico
         */
        analizadorLexico.addAll(Arrays.asList(coordenadasP));
        /**
         * Buscamos en el linkedlist los puntos que no contienen coordenada, los
         * concatenamos al punto que pertenecen, lo agregamos a la lista que
         * contiene los tokens en formato correcto y eliminamos el punto ya
         * concatenado
         */
        for (int lf = 0; lf < analizadorLexico.size(); lf++) {
            if (!analizadorLexico.get(lf).contains(",")) {
                listaToken.add(analizadorLexico.get(lf - 1) + analizadorLexico.get(lf));
                indice = (lf - 1) - cont;
                if (indice != -1) {
                    listaToken.remove(indice);
                    cont++;
                } else {
                    System.out.println("no se elimino el indice " + indice);
                }
            } else {
                listaToken.add(analizadorLexico.get(lf));
            }
        }
        /**
         * Verificamos que existan minimo tres coordenadas e imprimimos en
         * consola las coordenadas y su respectivo punto separados por un
         * espacio en blanco, de lo contrario mandamos un mensaje de formato
         * incorrecto al usuario.
         */
        if (listaToken.size() < 3) {
            System.out.println("Debe ingresar tres coordenadas o mas");
        } else {
            listaToken.forEach((analizador) -> {
                System.out.println(analizador + " ");
            });
        }

    }

    /**
     * Llamado cuando se encuentra un caracter alfanúmerico despúes de un
     * parentisis que cierra. Se llama el mismo hasta que encuentra un caracter
     * limitador. Los caracteres limitadores son todos los caracteres diferentes
     * a: números, letras, '('y')'
     *
     * @param x
     */
    public void esAlfanumerico(int x) {
        for (int j = x; j < listaC.size(); j++) {
            caracter = listaC.get(j);
            switch (estado) {
                case 0:
                    if (Character.isDigit(caracter)) {
                        coordenada += caracter;
                        estado = 0;
                    } else if (Character.isLetter(caracter)) {
                        coordenada += caracter;
                        estado = 0;
                    } else if (caracter == '(') {
                        coordenada += "\n" + caracter;
                        estado = 0;
                    } else if (caracter == ')') {
                        coordenada += caracter;
                        estado = 0;
                        analizadorLexico.add(coordenada);
                        //coordenada="";
                    } else {
                        estado = 1;
                        i = j - 1;
                    }
                    break;
            }
        }
    }

    /**
     * Llamado cuando se encuentra un caracter númerico. Se llama el mismo hasta
     * que encuentra un caracter limitador. Los caracteres limitadores son todos
     * los caracteres que no son números.
     * @param x
     */
    public void esDigito(int x) {
        for (int j = x; j < listaC.size(); j++) {
            caracter = listaC.get(j);
            switch (estado) {
                case 0:
                    if (Character.isDigit(caracter)) {
                        coordenada += caracter;
                        estado = 0;
                    } else {
                        estado = 1;
                        i = j - 1;
                    }
                    break;
            }
        }
    }
}
