<?php
//Recibe texto del teclado y guarda
do{
    echo "Cadena de caracteres: ";
    $cadena = trim(fgets(STDIN));
    $tam = strlen($cadena);
}while($tam >=250);
$index = 0;
$ult = $cadena[$tam-1];//Toma el último valor de la cadena sin contar enter
$aux = "";
$tama = 0;
//Definición de estados
$inicio = 1;
$dos = 2;
$tres = 3;
$cuatro = 4;
$cinco = 5;
$seis = 6;
$siete = 7;
$ocho = 8;
$nueve = 9;
$diez = 10;
$once = 11;
$fin = 12;

$estado = $inicio;

if($tam == 1)
    $estado = $fin;

function getChar(){//Función para tomar valores del String que se tecleó
    global $tam,$index,$cadena,$aux,$estado,$fin;
    if($index<$tam){
        $aux = $cadena[$index];
        $index++;
    }
    else if(($index==$tam)&&($tam>=1)){
        $aux="final";//Se da valor a variable como retorno de carro, pero diciendo la palabra final
    }
    return $aux;//Variable que se utilizará en los estados
    
}

function checaFin(){//Checa si la variable que se está utilizando en estados es enter
    global $aux,$estado,$fin;
    if($aux=="final"){
        echo "Cadena no válida\n";
        $estado = $fin;//En caso de que sea vacía se manda directo al estado fin
    }
}

function estados(){
    $muestra = "\n";
    $otrax2="";
    $otra = "";
    $esp = 0;
    $cont = 0;
    $var = "";
    $c = getChar();
    global $estado,$inicio,$dos,$tres,$cuatro,$cinco,$seis,$siete,$ocho,$nueve,$diez,$once,$fin,$ult,$tam,$tama,$index;
    if($c == '(' && $tam != 1)//Si la variable es ( y tamaño de la cadena no es uno, se asigna a estado el valor de 1, para que pueda entrar a los estados
        $estado = $inicio;
    else{//Si es ( pero sólo es de tamaño 1, o es != ( no tiene caso meterla a los estados, se manda a fin
        $estado = $fin;
        echo "Cadena no válida\n";
    }
    while($estado != $fin){
        switch($estado){
            case $inicio:
                $var = ""; 
                if($c=='('){
                    $var = $var.$c;
                    $estado = $dos;//Movimientos dependiendo del autómata
                }
                else{
                    $$estado = $fin;
                }
                break;
            case $dos:
                $c = getChar();
                if($c>='0' && $c<='9'){
                    $var = $var.$c;
                    $estado = $tres;
                }
                else
                    checaFin();
                break;
            case $tres:
                $c = getChar();
                if($c>='0' && $c<='9')
                    $var = $var.$c;
                else if($c==','){
                    $var = $var.$c;
                    $estado = $cuatro;
                }
                else
                    checaFin();
                break;
            case $cuatro:
                $c = getChar();
                if($c>='0' && $c<='9'){
                    $var = $var.$c;
                    $estado = $cinco;
                }
                else
                    checaFin();
                break;
            case $cinco:
                $c = getChar();
                if($c>='0' && $c<='9')
                    $var = $var.$c;
                else if($c==')'){
                    $var = $var.$c;
                    $var = $var." ";
                    $estado = $seis;
                }
                else
                    checaFin();
                break;
            case $seis:
                $c = getChar();
                if($c == '('){
                    $var = $var.$c;
                    $estado = $ocho;
                }
                else if($c == "final")
                    checaFin();
                else{
                    $var = $var.$c;
                    $estado = $siete;
                }
                break;
            case $siete:
                $c = getChar();
                if($c == '('){
                    $var = $var.$c;
                    $estado = $ocho;
                }
                else if($c == "final" && $cont >= 2){
                    $muestra = $muestra.$var."\n";
                    echo $muestra."\n";
                    $estado = $fin;
                }
                else if($c == "final")
                    checaFin();
                else
                    $var = $var.$c;
                break;
            case $ocho:
                $c = getChar();
                if($c>='0' && $c<='9'){
                    $var = $var.$c;
                    $estado = $once;
                }
                else if($c == ')'){
                    $var = $var.$c;
                    $estado = $diez;
                }
                else if($c == "final")
                    checaFin();
                else{
                    $var = $var.$c;
                    $estado = $nueve;
                }
                break;
            case $nueve:
                $c = getChar();
                if($c == ')'){
                    $var = $var.$c;
                    $estado = $diez;
                }
                else if($c == "final")
                    checaFin();
                else
                    $var = $var.$c;
                break;
            case $diez:
                $c = getChar();
                if($c == '('){
                    $muestra = $muestra.$var."\n";
                    $cont += 1;
                    $var = "";
                    $estado = $inicio;
                    $index--;
                    $c = getChar();
                }
                else if($c == ')')
                    $var = $var.$c;
                else if($c == "final" && $cont >= 2)
                    $estado = $siete;
                else
                    checaFin();
                break;
            case $once:
                $c = getChar();
                if($c>='0' && $c<='9')
                    $var = $var.$c;
                else if($c == ','){
                    $var = $var.$c;
                    $tama = strlen($var);
                    for($i=1; $i<$tama; $i++){
                        if($var[$i] == '(')
                            $esp = $i;
                    }
                    $tama = $tama-$esp;
                    for($i=0; $i<$tama; $i++)
                        $otra = $otra.$var[$i];
                    $otrax2 = $var;
                    $var = "";
                    for($i=0; $i<$esp; $i++)
                        $var = $var.$otrax2[$i];
                    $muestra = $muestra.$var."\n";
                    $cont += 1;
                    $index = $index - $tama;
                    $c = getChar();
                    $estado = $inicio;
                    $var = $otra;
                }
                else if($c == "final")
                    checaFin();
                else if($c == ')'){
                    $var = $var.$c;
                    $estado = $diez;
                    $cont += 1;
                }
                else{
                    $var = $var.$c;
                    $estado = $nueve;
                }
                break;
            case $fin:
                break;
        }
    }
}
function main(){
    estados();
}
main();
?>