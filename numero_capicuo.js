var ok=0;
var n=0;
var numero = process.argv[2];
var digitos=[];
var suma=0,tsum=0,temp=0;
var dig_cap=[];
do{
    if(n === 0)
        {

            numero = parseInt(numero);//recuperamos el numero escrito
        }
    else{
        numero = tsum;//se recupera una suma anterior
    }
    temp=numero;

    do{//Aqui se usara como cola para sacar digito por digito
        digitos.push(numero%10);
        numero= (numero - (numero%10))/10;
    }while(numero != 0);
    var cap='';
    for(var i = 0; i < digitos.length; i++)
        {
            cap+=digitos[i];//se ingresa cada digito, esto es el capicuo del que se 
        }                   //escribio
    suma = temp + parseInt(cap);
    tsum=suma;
    do{
        dig_cap.push(suma%10);
        suma= (suma - (suma%10))/10;//se sacan los digitos para luego checar si son iguales
    }while(suma != 0);
    var mn=0;
    for(var i =0;i < dig_cap.length; i++)
        {
            if(dig_cap[i] == dig_cap[(dig_cap.length-1)-i])
                {               //aumenta un contador por cada casilla que cumpla con su contraria
                    mn+=1;
                }
        }
    if(mn==dig_cap.length)//si es igual se sale, ya que es capicuo
        {
            ok=1;
        }
    n+=1;
    digitos=[];
    dig_cap=[];
}while(ok != 1);//hara todo el procedimiento hasta hallar el capicuo
console.log(tsum+" "+n);