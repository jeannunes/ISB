import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Urna urna;
		Vereador vereador;
		Prefeito prefeito;
		Eleitor eleitor;
		Administrador administrador;
		String nome, partido;
		boolean logado, sair = false, voto = false;
		int numero, menu = 0, admCodigo, admSenha, tempSenha, cont;
		Scanner scan = new Scanner(System.in);
		urna = new Urna();
		
		administrador = new Administrador(12345, "Jean", 654321);
		urna.cadastrarAdministrador(administrador);
		
		prefeito = new Prefeito("BRANCO", "BRANCO", 0);
		urna.cadastrarPrefeito(prefeito);
		prefeito = new Prefeito("NULO", "NULO", -1);
		urna.cadastrarPrefeito(prefeito);
		
		vereador = new Vereador("BRANCO", "BRANCO", 0);
		urna.cadastrarVereador(vereador);
		vereador = new Vereador("NULO", "NULO", -1);
		urna.cadastrarVereador(vereador);

		do {
			
			System.out.println("AUTENTICAÇÃO");
			System.out.println("Codigo:");
			admCodigo = scan.nextInt();
			System.out.println("Senha:");
			admSenha = scan.nextInt();
			logado = urna.logar(admCodigo,admSenha);
			
			if (!logado) {
				System.out.println("Código e/ou senha incorretos!");
			}
			
		} while ( logado == false );
		
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
					
					System.out.println("Digite o numero do titulo de eleitor ou 0 para sair:");
					numero = scan.nextInt();
					
					
					if (numero > 0) {
						
						eleitor = urna.buscarEleitor(numero);
						
						if (eleitor != null && eleitor.getVotos() == 0 ) {
							
							System.out.print("Eleitor: " + eleitor.getNome());
							
							// Votar para prefeito
							do {
								
								System.out.println("Digite o número do seu candidato a PREFEITO com dois digitos");
								System.out.println("ou 0 para votar em  BRANCO");
								System.out.println("ou -1 para votar NULO");
								
								numero = scan.nextInt();
								
								if (numero >= -1 && numero < 100) {
									
									prefeito = urna.buscarPrefeito(numero);
									if (prefeito != null) {
										
										System.out.println("Candidato: " + prefeito.getNome());
										System.out.println("Partido: " + prefeito.getPartido());
										
										System.out.print("Digite");
										System.out.print("1 para CONFIRMAR");
										System.out.print("2 para CORRIGIR");
										
										menu = scan.nextInt();
										if (menu == 1) {
											urna.votarPrefeito(numero);
											eleitor.setVotos();
											voto = true;
										} else if (menu == 2) {
											System.out.println("Corrija o voto!");
										} else {
											System.out.println("Opção incorreta");
										}
										
									} else {
										System.out.println("Candidato não encontrado!");
									}
									
								}
								
							} while ( voto == false );
							
							// Libera a votação para outro candidato
							voto = false;
							
							// Votar para vereador
							do {
								
								System.out.println("Digite o número do seu candidato a VEREADOR com cinco digitos");
								System.out.println("ou 0 para votar em  BRANCO");
								System.out.println("ou -1 para votar NULO");
								
								numero = scan.nextInt();
								
								if (numero >= -1 && numero < 100) {
									
									vereador = urna.buscarVereador(numero);
									if (vereador != null) {
										
										System.out.println("Candidato: " + vereador.getNome());
										System.out.println("Partido: " + vereador.getPartido());
										
										System.out.print("Digite");
										System.out.print("1 para CONFIRMAR");
										System.out.print("2 para CORRIGIR");
										
										menu = scan.nextInt();
										if (menu == 1) {
											urna.votarVereador(numero);
											eleitor.setVotos();
											voto = true;
										} else if (menu == 2) {
											System.out.println("Corrija o voto!");
										} else {
											System.out.println("Opção incorreta");
										}
										
									} else {
										System.out.println("Candidato não encontrado!");
									}
									
								}
								
							} while ( voto == false );
							
						} else {
							System.out.println("Numero de eleitor inválido ou eleitor já votou!");
						}
						
					} else {
						System.out.println("Para confirmar, digite a senha do administrador:");
						tempSenha = scan.nextInt();
						
						if (admSenha == tempSenha) {
							System.out.println("Encerrando votação.");
							sair = true;
						}
					}
							
				} while( sair == false);
				
				urna.finalizarVotacao();
				
				// Exibir os RESULTADOS
				urna.exibirResultados();
				
			}
			
			
		} while( menu > 0 && ( (urna.validarCadastros() && menu != 5) || (urna.validarCadastros() == false && menu != 4) ) );
		

	}

}
