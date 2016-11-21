package aula_20_10_2016;

public class Bicicleta {

	private int marchas, cor, codigo;
	private String marca;
	private float valor;
	
	public Bicicleta(int codigo, int marchas, int cor, String marca, float valor){
		this.cor = cor;
		this.marchas = marchas;
		this.marca = marca;
		this.valor = valor;
	}
	
	public int getCodigo(){
		return this.codigo;
	}
	
	public String getStringCor(){
		switch(this.cor){
		default:
		case 0:
			return "preta";
		case 1:
			return "vermelha";
		case 2:
			return "azul";
		}
	}
	
	public int getCor(){
		return this.cor;
	}
	
	public int getMarchas(){
		return this.marchas;
	}
	
	public String getMarca(){
		return this.marca;
	}
	
	public float getValor(){
		return this.valor;
	}
	
}
