package exercicio2;

public class Principal {

	public static void main(String[] args) {

		Classificacao strings;
		String[] conteudo;
		String termo;
		int posicao;
		
		conteudo = new String[3];
		conteudo[0] = "Jean";
		conteudo[1] = "Lucas";
		conteudo[2] = "Andrey";
		
		strings = new Classificacao(conteudo);
		
		termo = "Lucas";
		posicao = strings.buscar(termo);
		System.out.println(termo + " foi encontrado na posição " + posicao);
		
		conteudo = strings.classificar();
		for(posicao = 0; posicao < conteudo.length; posicao++){
			System.out.println(posicao + " = " + conteudo[posicao]);
		}

	}

}
