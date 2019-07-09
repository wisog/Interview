import java.util.Scanner;
public class AnalizadorLexico{

    public static void main(String[] args) {
        String d = getData();    
        lexico(d);
    }

    public static String getData(){
        Scanner lector = new Scanner(System.in);
        String data = lector.nextLine();
        lector.close();
        return data;
    }

    public static boolean limite(int i, int length){
        if (i == length){
            return false;
        }
        return true;
    }
    //(1,1)a(1,1)b(1,1)c

    public static void lexico(String d){
        String cadena [] = new String[3];
        String aux;
        boolean flag=true;
        //(79,34)Holaaasddfdsf(10asdsad)(98,902843)inkdfdsfds(34,56)Bingopingolingo
        int i=0, length = d.length(), c=0,i2;
        while(flag){
            if(d.charAt(i) == '('){
                cadena[c]=Character.toString(d.charAt(i));
                i++;
                flag = limite(i,length);
                while(flag && (d.charAt(i) == '1' || d.charAt(i) == '2' || d.charAt(i) == '3' || d.charAt(i) == '4' || d.charAt(i) == '5' || d.charAt(i) == '6' || d.charAt(i) == '7' || d.charAt(i) == '8' || d.charAt(i) == '9' || d.charAt(i) == '0')){
                    cadena[c]+=d.charAt(i);
                    i++;
                    flag = limite(i,length);
                    if(flag && (d.charAt(i) == ',')){
                        cadena[c]+=d.charAt(i);
                        i++;
                        flag = limite(i,length);
                        while(flag && (d.charAt(i) == '1' || d.charAt(i) == '2' || d.charAt(i) == '3' || d.charAt(i) == '4' || d.charAt(i) == '5' || d.charAt(i) == '6' || d.charAt(i) == '7' || d.charAt(i) == '8' || d.charAt(i) == '9' || d.charAt(i) == '0')){
                            cadena[c]+=d.charAt(i);
                            i++;
                            flag = limite(i,length);
                           if(flag && (d.charAt(i) == ')')){
                               cadena[c]+=d.charAt(i);
                               cadena[c]+=" ";
                               i++;
                               flag = limite(i,length);
                               while(flag && (d.charAt(i) != '(' )){
                                cadena[c]+=d.charAt(i);
                                i++;
                                flag = limite(i,length);
                                if(flag && (d.charAt(i) == '(')){
                                    i2=i;
                                    aux="(";
                                    i2++;
                                    flag = limite(i2,length);
                                    while(flag && (d.charAt(i2) == '1' || d.charAt(i2) == '2' || d.charAt(i2) == '3' || d.charAt(i2) == '4' || d.charAt(i2) == '5' || d.charAt(i2) == '6' || d.charAt(i2) == '7' || d.charAt(i2) == '8' || d.charAt(i2) == '9' || d.charAt(i2) == '0')){
                                        aux+=d.charAt(i2);
                                        i2++;
                                        flag = limite(i2,length);                                    
                                    }

                                    if(flag && (d.charAt(i2) == ',')){
                                        aux+=d.charAt(i2);
                                        i2++;
                                        flag = limite(i2,length);
                                    } else{
                                        //cadena[c]+=aux;
                                        i=i2;
                                    }
                                    while(flag && (d.charAt(i2) == '1' || d.charAt(i2) == '2' || d.charAt(i2) == '3' || d.charAt(i2) == '4' || d.charAt(i2) == '5' || d.charAt(i2) == '6' || d.charAt(i2) == '7' || d.charAt(i2) == '8' || d.charAt(i2) == '9' || d.charAt(i2) == '0')){
                                        aux+=d.charAt(i2);
                                        i2++;
                                        flag = limite(i2,length);                                    
                                    }
                                    if(flag && (d.charAt(i2) == ')')){
                                        aux+=d.charAt(i2);
                                        i2++;
                                        flag = limite(i2,length);
                                    } else{
                                        //cadena[c]+=aux;
                                        i=i2;
                                    }
                               }
                               
                           }
                        }
                    }
                }
             }
            }
            c++;
        }

        System.out.println(cadena[0]);
        System.out.println(cadena[1]);
        System.out.println(cadena[2]);
    }

}