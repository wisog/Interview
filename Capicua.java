import java.util.Scanner;

public class Capicua {

    public static void main(String[] args) {
        int num, count = 0;
        //1.-inicializamos la variable de lectura de teclado.
        Scanner read = new Scanner(System.in);
        //2.-El usuario ingresa una cifra cu�l sea.
        System.out.println("Ingresa un n�mero: ");
        num = read.nextInt();
        /*3.-Envi�mos la cifra y un contador para determinar el n�mero
         de repeticiones.*/
        capicua1(num, count);

    }

    public static void capicua1(long num, int count) {
        //4.-Cuenta la primera vuelta.
        count++;

        long n, res;
        /*5.-Enviamos la cifra ingresada al m�todo inversor
         (v�ase el m�todo inversor)*/
        n = inversor(num);
        /*11.-Ya obtenido el valor invertido y almacenado en n, procedemos a sumar ambos
         n�meros
         */
        res = n + num;
        /*12.-En �sta evaluaci�n, se env�a a el resultado de la suma al m�todo test
         para obtener un resultado booleano (v�ase m�todo test)*/
        if (test(res)) {
            //17.1.- Se imprime el valor y el n�mero de repeticiones de ser capicuo.
            System.out.println(res + " " + count);
        } else {
            /*17.2.-Se reenv�a el n�mero resultante a �ste mismo m+etodo (m�todo capicua
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
        //7.-For que invertir� los car�cteres de la cifra.
        for (int i = n1.length() - 1; i >= 0; i--) {
            //8.-String n2 almacena el n�mero invertido.
            n2 += n1.charAt(i);
        }
        /*9.-Convertimos de String a long para poder realizar la comparaci�n
         en el m�todo capicua*/
        n = Long.parseLong(n2);
        //10.-Env�a el n�mero invertido a m�todo capicua nuevamente (v�ase m�todo capicua).
        return n;
    }

    public static boolean test(long num) {
        boolean b;
        long num2;
        String nwn = "";
        //13.-Guarda el resultado enviado de la suma en el m�todo capicua en String num1.
        String num1 = String.valueOf(num);
        /*Comienza el proceso de inversi�n del resultado, que almacenar� en la
         variable String nwn*/
        for (int i = num1.length() - 1; i >= 0; i--) {
            nwn += num1.charAt(i);
        }
        //14.-Convierte el valor de nwn a formato Long para realizar la comparaci�n.
        num2 = Long.parseLong(nwn);
        //15.- compara ambos n�meros para saber si es capicuo o no.
        if (num2 == num) {
            //16.1.-Env�a un valor verdadero a m�todo capicua si lo es. V�ase m�todo capicua.
            return true;
        } else {
            //16.2.- Env�a un valor falso a m�todo capicua si no lo es. V�ase m�todo capicua.
            return false;
        }
    }
}
