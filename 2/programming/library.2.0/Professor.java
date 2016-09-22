public class Professor extends Usuario {
	
	private String materia;
	
	Professor(int id, String nome, String senha){
		super(id, nome, senha);
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	
	
}
