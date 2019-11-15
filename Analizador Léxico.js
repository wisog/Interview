var Analyzer = {
    mainString: "",
    indexes: [], //Utilizando un array y ciclos puedo procesar una cantidad n de líneas en lugar de sólo 3 
    getIndexes: function() { //Esta función divide la cadena y guarda los índices de las líneas para imprimirlas psoteriormente
        let pattern = /\(\d+,\d+\)/g; //Con esta Expresión Regular logro diferenciar el formato de las coordenadas del resto de la cadena
        let mainLength = Analyzer.mainString.length, i = 0;
        try {
            if(mainLength>250) //Lanza un error si la cadena excede 250 caracteres
                throw Error();
            while((coord = pattern.exec(Analyzer.mainString)) !== null) { //Recorro todas las coincidencias de "coordenadas" dentro de la cadena
                let coordStart = coord.index;
                let coordEnd = (coord.index+coord[0].length);
                Analyzer.indexes.push({ coordStart, coordEnd, lineEnd: mainLength }); //Guardo los índices de donde empiezan y acaban las coordenadas y el texto de cada línea 
                if(i > 0) Analyzer.indexes[i-1].lineEnd = coordStart; //Para ahorrar ciclos asigno el final de la línea anterior como el inicio de la coordenada nueva
                i++;
            } 
        } catch(error) { //Si no se procesa correctamente la cadena, se pide que ingrese otra
            Analyzer.getString("Formato no válido, ingresa otra cadena.");
        }  
    },
    printOutput: function() { //Esta función imprime la cadena procesada con base en los índices previamente obtenidos
        console.log("Cadena: "+Analyzer.mainString);
        Analyzer.indexes.forEach(element => { //Recorro todas las líneas obtenidas 
            let coord = Analyzer.mainString.substring(element.coordStart, element.coordEnd); //Obtengo y guardo las coordenadas
            let line = Analyzer.mainString.substring(element.coordEnd, element.lineEnd); //Obtengo y guardo el texto
            console.log(coord+" "+line+"\n"); //Imprimo todo con el formato especificado
        });
    },
    getString: function(promptText) {
        Analyzer.mainString = prompt(promptText); //Pido al usuario que ingrese la cadena
        Analyzer.getIndexes(); //Proceso la cadena
        Analyzer.printOutput(); //Imprimo el resultado
    }
}

Analyzer.getString("Ingrese una cadena con el formato '(x1,y1)texto1(x2,y2)texto2(x3,y3)texto3'");