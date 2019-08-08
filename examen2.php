<?php
$num = "";
$num_al = "";
do{
    echo "Número: ";
    $num = trim(fgets(STDIN));
}while($num <= 9 || $num >= 10000);//Si es un dígito o mayor o igual a 10000, sigue repitiendo petición
function al_reves(){//Crea variable la cual tendrá los dígitos al revés de la variable original.
    global $tam,$num;
    $aux = "";
    $tam = strlen($num);
    for($i=($tam-1);$i>=0;$i--){
        $aux = $aux.$num[$i];//Está asignando a aux los dígitos al revés
    }
    return $aux;//Retorna la variable con dígitos al revés
}
function capicua(){
    $limite = pow(2,63);//Se pone un límite de número capicua
    $cont = 0;
    global $num,$tam,$num_al;
    $num_al = al_reves();
    do{
        $cont++;
        $num += $num_al;//Le suma el valor que trae de la función al_reves
        $num = strval($num);//Conviarte en string, para poder maniobrar la cadena
        $num_al = al_reves();//Vuelve a llamar a la función para saber si sale del while o no
    }while(($num != $num_al) && ($num < $limite));
    if($num>$limite)//Si pasa el límite hay Error
        echo "Error, mayor a pow(2,63)\n";
    else//Si no hay error, muestra en pantalla el número capicúa y las iteraciones que se necesitaron
        echo $num." ".$cont."\n";
}

function main(){
    capicua();
}
main();
?>