'use strict';

let num = parseInt(process.argv.slice(2)[0]); //número ingresado
let inv; // número invertido
let capicua = false; //saber si ya se llegó al capicua

//función para invertir el número
function alreves(n){
    return parseInt(n.toString().split('').reverse().join(''));
}

//ciclo en donde se verificará si es capicua por medio de la suma de el original con el invertido
for (let i = 1; !capicua; i++) {
    inv = alreves(num); //manda a llmar funcion de invertir número
    if ((num + inv).toString() === (alreves(num + inv)).toString()) { //si son iguales las suma de los dos números es capicua
        console.log(num + inv, i); //imprimimos la suma y las iteraciones
        capicua = true;
    }
    else {
        num = num + inv;
    }
}