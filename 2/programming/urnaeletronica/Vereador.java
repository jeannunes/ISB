public class Vereador extends Candidato {

	private int numero, votos;

	public Vereador(String nome, String partido, int numero){
		super(nome, partido);
		this.setNumero(numero);
	}
	
	public int getNumero() {
		return numero;
	}

	public boolean setNumero(int numero) {
		if ( (numero > 9999 && numero < 100000) || (numero == -1 || numero == 0)) {
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