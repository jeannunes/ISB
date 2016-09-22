package exercicio;
import java.util.ArrayList;

public class Biblioteca {
	private ArrayList<Aluno> alunos;
	private ArrayList<Professor> profs;
	private ArrayList<Livro> livros;
	
	public Biblioteca(){
		alunos = new ArrayList();
		profs = new ArrayList();
		livros = new  ArrayList();
	}
	
	public boolean CadastrarAluno(Aluno novoAluno){
		alunos.add(novoAluno);
		return true;
	}
	
	public boolean CadastrarProfessor(Professor novoProfessor){
		profs.add(novoProfessor);
		return true;
	}
	
	public boolean CadastrarLivro(Livro novoLivro){
		livros.add(novoLivro);
		return true;
	}
	
	public void ImprimeAlunos(){
		int cont;
		Aluno temp;
		
		for(cont = 0; cont < alunos.size(); cont ++){
			temp = alunos.get(cont);
			System.out.println("Nome = " + temp.getNome());
		}
	}
	
	public void ImprimeProfessores(){
		int cont;
		Professor temp;
		
		for(cont = 0; cont < profs.size(); cont ++){
			temp = profs.get(cont);
			System.out.println("Nome = " + temp.getNome());
		}
	}
	
}
