package exercicio;

public class Livro {
	private int codigo;
	private String Nome;
	private boolean emprestado;
	
	public Livro(String nNome, int ncodigo){
		Nome = nNome;
		codigo = ncodigo;
		emprestado = false;
	}
	
	public String getNome(){
		return Nome;
	}
	
	public int getcodigo(){
		return codigo;
	}
	
	public boolean isEmrpestado(){
		return emprestado;
	}
	
	public void emprestar (){
		emprestado = true;
	}
	
	public boolean devolver(){
		return emprestado;
	}
	
}
