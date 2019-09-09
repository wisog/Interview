import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Introduce un número entero mayor o igual a 10: ");
            N = sc.nextInt();
        } while (N < 10);

        Capicuas cap = new Capicuas();
        cap.ObtenerNumCapicua(N);

    }

}