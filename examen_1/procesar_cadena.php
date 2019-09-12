<?php

    $cad = $_REQUEST['txtCadena']; //cadena a descomponer en coordenadas
    $p= 0; //apuntador de la cadena
    $aux = array(); //array para almacenar las partes de la cadena
    $texto='';

    for ($i=0; $i<strlen($cad)-1; $i++) {
        //divide la cadena
        switch ($cad[$i]) {
            case '(':
            case ',':
            case ')':
                // si el caracter es '(', ',' ó ')' lo guarda en el array
                $aux[] =$texto;
                $aux[] = substr($cad, $i, 1);

                $p = $i+1;
                $texto ='';
                break;
            default:
                $texto .= $cad[$i];
                break;
        }
    }

    //guarda lo que "sobra" de la cadena
    $aux[] = substr($cad, $p, $i+1-$p);

    $i = 0;
    //busca y forma los pares de coordenadas y el texto de cada una
    $coord = array();
    $texto_coord = array();
    while($i < count($aux)){

        if ($aux[$i] == "(" && is_numeric($aux[$i+1]) && $aux[$i+2] == ',' && is_numeric($aux[$i+3]) && $aux[$i+4] == ')'){
            $coord[] = $aux[$i] . $aux[$i+1] . $aux[$i+2] . $aux[$i+3] .$aux[$i+4];
            $texto_coord[] = '';
            $i+=5;
        }else{
            if (count($coord)> 0)
                $texto_coord[count($coord)-1] .= $aux[$i];
            $i++;
        }

    }

    if(count($coord)== 3){
        echo $coord[0] . ' ' . $texto_coord[0] . '<br>';
        echo $coord[1] . ' ' . $texto_coord[1] . '<br>';
        echo $coord[2] . ' ' . $texto_coord[2] . '<br>';
    }else{
        echo 'La cadena proporcionada no tiene el formato requerido';
    }



