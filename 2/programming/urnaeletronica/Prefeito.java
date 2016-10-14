public class Prefeito extends Candidato {

	private int numero, votos;

	public Prefeito(String nome, String partido, int numero){
		super(nome, partido);
		this.setNumero(numero);
		this.votos = 0;
	}
	
	public int getNumero() {
		return numero;
	}

	public boolean setNumero(int numero) {
		if (numero >= -1 && numero < 100) {
			this.numero = numero;
			return true;
		}
		return false;
	}
	public int getVotos(){
		return this.votos;
	}
	public boolean votar(int numero){
		if (this.numero == numero) {
			this.votos =+1;
			return true;
		}
		return false;
	}

}