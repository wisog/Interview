<?php
$cadena = "(79,34)Holaafklndfoi(10asldkfj)(98,902843)lnkjasdlnkfjas(34,56)Bingopingolingo";

$regex = '/\((\d+,\d+)\)((?:(?!\(\d+,\d+\)).)*)/';

preg_match_all($regex, $cadena, $matches, PREG_SET_ORDER);

foreach ($matches as $match) {
    echo "(" . $match[1] . ")" . $match[2] . "\n";
}
?>
