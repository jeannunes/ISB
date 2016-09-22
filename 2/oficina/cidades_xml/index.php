<html>
	<head>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	</head>
	<body style='padding: 25px;'>
		<div class='container'>
			<div class="panel panel-primary">
				<div class='panel-body'>

				<?php
				
					$estado = $_GET["estado"];
					$p = $_GET["p"];
					$limit = 10;
					
					
					if ($estado) {
						
						$file = "estados.xml";
					$content = simplexml_load_file($file);
						
						$es = $content->xpath("/estados/estado[codigoestado=".$estado."]");
						
						if ($es) {
							
							foreach($es as $i){
								echo "<h1>". $i->nome . " - " . $i->uf ."</h1>";
							}
							
						}
						
						echo "<a href='index.php'>Voltar</a>";
						
					} else {
						
						$file = "cidades.xml";
					$content = simplexml_load_file($file);
						
						echo "<table class='table'>";
						
							echo "<tr>";
								echo "<th>Código</th>";
								echo "<th>Nome</th>";
								echo "<th>&#160;</th>";
							echo "</tr>";
						
						foreach($content as $item=>$cidade){
							echo "<tr>";
								echo "<td>" . $cidade->codigo . "</td>";
								echo "<td>" . $cidade->nome . "</td>";
								echo "<td><a href='?estado=" . $cidade->codigoestado . "'>Ver estado</a></td>";
							echo "</tr>";
						}
						echo "</table>";
						
					}
				
				?>
				</div>
			</div>
		</div>
	</body>
</html>
