package exercicio;

public class Aluno {
	
	private int Matricula;
	private String Nome;
	
	public Aluno(String nNome, int nMatricula){
		Nome = nNome;
		Matricula = nMatricula;
	}
	
	public String getNome(){
		return Nome;
	}
	
	public int getMatricula(){
		return Matricula;
	}
}
