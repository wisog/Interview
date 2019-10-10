import java.util.Scanner;

public class Capicua {

    public static void main(String[] args) {
        int num, count = 0;
        //1.-inicializamos la variable de lectura de teclado.
        Scanner read = new Scanner(System.in);
        //2.-El usuario ingresa una cifra cuál sea.
        System.out.println("Ingresa un número: ");
        num = read.nextInt();
        /*3.-Enviámos la cifra y un contador para determinar el número
         de repeticiones.*/
        capicua1(num, count);

    }

    public static void capicua1(long num, int count) {
        //4.-Cuenta la primera vuelta.
        count++;

        long n, res;
        /*5.-Enviamos la cifra ingresada al método inversor
         (véase el método inversor)*/
        n = inversor(num);
        /*11.-Ya obtenido el valor invertido y almacenado en n, procedemos a sumar ambos
         números
         */
        res = n + num;
        /*12.-En ésta evaluación, se envía a el resultado de la suma al método test
         para obtener un resultado booleano (véase método test)*/
        if (test(res)) {
            //17.1.- Se imprime el valor y el número de repeticiones de ser capicuo.
            System.out.println(res + " " + count);
        } else {
            /*17.2.-Se reenvía el número resultante a éste mismo m+etodo (método capicua
             para hacer el proceso, junto con el contador que lleva el registro de repeticiones
             hechas.)*/
            capicua1(res, count);
        }
    }

    public static long inversor(long num) {
        long n = 0;
        String n1 = "", n2 = "";
        //6.-Ingresamos la cifra ingresada por el usuarui a otra variable para invertirla.
        n1 = String.valueOf(num);
        //7.-For que invertirá los carácteres de la cifra.
        for (int i = n1.length() - 1; i >= 0; i--) {
            //8.-String n2 almacena el número invertido.
            n2 += n1.charAt(i);
        }
        /*9.-Convertimos de String a long para poder realizar la comparación
         en el método capicua*/
        n = Long.parseLong(n2);
        //10.-Envía el número invertido a método capicua nuevamente (véase método capicua).
        return n;
    }

    public static boolean test(long num) {
        boolean b;
        long num2;
        String nwn = "";
        //13.-Guarda el resultado enviado de la suma en el método capicua en String num1.
        String num1 = String.valueOf(num);
        /*Comienza el proceso de inversión del resultado, que almacenará en la
         variable String nwn*/
        for (int i = num1.length() - 1; i >= 0; i--) {
            nwn += num1.charAt(i);
        }
        //14.-Convierte el valor de nwn a formato Long para realizar la comparación.
        num2 = Long.parseLong(nwn);
        //15.- compara ambos números para saber si es capicuo o no.
        if (num2 == num) {
            //16.1.-Envía un valor verdadero a método capicua si lo es. Véase método capicua.
            return true;
        } else {
            //16.2.- Envía un valor falso a método capicua si no lo es. Véase método capicua.
            return false;
        }
    }
}
