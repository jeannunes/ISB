import java.util.ArrayList;

public class Urna {
	
	private ArrayList<Vereador> vereadores;
	private ArrayList<Prefeito> prefeitos;
	private ArrayList<Eleitor> eleitores;
	private ArrayList<Administrador> administradores;
	private boolean votacaoAberta;
	
	public Urna(){
		
		vereadores = new ArrayList();
		prefeitos = new ArrayList();
		eleitores = new ArrayList();
		administradores = new ArrayList();
		votacaoAberta = false;
		
	}
	
	public boolean cadastrarVereador(Vereador vereador){
		if (this.votacaoAberta == false) {
			this.vereadores.add(vereador);
			return true;
		}
		return false;
	}
	
	public boolean cadastrarPrefeito(Prefeito prefeito){
		if (this.votacaoAberta == false) {
			this.prefeitos.add(prefeito);
			return true;
		}
		return true;
	}
	
	public boolean cadastrarEleitor(Eleitor eleitor){
		if (this.votacaoAberta == false) {
			this.eleitores.add(eleitor);
			return true;
		}
		return false;
	}
	
	public boolean cadastrarAdministrador(Administrador administrador){
		if (this.votacaoAberta == false) {
			this.administradores.add(administrador);
			return true;
		}
		return false;
	}
	
	public boolean logar(int codigo, int senha){
		Administrador temp;
		int cont;
		
		for(cont = 0; cont < administradores.size(); cont++){
			temp = administradores.get(cont);
			if (temp.getCodigo() == codigo && temp.getSenha() == senha) {
				return true;
			}
		}
		if (cont == administradores.size()) {
			return false;
		} else {
			return true;
		}
	}
	
	public Eleitor buscarEleitor(int numero){
		Eleitor temp;
		int cont;
		
		for(cont = 0; cont < eleitores.size(); cont++){
			temp = eleitores.get(cont);
			if (temp.getTitulo() == numero) {
				return temp;
			}
		}
		return null;
	}
	
	public Prefeito buscarPrefeito(int numero){
		Prefeito temp;
		int cont;
		
		for(cont = 0; cont < prefeitos.size(); cont++){
			temp = prefeitos.get(cont);
			if (temp.getNumero() == numero) {
				return temp;
			}
		}
		return null;
	}
	
	public Vereador buscarVereador(int numero){
		Vereador temp;
		int cont;
		
		for(cont = 0; cont < vereadores.size(); cont++){
			temp = vereadores.get(cont);
			if (temp.getNumero() == numero) {
				return temp;
			}
		}
		return null;
	}
	
	public int contarEleitores(){
		return eleitores.size();
	}
	
	public int contarPrefeitos(){
		return prefeitos.size();
	}
	
	public int contarVereadores(){
		return vereadores.size();
	}
	
	public boolean iniciarVotacao(){
		if (this.validarCadastros()) {
			this.votacaoAberta = true;
			return true;
		}
		return false;
	}
	
	public boolean validarCadastros(){
		if ( this.votacaoAberta == false && this.contarEleitores() > 0 && this.contarPrefeitos() > 0 && this.contarVereadores() > 0 ) {
			return true;
		}
		return false;
	}
	
	public boolean finalizarVotacao(){
		if (this.votacaoAberta == true) {
			this.votacaoAberta = false;
			return true;
		}
		return false;
	}
	
	public boolean votarPrefeito(int numero){
		Prefeito tempP;
		tempP = this.buscarPrefeito(numero);
		return tempP.votar(numero);
	}
	
	public boolean votarVereador(int numero){
		Vereador tempP;
		tempP = this.buscarVereador(numero);
		return tempP.votar(numero);
	}
	
	public void exibirResultados(){
		int cont;
		Prefeito tempP;
		Vereador tempV;
		
		System.out.println("PREFEITOS");
		for(cont = 0; cont < prefeitos.size(); cont++){
			tempP = prefeitos.get(cont);
			System.out.println("Candidato #" + tempP.getNumero());
			System.out.println("\tNome " + tempP.getNome());
			System.out.println("\tPartido " + tempP.getPartido());
			System.out.println("\tVotos " + tempP.getVotos() + "(" + (tempP.getVotos()*100/eleitores.size()) + "%)");
		}
		
		System.out.println("VEREADORES");
		for(cont = 0; cont < vereadores.size(); cont++){
			tempV = vereadores.get(cont);
			System.out.println("Candidato #" + tempV.getNumero());
			System.out.println("\tNome " + tempV.getNome());
			System.out.println("\tPartido " + tempV.getPartido());
			System.out.println("\tVotos " + tempV.getVotos() + "(" + (tempV.getVotos()*100/eleitores.size()) + "%)");
		}
		
		
	}

}
