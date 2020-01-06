function Splitmultiple(texto_completo, array_textos) {
    // funcion creada por la necesidad de un split que funcione con arreglos(con textos) y no un solo texto
    var textos_resultante = [];
    var x; //variable de ayuda
    for (var array_texto in array_textos) {
        // De todo un texto se ira dividiendo a partir de diferentes textos
        // y estas divisiones se iran guardando en un arreglo
        x = texto_completo.split(array_textos[array_texto]);
        textos_resultante.push(x[0]);
        texto_completo = x[1];
        if ((array_textos.length - 1) == array_texto) {
            // la resultante ultima se toma asi al no tener esta una coordenada
            // y tambien por que el primer valor de textpos_resultantes no es valor valido para una coordenada
            textos_resultante.push(texto_completo);
        }
    }
    return textos_resultante;
}