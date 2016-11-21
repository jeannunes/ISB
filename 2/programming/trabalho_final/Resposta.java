package trabalho_final;

public class Resposta {

	private int id;
	private String alternativa;
	private boolean correta;
	
	public Resposta(int id, String alternativa, boolean correta){
		this.id = id;
		this.alternativa = alternativa;
		this.correta = correta;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getAlternativa(){
		return this.alternativa;
	}
	
	public boolean getCorreta(){
		return this.correta;
	}
	
}
