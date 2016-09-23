public class Jogador {

	public String nome;
	public int score;
	public Peca peca;
	
	public Jogador(String nome, char peca){
		this.score = 0;
		this.setNome(nome);
		this.setPeca(peca);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getScore() {
		return score;
	}
	public void addScore(int score) {
		this.score += score;
	}
	public Peca getPeca() {
		return peca;
	}
	public void setPeca(char peca) {
		Peca temp;
		temp = new Peca(peca);
		this.peca = temp;
	}
	
	
	
}
