//Expresion Regular /\d{1,},\d{1,}/
function analizador() {
    let cad1, cad2, cad3, restante, aux = 1;
    let cadena = prompt("Ingrese la cadena").toString();
    let q = cadena.match(/\(\d{1,},\d{1,}\)/);
    let eval = [];
    let idx = obtenerIndices(cadena);
    let extraida = cadena.substring(0, idx[aux]);
    cad1 = extraida;
    while (aux < idx.length) {
        extraida = cadena.substring(idx[aux], idx[aux + 1]);
        eval = evaluarExpresion(extraida);
        if (eval == null) {
            aux++;
            cad1 = cad1 + extraida;
        } else {
            eval = [];
            break;
        }
    }
    extraida = cadena.substring(idx[aux], idx[aux + 1]);
    cad2 = extraida;
    aux++;
    while (aux < idx.length) {
        extraida = cadena.substring(idx[aux], idx[aux + 1]);
        eval = evaluarExpresion(extraida);
        if (eval == null) {
            aux++;
            cad2 = cad2 + extraida;
        } else {
            break;
        }
    }
    extraida = cadena.substring(idx[aux], idx[aux + 1]);
    cad3 = extraida;
    console.log(cad1);
    console.log(cad2);
    console.log(cad3);
}

function evaluarExpresion(cadena) {
    let cad1, cad2, cad3, restante;
    let q = cadena.match(/^\(\d{1,},\d{1,}\)/);
    return q;
}

function obtenerIndices(cadena) {
    let indice = cadena.indexOf("(");
    let arrayIdx = [];
    while (indice != -1) {
        arrayIdx.push(indice);
        indice = cadena.indexOf("(", indice + 1);
    }
    return arrayIdx;
}