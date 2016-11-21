package aula_20_10_2016;

public class BicicletaCarga extends Bicicleta {

	int espaco;
	
	public BicicletaCarga(int codigo, int marchas, int cor, int espaco, String marca, float valor){
		super(codigo, marchas, cor, marca, valor);
		this.espaco = espaco;
	}
	
	public String getStringEspaco(){
		switch(this.espaco){
		default:
		case 0:
			return "Pequeno";
		case 1:
			return "Médio";
		case 2:
			return "Grande";
		}
	}
	
	public int getEspaco(){
		return this.espaco;
	}
	
}
