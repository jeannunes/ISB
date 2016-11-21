package aula_16_10_2016;
public class Data {

	private int dia, mes, ano;
	
	public Data(int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public String getData(){
		return this.dia + "/" + this.mes + "/" + this.ano;
	}
	
}
