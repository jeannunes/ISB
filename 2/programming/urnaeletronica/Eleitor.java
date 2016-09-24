public class Eleitor {
	
	private int titulo;
	private String nome;
	private Voto voto;
	
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

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}
	
	
	

}
