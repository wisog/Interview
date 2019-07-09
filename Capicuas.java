import java.util.Scanner;

public class Capicuas{

    static String d;

    public static void main(String[] args) {
        d = getData();
        capicua();
    }

    public static String getData(){
        Scanner lector = new Scanner(System.in);
        String data = lector.nextLine();
        lector.close();
        return data;
    }

    public static long inverso(){
        String inv="";
        for (int i = d.length()-1; i >= 0; i--) {
            inv+=d.charAt(i);
        }
        return Long.valueOf(inv);
    }

    public static void suma(){
        long c = Long.valueOf(d);
        long c2 = inverso();
        long res = c + c2;
        d = Long.toString(res);
    }

    public static boolean validar(){
        for(int i = 0; i < d.length(); i++){
            if (d.charAt(i) == d.charAt(d.length()-i-1)) {
                
            } else {
                return true;
            }
        }
        return false;
    }

    public static void capicua(){
        boolean flag=true;
        int c = 0;
        while (flag){
            
            flag = validar();
            if(flag){
                suma();
                c++;
            }
        }
        System.out.println(d + " " + c);
    }
}