package exercicio;

public class Principal {

	public static void main(String[] args) {
		Biblioteca biblio;
		Aluno aluno;
		Professor prof;
		
		biblio = new Biblioteca();
		aluno = new Aluno("aluno", 1);
		biblio.CadastrarAluno(aluno);
		
		prof = new Professor("prof", 1);
		biblio.CadastrarProfessor(prof);
		
		biblio.ImprimeAlunos();
		biblio.ImprimeProfessores();
		
		

	}

}
