<?php

class coords
{
	public function getFromString($string)
	{
		$ptrn	= 	 '#'
					.'\([\d]{1,}\,[\d]{1,}\)'
					.'#'
					;
		if (preg_match_all($ptrn,$string,$MATCHES,PREG_OFFSET_CAPTURE))
		{
			$return = array();
			for($i=0, $n=count($MATCHES[0]);$i<$n;$i++)
			{
				if (array_key_exists($i+1,$MATCHES[0]))
				{
					$tmp=substr($string,$MATCHES[0][$i][1],$MATCHES[0][$i+1][1]-$MATCHES[0][$i][1]);
				}
				else
				{
					$tmp=substr($string,$MATCHES[0][$i][1]);
				}
				$label = str_replace($MATCHES[0][$i][0],'',$tmp);
				if (strlen(trim($label)))
				{
					$return[] = array(
									'coord' => $MATCHES[0][$i][0]
									,'label' => $this->_sanitize($label)
									);
				}
			}
			if (!count($return) | count($return)!=3)
			{
				$return = false;
			}
			return $return;
		}
	}
	
	public function getInput()
	{
		
		return htmlspecialchars(trim($_POST['texto']));
	}
	
	private function _sanitize($txt)
	{
		return filter_var(trim($txt),FILTER_SANITIZE_FULL_SPECIAL_CHARS);
	}
}

if ($_SERVER['REQUEST_METHOD']=='POST')
{
	$c		= new coords();
	$txt	= $c->getInput();
	if (strlen($_POST['texto']) <= 250)
	{
		$val	= $c->getFromString($txt);
	}
	else
	{
		$val	= false;
	}
	
}


?><!doctype html>
<html lang="es">
	<head>
		<meta charset="utf-8">
		<title>Ejercicio #1</title>
		<meta name="description" content="Ejercicio # 1 de Lion Systems">
		<meta name="author" content="Roberto Carreón">
	</head>
	<body>
		<form action="<?php echo $_SERVER['REQUEST_URI']; ?>" method="post" id="main-form">
			Entrada: <input type="text" name="texto" id="input_1" value="<?php echo isset($txt)?$txt:'';?>" />
			<br />
			<input type="submit" name="enviar" id="input_2" value="Enviar" />
		</form>
		<?php if (isset($txt)): ?>
			<h3>Resultado:</h3>
			<?php if (is_array($val)): ?>
				<?php foreach($val as $v){echo "<div>{$v['coord']} {$v['label']}</div>\r\n";} ?>
			<?php else: ?>
				<div style="border:1px solid #600; background-color:rgba(255,0,0,0.2); color:#900;padding:10px;"><p><strong>Error:</strong> El texto introducido no proporciona tres juegos de coordenadas en el formato requerido.</p>
				<ul><li>Formato requerido: (x1,y1)texto1(x2,y2)texto2(x3,y3)texto3</li>
				<?php if (strlen($_POST['texto'])>250): ?>
				<li>Longitud máxima: 250 caracteres. Longitud Actual: <?php echo strlen($_POST['texto']);?> caracteres.</li>
				<?php endif; ?>
				</ul>
				</div>
			<?php endif; ?>
		<?php endif; ?>
	</body>
</html>
