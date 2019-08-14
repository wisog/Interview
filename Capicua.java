package capicua;

import java.util.Scanner;

public class Capicua {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int num, aux, aux2, count = 0;
        int res;
        System.out.println("Capicuas");
        System.out.println("");
        //Input a number
        System.out.print("Introduce un numero: ");
        num = read.nextInt();
        int resinv;
        do {
            int ninv = 0;
            aux = num;
            //Invert the input number
            while (aux != 0) {
                aux2 = aux % 10;
                ninv = ninv * 10 + aux2;
                aux = aux / 10;
            }
            res = num + ninv;
            resinv = 0;
            aux = res;
            //Invert total
            while (aux != 0) {
                aux2 = aux % 10;
                resinv = resinv * 10 + aux2;
                aux = aux / 10;
            }
            num = res;
            //contador
            count++;
        } while (res != resinv);
        //Result
        System.out.println(res + " " + count);

    }

}
