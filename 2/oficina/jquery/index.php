<?php
	
	class Formulario {
		
		private $campos = [
	    "nome"=>[
			"required"=>true,
			"data"=>"string",
			"minLength"=>4,
			"maxLength"=>256
		],
	    "sobrenome"=>[
			"required"=>true,
			"data"=>"string",
			"minLength"=>4,
			"maxLength"=>256
		],
	    "datanascimento"=>[
			"required"=>true,
			"data"=>"date",
			"minLength"=>6,
			"maxLength"=>6
		],
	    "cpf"=>[
			"required"=>true,
			"data"=>"numeric",
			"minLength"=>11,
			"maxLength"=>11
		],
	    "telefone"=>[
			"required"=>true,
			"data"=>"numeric",
			"minLength"=>10,
			"maxLength"=>11
		],
	    "email"=>[
			"required"=>true,
			"data"=>"email",
			"minLength"=>4,
			"maxLength"=>256
		],
	    "cep"=>[
			"required"=>true,
			"data"=>"numeric",
			"minLength"=>8,
			"maxLength"=>8
		],
	    "numero"=>[
			"required"=>true,
			"data"=>"numeric",
		],
	    "complemento"=>[
			"required"=>true,
			"data"=>"string",
			"minLength"=>4,
			"maxLength"=>256
		]
		];
		public $dados;
		
		public function __construct(){
			GLOBAL $_POST;
				$this->dados = $_POST;
				unset($_POST);
		}
		
		public function dados($campo = null){
			if ($campo) {
				return $this->dados[$campo];
			} else {
				return $this->dados;
			}
		}
		
		public function metodo($valida = null){
			GLOBAL $_SERVER;
			if (is_array($valida)) {
				return in_array($_SERVER['REQUEST_METHOD'],$valida);
			} else if ($valida) {
				return $_SERVER['REQUEST_METHOD'] == $valida;
			} else {
				return $_SERVER['REQUEST_METHOD']; 
			}
		}
		
		public function validarCampos(){
			foreach($this->campos as $input=>$rules){
				if ($rules) {
					
					if ($rules->required && !$this->data[$input]) {
						throw new Exception("Valor do campo " + $input + " não pode ser deixado em branco!");
					}
					
					if ($rules->data) {
						
						if ($rules->data == "string" && gettype($this->data[$input]) != "string") {
							throw new Exception("Valor do campo " + $input + " deve ser uma string!");
						}
						
						if ($rules->data == "numeric" && gettype($this->data[$input]) != "integer") {
							throw new Exception("Valor do campo " + $input + " deve ser um inteiro!");
						}
						
						if ($rules->data == "email" && !filter_var($this->data[$input], FILTER_VALIDATE_EMAIL)) {
							throw new Exception("Valor do campo " + $input + " deve ser email válido!");
						}
						
						$d = explode("-", $this->data[$input]);
						if ($rules->data == "date" && !checkdate($d[1],$d[2],$d[0])) {
							throw new Exception("Valor do campo " + $input + " deve ser uma data!");
						}
						
						if ($rules->minLength && strlen($this->data["input"])<$rules->minLength ) {
							throw new Exception("Valor do campo " + $input + " deve conter no mínimo " . $rules->minLength . " caracteres!");
						}
						
						if ($rules->maxLength && strlen($this->data["input"])>$rules->maxLength ) {
							throw new Exception("Valor do campo " + $input + " deve conter no máximo " . $rules->maxLength . " caracteres!");
						}
						
					}
					
				}
			}
		}
		
		public function salvarXML($arquivo){
			$xml = simplexml_load_file($arquivo);
			$registro = $xml->addChild("pessoa");
			$identica = $registro->addChild("identificacao");
				$identica->addChild('nome', $this->dados('nome'));
				$identica->addChild('sobrenome', $this->dados('sobrenome'));
				$identica->addChild('datanascimento', $this->dados('dadosnascimento'));
				$identica->addChild('cpf', $this->dados('cpf'));
			$contato = $registro->addChild("contato");
				$contato->addChild('telefone', $this->dados('telefone'));
				$contato->addChild('email', $this->dados('email'));
			$endereco = $registro->addChild("correspondencia");
				$endereco->addChild('cep', $this->dados('cep'));
				$endereco->addChild('logradouro', $this->dados('logradouro'));
				$endereco->addChild('numero', $this->dados('numero'));
				$endereco->addChild('complemento', $this->dados('complemento'));
				$endereco->addChild('localidade', $this->dados('cidade'));
				$endereco->addChild('uf', $this->dados('uf'));
			
				if ($xml->asXML($arquivo)) {
					return true;
				} else {
					return false;
				}
				
		}
	
	}
	
	$form = new Formulario();
	
	if ($form->metodo(["PUT","POST"])) {
		
		$form->validarCampos();
		if ($form->salvarXML("pessoas.xml")) {
			echo json_encode(array("status"=>"sucesso"));
		} else {
			echo json_encode(array("status"=>"error"));
		}
		
		exit();
	}

?>
<html>
	<head>
		<title>Formulário JQuery</title>
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.1.1.min.js" type="text/javascript"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	</head>
	<body>
		<div class='container'>
			<form method='post' action='index.php'>
			
				<div class='overlay' style='display: none'>
					<div class='row'>
						<div class='col-sm-12 col-md-6 col-md-offset-3'>
							<div class="progress">
								<div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
									<span class="sr-only">0% Complete</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			
				<h1>Cadastro de Pessoas</h1>
				
				<fieldset>
					<legend>Identificação</legend>
					<div class='form-group col-sm-12 col-md-6'>
						<label for='nome'>Nome</label>
						<input type='text' name='nome' class='form-control' />
					</div>
					<div class='form-group col-sm-12 col-md-6'>
						<label for='sobrenome'>Sobrenome</label>
						<input type='text' name='sobrenome' class='form-control' />
					</div>
					<div class='form-group col-sm-12 col-md-6'>
						<label for='datanascimento'>Data de Nascimento</label>
						<input type='date' name='datanascimento' class='form-control' />
					</div>
					<div class='form-group col-sm-12 col-md-6'>
						<label for='cpf'>CPF</label>
						<input type='text' name='cpf' class='form-control' />
					</div>
				</fieldset>
				
				<fieldset>
					<legend>Contato</legend>
					<div class='form-group col-sm-12 col-md-6'>
						<label for='telefone'>Telefone</label>
						<input type='text' name='telefone' class='form-control' />
					</div>
					<div class='form-group col-sm-12 col-md-6'>
						<label for='email'>E-Mail</label>
						<input type='text' name='email' class='form-control' />
					</div>
				</fieldset>
				
				<fieldset>
					<legend>Correspondência</legend>
					<div class='form-group col-sm-12 col-md-2'>
						<label for='cep'>CEP</label>
						<input type='text' name='cep' class='form-control' />
					</div>
					<div class='form-group col-sm-12 col-md-5'>
						<label for='logradouro'>Logradouro</label>
						<input type='text' name='logradouro' readonly class='form-control' />
					</div>
					<div class='form-group col-sm-12 col-md-2'>
						<label for='numero'>Número</label>
						<input type='text' name='numero' class='form-control' />
					</div>
					<div class='form-group col-sm-12 col-md-3'>
						<label for='complemento'>Complemento</label>
						<input type='text' name='complemento' class='form-control' />
					</div>
					<div class='form-group col-sm-12 col-md-6'>
						<label for='cidade'>Cidade</label>
						<input type='text' name='cidade' readonly class='form-control' />
					</div>
					<div class='form-group col-sm-12 col-md-6'>
						<label for='uf'>UF</label>
						<input type='text' name='uf' readonly class='form-control' />
					</div>
				</fieldset>
				
				<input type="submit" class="btn btn-primary" value="Cadastrar" />
				
			</form>
		</div>
	<script>
		$(document).ready(function(){
		
			$("form").submit(function(e){
			
				var erros = false;
				$.each($("input, select, textarea", this),function(k, v){
					if ($(v).val() == "" || $(v).val() == null ) {
						$(v).parent().addClass("has-error");
						$(v).focus();
						erros = true;
						return false;
					} else {
						$(v).parent().removeClass("has-error");
					}
				});
				
				if (!erros) {
				
					var overlay = $("form .overlay");
					
					$(overlay)
						.css({
							background: "RGBA(255,255,255,0.8)",
							width: $(overlay).parent().width(),
							height: $(overlay).parent().height(),
							position: "absolute",
							"z-index": 1000
						}).show();
				
					$.post("index.php",$(this).serializeArray(),function(data){
						data = $.parseJSON(data);
						
						console.log(data);
						$("form .overlay .progress-bar").width("100%");
						setTimeout(function(){
							$("form .overlay").fadeOut();
							alert("Registro salvo com sucesso!");
						},500);
					
					});
				}
			
				return false;
			});
			
			$("input[name=cep]").change(function(){
				
				var obj = $(this),
					cep = $(obj).val();
				
				$.ajax({
					url: "http://viacep.com.br/ws/" + cep + "/json/",
					type: "GET",
					headers: { "Access-Control-Allow-Origin": "*" },
					crossDomain: true,
					dataType: "jsonp",
					success: function(data){
						$("input[name=cep]").removeClass("has-error");
						if (!data.logradouro) {
							$("input[name=logradouro]").prop('readonly', false).focus();
						} else {
							$("input[name=logradouro]")
								.val(data.logradouro)
								.prop('readonly', true)
								;
							$("input[name=numero]").focus();
						}
						$("input[name=cidade]").val(data.localidade);
						$("input[name=uf]").val(data.uf);
					},
					error: function(){
						$("input[name=cep]").addClass("has-error").focus();
					},
				});
				
			});
		
		});
	</script>
	</body>
</html>
