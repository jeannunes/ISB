package aula_16_10_2016;
public class MinhaArrayList {

	private int vetor[], ultimaPosicao, totalPosicoes;
	
	public MinhaArrayList(){
		this.vetor = new int[10];
		this.totalPosicoes = 10;
		this.ultimaPosicao = 0;
	}
	
	public MinhaArrayList(int pos){
		this.vetor = new int[pos];
		this.totalPosicoes = pos;
		this.ultimaPosicao = 0;
	}
	
	public boolean add(int numero){
		if (ultimaPosicao < totalPosicoes) {
			this.vetor[ultimaPosicao] = numero;
			this.ultimaPosicao++;
			return true;
		}
		return false;
	}

}
