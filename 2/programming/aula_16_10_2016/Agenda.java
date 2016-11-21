package aula_16_10_2016;

import java.util.ArrayList;

public class Agenda {

	private Data data;
	private ArrayList<Consulta> consultas;
	
	public Agenda(Data data){
		this.data = data;
	}
	
	public void addConsulta(Consulta consulta){
		this.consultas.add(consulta);
	}
	
	public ArrayList<Consulta> getConsultas(){
		return this.consultas;
	}
	
	public String getData(){
		return this.data.getData();
	}
	
}
