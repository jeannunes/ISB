package aula_20_10_2016;

public class BicicletaPasseio extends Bicicleta {

	private boolean aceitaPassageiros;
	private int aro, tamanho;
	
	public BicicletaPasseio(int codigo, int marchas, int cor, int aro, int tamanho, boolean aceitaPassageiros, String marca, float valor){
		super(codigo, marchas, cor, marca, valor);
		this.aceitaPassageiros = aceitaPassageiros;
		this.aro = aro;
		this.tamanho = tamanho;
	}
	
	public boolean getPassageiros(){
		return this.aceitaPassageiros;
	}
	
	public int getAro(){
		return this.aro;
	}
	
	public int getTamanho(){
		return this.tamanho;
	}
	
	public String getStringTamanho(){
		switch(this.tamanho){
		default:
		case 0:
			return "Adulto";
		case 1:
			return "Infantil";
		}
	}
	
}
