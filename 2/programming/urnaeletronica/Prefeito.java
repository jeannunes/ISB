public class Prefeito extends Candidato {

	private int numero;

	public Prefeito(String nome, String partido, int numero){
		super(nome, partido);
		this.setNumero(numero);
	}
	
	public int getNumero() {
		return numero;
	}

	public boolean setNumero(int numero) {
		if (numero > 0 && numero < 100) {
			this.numero = numero;
			return true;
		}
		return false;
	}

}
