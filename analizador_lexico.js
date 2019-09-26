var ayuda='';
var cadena=process.argv[2];
var array= cadena.split('(');//se divide en arreglos;
for(var i=1;i < array.length;i++)
    {
        var sec=array[i].split(')');//se buscan las coordenadas
        var numeros=sec[0].split(',');//se separan los numeros
        if(numeros[1] === undefined)//si hay texto con parentesis imprime todo lo que guarda 
            {
                console.log(ayuda+'('+array[i]);
            }
        if(!isNaN(parseInt(numeros[0])) && !isNaN(parseInt(numeros[1])))//revisa si son numero
            {
                if(ayuda != '')//si no hay nada guadado, imprime
                    {
                        console.log('('+array[i]);
                        ayuda='';
                    }
                else{//sino lo mantiene guardado hasta que termine de revisar todo antes
                    ayuda+='('+array[i];//de otra coordenada
                }
            }
    }