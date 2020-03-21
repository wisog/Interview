/*
Ejercicio Capicúas 
*/
var num_iteracion = 23; /*Cambiar el numero de iteraciones a repetir*/
var entrada = '187'; /*Cambiar el numero de entrada */
var entrada_inv = '';
var resultado;
var bandera = 1;


function invertir(entrada) {
    while (bandera <= num_iteracion) {
        entrada_inv = entrada.split("").reverse().join("");
        resultado = parseInt(entrada_inv) + parseInt(entrada);
        entrada = resultado.toString();
        bandera++
    }
    console.log(`${entrada} ${num_iteracion}`);
}


invertir(entrada);