<?php

class Capicua {
    private static function isCapicua($num) {
        $num_str = str_split((string)$num); //Divido el número en un array para poder recorrerlo
        $digits = count($num_str); //Consigo el número de dígitos
        $is_capicua = true;
        for($i = 0; $i < $digits; $i++) {
           if(strcmp($num_str[$i], $num_str[$digits-$i-1])){ //Comparo que la cadena coincida por ambos extremos
              $is_capicua = false;
              break; //Si los dígitos no coinciden, sale del ciclo
           }
        }
        return $is_capicua;
    }
    public static function get($num) {
        try {
            if($num < 9 || $num > 10000) //Valido que el número sea mayor a 1 dígito y menor que 10,000
                throw new Exception('La cadena excede los 250 caracteres.');
            else {
                $iteration = 0;
                while(++$iteration) { //Un bucle infinito
                    $num += (int)strrev((string)$num); //Sumo el número inicial con su inverso
                    if(Capicua::isCapicua($num)){ //Reviso si la suma es capicúa
                        echo "{$num} {$iteration}";
                        break; //Salgo del bucle
                    }
                }
            }
        }
        catch(Exception $e) {
            echo 'Error: '.$e->getMessage()."\n"; //Imprimo la excepción
        }
    }
}

Capicua::get(12);