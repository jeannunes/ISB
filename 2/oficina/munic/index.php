<?php
	require "file.php";
?>
<html>
	<head>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	</head>
	<body>
		<div class='container'>
			<h1>Busca Cidade</h1>
			<?php
			
				function buscaCidade($cidadeBuscar){
					$arquivo = new Arquivo();
				
					$arquivo->carregar("munic.csv");
					
					$lista = Array();
					$cidades = explode("\n",$arquivo->conteudo);
					$i = 1;
					foreach($cidades as $cidade){
						$temp = explode(";", $cidade);
						$lista[$i]["estado"] = $temp[0];
						$lista[$i]["codigo"] = $temp[1];
						$lista[$i]["nome"] = $temp[2];
						$i++;
					}
					foreach($lista as $chave=>$c){		
						if (is_numeric(strpos($c["nome"], $cidadeBuscar))) {
							$result[]=$lista[$chave];
						}
					}
					
					return $result;
					
				}
			?>

			<table>
			<?php
				foreach(buscaCidade($_GET["cidade"]) as $item=>$cidade){
			?>
			
				<tr>
					<td><?=$cidade["codigo"]?></td>
					<td><?=$cidade["nome"]?></td>
					<td><?=$cidade["estado"]?></td>
				</tr>
			
			<?php } ?>
			</table>
		</div>
	</body>
</html>
