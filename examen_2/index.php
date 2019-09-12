<!DOCTYPE html>
<html>

    <head>
        <title>Números Capicúas</title>
    </head>


    <body>

        <form action="index.php" >

            <label for="txtCadena">Escribe un número</label>
            <br>
            <input type="text" value="" name="txtNum" style="width: 50%">
            <input type="submit" value="Genera número capicúa">

        </form>



        <?php
        error_reporting(E_ALL & ~E_NOTICE);

        class capicuas {

            var $numero = 0;
            var $numero_invertido = 0;
            var $numero_capicua = 0;
            var $iteraciones = 0;

            function set_numero($val) {
                //nos aseguramos de que sea un valor númerico
                $this->numero =  0 + $val;
            }

            function get_numero() {
                return $this->numero;
            }

            function get_iteraciones() {
                return $this->iteraciones;
            }

            function get_num_invertido($val = null) {
                //nos aseguramos de que el valor proporcionado se guarde como texto
                $invertido = is_null($val) ? ''. $this->numero : $val;
                $aux = '';
                //Invierte el número
                for ($i=0; $i<strlen($invertido); $i++){
                    $aux = substr($invertido, $i, 1) . $aux;
                }
                //nos aseguramso de regresar un valor númerico
                $this->numero_invertido =  0 + $aux;
                return $this->numero_invertido;
            }

            function get_capicua($val1, $val2){

                //en caso de que el numero capicua sea muy grande, nos aseguramos que las variables puedan contenerlo
                settype($this->numero_capicua, "double");
                settype($this->iteraciones, "double");

                //suma el valor proporcionado + el mismo número escrito de forma inversa.
                $this->numero_capicua = (double) $val1 + (double) $val2;
                //cuenta las iteraciones
                $this->iteraciones++;
                if ($this->numero_capicua != $this->get_num_invertido($this->numero_capicua)){
                    //si no es un núemro capicúa, usa recursividad para calcular las siguientes iteraciones
                    //var_dump($this->numero_capicua);
                    $this->get_capicua($this->numero_capicua, $this->get_num_invertido($this->numero_capicua));

                }

                //regresa el número calculado
                return $this->numero_capicua;

            }
        }




        if (isset($_REQUEST['txtNum'])){

            $num = $_REQUEST['txtNum'];

            //valida que el número sea de dos dígitos
            if(strlen($num) < 2){
                echo "El número debe ser mayor a 9 y menor a 10000";
            }else{
                //crea el objeto
                $num_cap = new capicuas;
                $num_cap->set_numero($num);

                //guarda la cadena que se va a mostrar como resultado
                $res = "<br><table>
                            <thead>
                                <tr>
                                    <th>Entrada</th>
                                    <th>Salida</th>
                                    <th>Iteraciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>" . $num_cap->get_numero() . "</td>
                                    <td>" . $num_cap->get_capicua($num_cap->get_numero(), $num_cap->get_num_invertido()) . "</td>
                                    <td>" . $num_cap->get_iteraciones(). "</td>
                                </tr>
                            </tbody>
                        </table>";

                echo $res;


            }
        }
        ?>
    </body>
</html>