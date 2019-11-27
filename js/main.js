function capiculas() {
    let num = prompt("Ingrese un numero entre 9 y 10000");
    validarNumero(num);
}

function validarNumero(numero) {
    if (numero > 9 && numero < 10000) {
        console.log("Numero correcto");
        buscarCapicula(numero);
    } else {
        console.log("Numero no valido");
    }
}

function buscarCapicula(numCorrecto) {
    let arr1 = [],
        arr2 = [];
    let v1, v2, v3, iteracion = 1;
    let valor = numCorrecto;
    let ejecuta = true;
    while (ejecuta) {
        v3 = calculoCapicula(valor);
        valor = v3;
        arr1 = valor.toString().split('');
        arr2 = valor.toString().split('');
        arr2 = arr2.reverse();
        v1 = arr1.join('');
        v2 = arr2.join('');
        if (v1 == v2) {
            ejecuta = false;
        } else {
            iteracion++;
            valor = valor.toString();
        }
    }
    console.log(v1, iteracion);
}

function calculoCapicula(num) {
    arr1 = num.split('');
    arr2 = num.split('');
    arr2 = arr2.reverse();
    v1 = arr1.join('');
    v2 = arr2.join('');
    v3 = parseInt(v1) + parseInt(v2);
    return v3;
}