package aula_16_10_2016;
import java.util.ArrayList;

public class Principal {

	private ArrayList<Agenda> agendas;
	private Consulta consulta;
	private Data data;
	private Agenda agenda;
	
	public Principal(){
		agendas = new ArrayList<Agenda>();
		data = new Data(6,10,2016);
		agenda = new Agenda(data);
		consulta = new Consulta("Jean Ricardo Nunes Maciel");
		agenda.addConsulta(consulta);
		agendas.add(agenda);
	}
	
	public static void main(String[] args) {
	}

}
