
function Capicua() {

    var v1 = document.getElementById('txtN1').value;
    var cont=1;

    if(v1<=10){
        alert("El valor tiene que ser mayor a 9 o se ha introducido texto");
    }else{
        var arr = new Array();
        var arr2 = new Array();
        var v2="";
        var res,res2;
        var n1,n2;
        var it = 1;

        do{
            
        for(var i=0;i<v1.length;i++){//se agrega el numero a un arreglo caracter por caracter
           arr.push(v1[i]); 
        }
        for(var j=v1.length-1;j>=0;j--){//El numero se pone al reves sacando los caracteres del arreglo desde la posición mas alta
            v2=v2+v1[j];
        }

        n1 = parseInt(v1); //Se convierten en enteros
        n2 = parseInt(v2);
        res = n1+n2; //Se suman
        res2 = res.toString(); // Se hacen String
        for(var k=0;k<res2.length;k++){//dentro de otro array se pone el resultado para hacer la verificación
            arr2.push(res2[k]); 
        }
        
        for(var a=0; a<arr2.length; a++){//Se hacen dos for uno que valla  ascendente
            for(var b=arr2.length-1; b>=0;b--){ // y otro descendente
                if(arr2[a]===arr2[b]){ //Se comprueba que lo que esta en la posicion 'a' sea igual a 'b'

                    if(a===b){ //Si el indice de 'a' es igual a 'b'  entonces acabo de comprobar y se rompe el for
                       break; 
                    }else{a++;}//sino continua conla comprobación
                    
                }else{ //si lo que esta en 'a' es diferente de 'b' entonces asigna a v1 el resultado de la suma para que haga otra iteración
                    v1=res2;
                    arr.splice(0,arr.length);//Los arreglos se vacian
                    arr2.splice(0,arr2.length);
                    v2="";
                    cont++; 
                    break; //se rompe for para hacer una nueva iteracion
                }
            }
            break; //aqui tambien se rompe porque sino seguiria sobre el mismo valor 
        }
        if(a===b){//si el indice 'a'='b' significa que la comprobación fue correcta y es un número Capicua
            it=0;//se rompe ciclo while 
        }else if(arr2[a-1]===arr2[b+1]){//En caso de que sea un número par comprueba si lo que esta en una posición arriba es igual
            it=0;
        }
            
        }while(it === 1);
        

        
        console.log("Salida: \n"+res+" "+cont );
        
        
    }
    
    

}
