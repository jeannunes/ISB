
public class Principal {

	public static void main(String[] args){
		
		Biblioteca biblioteca;
		biblioteca = new Biblioteca();
		
		Aluno aluno;
		Professor professor;
		Livro livro;
		
		aluno = new Aluno(0, "Jean", "123");
		biblioteca.cadastrarAluno(aluno);
		
		aluno = new Aluno(0, "Lucas", "321");
		biblioteca.cadastrarAluno(aluno);
		
		biblioteca.listarAlunos();
		
		professor = new Professor(1, "Emerson", "321");
		biblioteca.cadastrarProfessor(professor);
		
		professor = new Professor(2, "Isabela", "123");
		biblioteca.cadastrarProfessor(professor);
		
		biblioteca.listarProfessores();
		
		livro = new Livro(1, "Harry Potter");
		biblioteca.cadastrarLivro(livro);
		
		livro = new Livro(2, "Jogos Vorazes");
		biblioteca.cadastrarLivro(livro);
		
		biblioteca.listarLivros();
		
		biblioteca.emprestarLivro(1, 1);
		
	}

}
