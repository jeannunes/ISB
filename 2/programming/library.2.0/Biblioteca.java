import java.util.ArrayList;

public class Biblioteca {

	private int ultimoAluno;
	private ArrayList<Aluno> alunos;
	private ArrayList<Professor> professores;
	private ArrayList<Livro> livros;
	
	public Biblioteca(){
		
		alunos = new ArrayList();
		professores = new ArrayList();
		livros = new ArrayList();
		
	}
	
	public boolean cadastrarAluno(Aluno nAluno){
		ultimoAluno ++;
		nAluno.setId(ultimoAluno);
		alunos.add(nAluno);
		return true;
	}
	
	public boolean cadastrarProfessor(Professor nProfessor){
		professores.add(nProfessor);
		return true;
	}
	
	public boolean cadastrarLivro(Livro nLivro){
		livros.add(nLivro);
		return true;
	}
	
	public boolean emprestarLivro(int codigoLivro, int codigoAluno){

		int i;
		Livro temp;
		
		temp = livros.get(codigoLivro);
		
		return false;
		
	}
	
	public void listarAlunos(){

		int i;
		Aluno temp;
		
		System.out.println("Lista de Alunos");
		
		for(i = 0; i < alunos.size(); i++){
			temp = alunos.get(i);
			System.out.println("Código: " + temp.getId());
			System.out.println("Nome: " + temp.getNome());
		}
		
	}
	
	public void listarProfessores(){

		int i;
		Professor temp;
		
		System.out.println("Lista de Professores");
		
		for(i = 0; i < professores.size(); i++){
			temp = professores.get(i);
			System.out.println("Código: " + temp.getId());
			System.out.println("Nome: " + temp.getNome());
		}
		
	}
	
	public void listarLivros(){

		int i;
		Livro temp;
		
		System.out.println("Lista de Livros");
		
		for(i = 0; i < livros.size(); i++){
			temp = livros.get(i);
			System.out.println("Código: " + temp.getId());
			System.out.println("Nome: " + temp.getTitulo());
		}
		
	}

}
