<?php
class capi
{
	function get_capicua($num)
	{
		$pass		= 0;
		$is_capi	= false;
		$temp		= $num;
		$return 	= false;
		while (!$is_capi && $temp <= pow(2,63))
		{
			$res	= $this->_str_add($temp,$this->_get_reverse($temp));
			$temp	= $res;
			$is_capi =  $res == $this->_get_reverse($res);
			$pass++;
		}
		if ($is_capi)
		{
			$return = array(
							 'numero' => $num
							,'capicua' => $res
							,'iteracciones' => $pass
							);
		}
		return $return;
	}
	
	private function _get_reverse($num)
	{
		$rev = '';
		for ($i=strlen($num)-1;$i>=0;$i--)
		{
			$rev .= substr($num,$i,1);
		}
		return $rev;
	}
	
	private function _str_add($a,$b)
	{
		$l = strlen($a)>strlen($b)?strlen($a):strlen($b);
		$res = '';
		$add = 0;
		for ($i=$l-1;$i>=0;$i--)
		{
			$sa = strlen($a)>$i ? substr($a,$i,1) : '0';
			$sb = strlen($b)>$i ? substr($b,$i,1) : '0';
			$ss = $sa + $sb + $add;
			if ($ss >= 10)
			{
				$add = substr($ss,0,1);
				$res = substr($ss,1,1).$res;
			}
			else
			{
				$add = 0;
				$res = $ss.$res;
			}
			
		}
		return ltrim($add.$res,'0');
	}
}

if ($_SERVER['REQUEST_METHOD']=='POST')
{
	$numero = intval($_POST['numero']);
	if (9<$numero && $numero<10000)
	{
		$c	= new capi();
		$capi = $c->get_capicua($numero);
	}
}
?><!doctype html>
<html lang="es">
	<head>
		<meta charset="utf-8">
		<title>Ejercicio #2</title>
		<meta name="description" content="Ejercicio #2 de Lion Systems">
		<meta name="author" content="Roberto Carreón">
	</head>
	<body>
		<form action="<?php echo $_SERVER['REQUEST_URI']; ?>" method="post" id="main-form">
			Entrada: <input type="text" name="numero" id="input_1" value="<?php echo isset($numero)?$numero:'';?>" />
			<br />
			<input type="submit" name="enviar" id="input_2" value="Enviar" />
		</form>
		<?php if (isset($numero)): ?>
			<h3>Resultado:</h3>
			<?php if (isset($capi) && is_array($capi)): ?>
				<?php echo "<div>{$capi['capicua']} {$capi['iteracciones']}</div>\r\n"; ?>
			<?php elseif (9<$numero && $numero<10000): ?>
				<div style="border:1px solid #600; background-color:rgba(255,0,0,0.2); color:#900;padding:10px;"><p><strong>Error:</strong> No se encontró Capicúa menor o igual a 2<sup>63</sup>.</p>
				</div>
			<?php else: ?>
				<div style="border:1px solid #600; background-color:rgba(255,0,0,0.2); color:#900;padding:10px;"><p><strong>Error:</strong> Por favor ingrese un número mayor que 9 y menor que 10,000.</p>
				</div>
			<?php endif; ?>
		<?php endif; ?>
	</body>
</html>
