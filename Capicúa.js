var Capicua = {
    capicuaNum: 0,
    iterations: 0,
    isCapicua: function(num) { //Con este método reviso si el número es una Capicúa o no
        let numStr = num.toString();
        let numHalf = Math.floor(numStr.length/2);//Redondeando ignoro el número de en medio en caso de ser impar
        let firstHalf = numStr.slice(0, numHalf);
        let secondHalf = numStr.slice(-numHalf);
        let newHalf = Capicua.flipNumber(secondHalf).toString();
        return firstHalf===newHalf;
    },
    flipNumber: function(num) { //Este método me regresa el mismo número que ingrese pero invertido
        let numStr = num.toString();
        let flipped = "";
        for(let digit of numStr) //Recorro los dígitos del número
            flipped = digit + flipped; //Guardo los dígitos en orden inverso
        return parseInt(flipped);
    },
    calculate: function(num) { //Con un bucle repito las iteraciones hasta conseguir una Capicúa
        let suma = parseInt(num);
        let iteration = 0;
        do { //Realizo la suma de los números e incremento el número de iteraciones hasta que el resultado sea una Capicúa
            suma = suma + Capicua.flipNumber(suma);
            iteration++;
        } while(!Capicua.isCapicua(suma))
        Capicua.capicuaNum = suma;
        Capicua.iterations = iteration;
    },
    printOutput: function() { //Imprimo el resultado solicitado
        console.log(Capicua.capicuaNum + "  " +Capicua.iterations );
    },
    getNumber: function(promptText) { //Pide el número y revisa que sea válido
        let num = parseInt(prompt(promptText));
        if(num<10||num>10000||!Number.isInteger(num)) 
            Capicua.getNumber("Número no válido, intenta con otro");
        Capicua.calculate(num); //Calculo el NC y las iteraciones
        Capicua.printOutput(); //Imprimo el resultado
    }
}

Capicua.getNumber("Ingresa un número entero de dos dígitos menor a 10,000");