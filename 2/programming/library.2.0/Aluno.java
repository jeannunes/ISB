import java.util.ArrayList;

public class Aluno extends Usuario {
	
	private String curso;

	Aluno(int id, String nome, String senha){
		super(id, nome, senha);
	}
	
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
