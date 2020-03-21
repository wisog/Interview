/*
 Analizador léxico
*/
var entrada = '(92,32)Holadfweewf(9332423,32)gyudguydsg(94544654,32)asduhsuydg';

function dividirCadena(entrada) {
    var arrayCadena = entrada.split('(', 4);
    arrayCadena.splice(0, 1);
    for (var i = 0, arrayCaden = arrayCadena; i < arrayCadena.length; i++) {
        var array = `${arrayCaden[i]}`;
        var arr = `(${array}`;
        console.log(arr);
    }
}
dividirCadena(entrada);