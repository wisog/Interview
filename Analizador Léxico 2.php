<?php
 
 class Analyzer {
     static function process($row_str) {
         try {
             if(strlen($row_str) > 250) //Valido que la cadena no sea mayor a 250 caracteres
                 throw new Exception('La cadena excede los 250 caracteres.');
             else {
                 $indexes = preg_split("/\(\d+,\d+\)/", $row_str, null, PREG_SPLIT_OFFSET_CAPTURE); //Divido la cadena con una expresión regular y se guardan los resultados en un array
                 $count = count($indexes);
                 for($i = 1; $i < $count; $i++) { //Empiezo en 1 porque $indexes[0] no contiene ningun valor.
                     $coord_start = $indexes[$i-1][1] + strlen($indexes[$i-1][0]);
                     $coord_end = $indexes[$i][1];
                     echo substr($row_str, $coord_start, $coord_end - $coord_start).' '.$indexes[$i][0]."\n"; //Hago un substring de la cadena inicial dividiendo las coordenadas y el texto por un espacio
                 }
             }
         } catch(Exception $e) {
             echo 'Error: '.$e->getMessage()."\n"; //Imprimo la excepción
         }
     }
 }
 
Analyzer::process("(79,34)Holaefwefgw(10afef)(98,902843)oeijfwoijef(34,56)bingopingolingo");