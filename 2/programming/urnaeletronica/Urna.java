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
		return false;
	}
	
	public boolean votarVereador(int numero){
		return false;
	}

}
