public class Eleitor {
	
	private int titulo, votos = 0;
	private String nome;
	
	public Eleitor(int titulo, String nome){
		this.setTitulo(titulo);
		this.setNome(nome);
	}
	
	public int getTitulo() {
		return titulo;
	}
	public boolean setTitulo(int titulo) {
		if (titulo > 999 && titulo < 100000) {
			this.titulo = titulo;
		}
		return false;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setVotos(){
		this.votos++;
	}
	public int getVotos(){
		return this.votos;
	}

}