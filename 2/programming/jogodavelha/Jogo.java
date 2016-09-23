import java.util.Scanner;

public class Jogo {
	
	private static Jogador A, B, vencedor;
	private static Tabuleiro tabuleiro;
	private static int ultimoJogador = 1;
	
	public static void main(String[] args) {
		
		int menu;
		String nomeJogador;
		char simbolo;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("JOGO DA VELHA");
		System.out.println("Escoha uma opção");
		
		System.out.println("1 - Jogar");
		System.out.println("2 - Sair");
		
		menu = scan.nextInt();
		
		if ( menu == 1 ) {
			
			System.out.println("Digite o nome do jogador 1:");
			nomeJogador = scan.next();
			System.out.println("Digite o simbolo que será usado por este jogador:");
			simbolo = scan.next().charAt(0);
			A = new Jogador(nomeJogador, simbolo);
			
			System.out.println("Digite o nome do jogador 2:");
			nomeJogador = scan.next();
			System.out.println("Digite o simbolo que será usado por este jogador:");
			simbolo = scan.next().charAt(0);
			B = new Jogador(nomeJogador, simbolo);
			
			tabuleiro = new Tabuleiro();
			
			
			
		}
		
	}

}
