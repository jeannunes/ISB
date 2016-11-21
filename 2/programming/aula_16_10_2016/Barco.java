package aula_16_10_2016;
public class Barco {

	private String fabricante;
	private float capacidadePassageiros;
	private TipoMotor motor;
	
	public Barco(String fabricante, float capacidadePassageiros, TipoMotor motor){
		this.fabricante = fabricante;
		this.capacidadePassageiros = capacidadePassageiros;
		this.motor = motor;
	}
	
	public void setMotor(TipoMotor motor){
		this.motor = motor;
	}
	
	public TipoMotor getMotor(){
		return this.motor;
	}
	
	public String getFabricante(){
		return this.fabricante;
	}
	
	public float getCapacidadePessoas(){
		return this.capacidadePassageiros;
	}

}
