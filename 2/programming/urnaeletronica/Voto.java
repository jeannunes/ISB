public class Voto {

	private int vereador, prefeito;
	
	public Voto(){
		
	}
	
	public void votarPrefeito(int prefeito){
		this.setPrefeito(prefeito);
	}
	
	public void votarVereador(int vereador){
		this.setVereador(vereador);
	}

	public int getVereador() {
		return vereador;
	}

	public void setVereador(int vereador) {
		this.vereador = vereador;
	}

	public int getPrefeito() {
		return prefeito;
	}

	public void setPrefeito(int prefeito) {
		this.prefeito = prefeito;
	}
	
	
	
}
