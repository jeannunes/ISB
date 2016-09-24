import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Urna urna;
		Vereador vereador;
		Prefeito prefeito;
		Eleitor eleitor;
		String nome, partido;
		boolean votacaoIniciada;
		int numero;
		int menu = 0;
		Scanner scan = new Scanner(System.in);
		
		urna = new Urna();

		do {
			
			System.out.println("URNA ELETRONICA");
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Cadastrar Prefeitos (" + urna.contarPrefeitos() + ")");
			System.out.println("2 - Cadastrar Vereadores (" + urna.contarVereadores() + ")");
			System.out.println("3 - Cadastrar Eleitores (" + urna.contarEleitores() + ")");
			
			if (urna.validarCadastros()) {
				System.out.println("4 - Iniciar Votação");
				System.out.println("5 - Sair");
			} else {
				System.out.println("4 - Sair");
			}
			
			menu = scan.nextInt();
			
			if (menu == 1) {
				
				System.out.println("Digite o nome do candidato a Prefeito:");
				nome = scan.next();
				System.out.println("Digite o partido do candidato a Prefeito:");
				partido = scan.next();
				System.out.println("Digite o numero do candidato a Prefeito:");
				numero = scan.nextInt();
				prefeito = new Prefeito(nome, partido, numero);
				urna.cadastrarPrefeito(prefeito);
				
			} else if (menu == 2) {
				System.out.println("Digite o nome do candidato a Vereador:");
				nome = scan.next();
				System.out.println("Digite o partido do candidato a Vereador:");
				partido = scan.next();
				System.out.println("Digite o numero do candidato a Vereador:");
				numero = scan.nextInt();
				vereador = new Vereador(nome, partido, numero);
				urna.cadastrarVereador(vereador);
			} else if (menu == 3) {
				System.out.println("Digite o nome do eleitor:");
				nome = scan.next();
				System.out.println("Digite o numero do titulo do eleitor:");
				numero = scan.nextInt();
				eleitor = new Eleitor(numero, nome);
				urna.cadastrarEleitor(eleitor);
			} else if ( urna.validarCadastros() && menu == 4) {
				System.out.println("A votação será iniciada.");
				urna.iniciarVotacao();
				
				do {
					
					System.out.println("1 - Incluir Voto");
					System.out.println("2 - Encerrar Votação");
					
				} while(false);
				
			}
			
			
		} while( menu > 0 && ( (urna.validarCadastros() && menu != 5) || (urna.validarCadastros() == false && menu != 4) ) );
		

	}

}
