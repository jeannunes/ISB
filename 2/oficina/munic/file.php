<?php

	class Arquivo {
		
		private $arquivo;
		private $caminho;
		private $tamanho;
		private $flag;
		public $conteudo;

		public function __construct(){
			$this->flag = "a+";
		}
		
		public function carregar($caminho){
			if (@file_exists($caminho)) {
				$this->caminho = $caminho;
				$this->arquivo = fopen($caminho, $this->flag);
				$this->tamanho = filesize($caminho);
				$this->conteudo = fread($this->arquivo, $this->tamanho);
				return true;
			} else {
				throw new Exception('Não foi possível carregar o arquivo.');
			}
		}
		
		public function escrever($conteudo){
			if (fputs($this->arquivo, $conteudo)) {
					fclose($this->arquivo);
					$this->carregar($this->caminho);
					return true;
			} else {
				throw new Exception('Não foi possível escrever no arquivo.');
			}
		}
		
	}

?>
