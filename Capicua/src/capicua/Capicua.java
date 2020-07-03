package capicua;

import java.util.Scanner;

/**
 *
 * @author gumaro
 */
public class Capicua {

    public static void main(String[] args) {
        //Declaracion de objetos
        Capicua obj = new Capicua();
        Scanner read = new Scanner(System.in);
        //variable para calcualar el numero
        int number;

        //leemos el numero 
        System.out.println("Dame numero a calcular");
        number = read.nextInt();
        //llamamos el metodo Calculate, primer parametro el numero y como segundo el contador
        obj.Calculate(number, 1);
    }

    public void Calculate(long num, int count) {
        //invertimos el numero que se introdujo por el usuario
        Long num_vol = invest(num);
        //sumamos los numeros para ver si es capicua
        String res = Long.toString(num_vol + num);
        //invertimos la sumar de los numeros para compararlo 
        String resV = Long.toString(invest(num + num_vol));
        //validamos con el metodo  test si retorna un tue se imprime 
        if (test(res, resV)) {

            System.out.println(res + " " + count);
        } else {
            //si no se cumple se aumenta el contador y se manda llamar al metoo Calculate
            count++;
            Calculate(Long.parseLong(res), count);
        }
    }

    //metodo para invertir el numero 
    public long invest(long num) {
        String valor = Long.toString(num), aux = "";
        for (int i = valor.length() - 1; i >= 0; i--) {
            aux += valor.charAt(i);
        }
        return Long.parseLong(aux);
    }

    //metodo para comparar si el numero capicua y su inverso son iguales
    public boolean test(String a, String b) {
        if (a.equals(b)) {
            return true;
        }
        return false;
    }
}
