public class Capicuas {

    //cantidad de iteraciones necesarias
    public int n = 0;

    public void ObtenerNumCapicua(long num) {
        long N, NC = 0, cifra;

        /*
            Obtenemos el inverso (NC) del número original de la siguiente manera:
                1.- Obtenemos la ultima cifra del número ingresado,
                2.- Se lo sumamos al contenido de NC multiplicado por 10,
                3.- Quitamos la ultima cifra,
                4.- Repetimos el proceso hasta que N = 0.
         */
        N = num;
        while (N != 0) {
            cifra = N % 10;
            NC = cifra + (NC * 10);
            N = N / 10;
        }

        /*
            Verificamos si el número invertido (NC) es igual al número que ingresó el usuario,
            Si ambos números coinciden entonces mostramos en pantalla 
            el primer NC encontrado y n la cantidad de iteraciones necesarias para obtener el NC
            Si no es igual hacemos lo siguiente:
                1.- Iniciamos el iterador,
                2.- De manera recursiva repetimos el proceso hasta obtener el número capicúa.
         */
        if (NC == num) {
            System.out.println(NC + " " + n);
        } else {
            n++;
            ObtenerNumCapicua(num + NC);
        }
    }
}
