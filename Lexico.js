
function Lexico() {
    var n1 = document.getElementById('txtN1').value;
    var cont=0;
    var lex1 = "";
    var lex2 = "";
    var arr = new Array();
    for(var i=0;i<n1.length;i++){
        
        //conseguir numeros de cordenadas, primer requisito es que exista ( en la posición 0 
        if(n1[i]==='('){
            do {
                lex1=lex1+n1[i];
                i++;   
                if(n1[i]===')'){ lex1=lex1+n1[i]; break;}   
            } while ((n1[i]!==',') && (n1[i]!==')') && i<n1.length);

            //En caso de que se cumpla la condicion para las cordenadas
            if(n1[i]===','){
            do {
                lex1=lex1+n1[i];
                if(n1[i]===')'){
                    lex1=lex1+" ";//se agrega elespacio despues de )
                }  
                i++;    
                
            } while ((n1[i]!=='(') && i<n1.length);
            
            //Agregar resto del texto, en caso de que existan coordenadas se quiebra el for para que pueda empezar la iteracion con el for de arriba
            for(var j=i;j<n1.length;j++){
                if(n1[j]===','){  //Si encuentra una coma significa que hay coordenadas
                    lex2="";
                    break;
                }else if(n1[j]==='('){ //Si encuentra "(" entonces debe meterla en la variable
                    lex2=lex2+n1[j]; 
                } else{//Mete los caracteres
                    lex2=lex2+n1[j]; 
                }
            }

           
            arr.push(lex1); //Mete cada cadena de texto para su uso en un futuro
            lex1="";//Vaciar Var
            lex2="";// Vaciar Var
            i--//reduce el contador para que empiece con el caracter "("
            }else{lex1=""} 
            
        }
        
        
    } 

    var resultado= "";
    for(var a=0;a<arr.length;a++){
        resultado= resultado + arr[a]+"\n";
    }
    console.log(resultado);//Muestra los resultados 
    
}
//Se pudieron haber validado los caracteres para que las coordenadas siempre fueran numeros, pero honestamente no supe como ya que si validaba los numeros no podria haber caracteres de otro tipo entre los parentesis, una disculpa por eso :( 