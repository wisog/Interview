
class Analizador{
    constructor(){  
    }


    static Analisis(cadena){
        let resultados = new Object();
        resultados.coord1x = "";
        resultados.coord1y = "";
        resultados.coord1txt = "";
        resultados.coord2x = "";
        resultados.coord2y = "";
        resultados.coord2txt = "";
        resultados.coord3x = "";
        resultados.coord3y = "";
        resultados.coord3txt = "";

        let str = String(cadena);
        let len = str.length;
        let params = 0;
        let is_param = false;
        for(let i=0; i<len; i++){
            if( str.charAt(i) == '('){
                is_param = true;
            }
            else if( (str.charAt(i) == ')' || str.charAt(i) == ',') && is_param ){
                if(str.charAt(i) == ')'){
                    is_param = false;
                }
                params++;
            }
            else if(isNaN(str.charAt(i)) && is_param){
                is_param = false;
            }
            else if(!isNaN(str.charAt(i)) && is_param){
                switch(params){
                    case 0:
                        resultados.coord1x += String(str.charAt(i));
                        break;
                    case 1:
                        resultados.coord1y += String(str.charAt(i));
                        break;
                    case 2:
                        resultados.coord2x += String(str.charAt(i));
                        break;
                    case 3:
                        resultados.coord2y += String(str.charAt(i));
                        break;
                    case 4:
                        resultados.coord3x += String(str.charAt(i));
                        break;
                    case 5:
                        resultados.coord3y += String(str.charAt(i));
                        break;
                }
                
            }
            else{
                switch(params){
                    case 2:
                        resultados.coord1txt+=String(str.charAt(i));
                        break;
                    case 4:
                        resultados.coord2txt+=String(str.charAt(i));
                        break;
                    case 6:
                        resultados.coord3txt+=String(str.charAt(i));
                        break;
                }
            }


        }
        return resultados;
    }

}


let entrada = process.argv[2];//se adquiere la cadena a analizar por parametro
let resultados = Analizador.Analisis("(12324,432)dsajjkasw(54,23423)eqwmk(7753,8876)dsad");
console.log("("+resultados.coord1x+","+resultados.coord1y+") "+resultados.coord1txt+"\n");
console.log("("+resultados.coord2x+","+resultados.coord2y+") "+resultados.coord2txt+"\n");
console.log("("+resultados.coord3x+","+resultados.coord3y+") "+resultados.coord3txt);