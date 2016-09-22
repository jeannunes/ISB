package exercicio;

public class Professor {
	private int Codigo;
	private String Nome;
	
	public Professor(String nNome, int nCodigo){
		Nome = nNome;
		Codigo = nCodigo;
		
	}
	
	public String getNome(){
		return Nome;
	}
	
	public int getCodigo(){
		return Codigo;
	}
}
