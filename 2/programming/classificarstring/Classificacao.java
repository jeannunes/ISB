package exercicio2;

import java.util.Arrays;

public class Classificacao {

	private String [] conteudo;
	
	public Classificacao(String[] conteudo){
		this.conteudo = conteudo;
	}
	
	public String[] cassificar(){
		Arrays.sort(this.conteudo);		
		return this.conteudo;
	}
	
	public int buscar(String string){
		int i;
		for(i = 0; i < this.conteudo.length; i++){
			if (this.conteudo[i].equals(string)) {
				return i;
			}
		}
		return -1;
	}
	
}
