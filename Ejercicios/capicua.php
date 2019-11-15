<?php
if (isset($argv)) {

$numero = $argv[1];
$invertido = invertido($numero);
$i=0;

do{
	$i++;
	$n =  bcadd($numero,$invertido);
	$ni = invertido($n);
    if($n == $ni){
    	print $n.' '.$i.PHP_EOL;
    	break;
    } 
    $numero=$n;
    $invertido=$ni;
	}while($numero != $invertido);

}


function invertido($num){
	
	$valorleido = $num;
	$invert = 0;
	$cociente = $valorleido;
	while ( $cociente != 0)
	{
		$resto = $cociente % 10;
		$invert = $invert * 10 + $resto;
		$cociente = (int)($cociente / 10);
	}

	return $invert;
}

?>
