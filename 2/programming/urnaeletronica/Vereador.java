public class Vereador extends Candidato {

	private int numero;

	public Vereador(String nome, String partido, int numero){
		super(nome, partido);
		this.setNumero(numero);
	}
	
	public int getNumero() {
		return numero;
	}

	public boolean setNumero(int numero) {
		if (numero > 999 && numero < 100000) {
			this.numero = numero;
			return true;
		}
		return false;
	}

}
