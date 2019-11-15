<?php

if (isset($argv)) {
   if(isset($argv[1])){
   	preg_match_all('/\(\d+\,\d+\)+\w+(\([0-9a-zA-Z]*\))*/s',  $argv[1], $salida);

   	if(count($salida[0])!=0){
   		echo PHP_EOL.'Resultado:'.PHP_EOL.PHP_EOL;
		foreach ($salida[0] as $cad){
			echo str_replace(')', ') ', $cad).PHP_EOL;
		}
		
	}else{
		echo chr(27).chr(91).'H'.chr(27).chr(91).'J';  
   		echo "\e[0;30;43m NO HAY COINCIDENCIAS \e[0m".PHP_EOL;
	}
   }else{
   	echo chr(27).chr(91).'H'.chr(27).chr(91).'J';  
   	echo "\e[0;30;43m No ha introducido ninguna cadena \e[0m".PHP_EOL;
   	echo "El modo de uso es: \e[0;30;45m php \e[0m\e[0;30;42m script.php \e[0m\e[0m\e[0;30;46m cadenadetexto\e[0m".PHP_EOL;
   }
}else{}
?>