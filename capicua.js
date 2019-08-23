
class Capicua {
    constructor (){
    }
    static Inversor(x){//Funcion utilizada para obtener un numero deseado a la inversa
        var len = String(x).length;
        var invertido = "";
        while(len >= 0){
            invertido = invertido + String(x).charAt(len);
            len--;
        }
        return invertido;
    } 
    static Revision(x){//Funcion que revisa si un numero se lee igual al derecho que al reves
        let inicio = 0;//apuntador para el caracter inferior
        let final = String(x).length-1;//apuntador para el caracter superior
        let bandera = true;
        let medio = Math.ceil(String(x).length/2);
        for(let i=0; i< medio; i++ ){//Solo se hace el for hasta la mitad de la cadena, ya que no se necesita más
            if(String(x).charAt(inicio) == String(x).charAt(final)){//se comparan los caracteres
                inicio++;
                final--;
            }
            else{
                bandera = false;//se modifica la bandera y se rompe el ciclo en caso de no ser iguales los caracteres
                break;
            }
        }
        return bandera;
    }
    static EncontrarCapicua(nc){
        let i = 0;//se inicia un contador
        let capicua = nc;
        let bandera = true;//bandera para salir del ciclo una vez encontrado el capicua
        while(bandera){
            capicua = parseInt(capicua) + parseInt(Capicua.Inversor(String(capicua)));//se suma el numero con su inverso
            if(Capicua.Revision(String(capicua))){//si el resultado es capicua, se rompe el ciclo
                bandera = false;
            }
            i++;
        }
        var Resultado = new Object();
        Resultado.NC = capicua;//se guarda el capicua y las iteraciones en un objeto y se regresan
        Resultado.iteraciones = i;
        return Resultado;
    }
}


let entrada = process.argv[2];//se adquiere el numero parametro
let resultado = Capicua.EncontrarCapicua(entrada);//se guardan los resultados en una variable
console.log(resultado.NC+" "+resultado.iteraciones);//impresion de los resultados
