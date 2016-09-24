public class Administrador {
	
	private int codigo, senha;
	private String nome;
	
	public Administrador(int codigo, String nome, int senha){
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setSenha(senha);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public boolean setCodigo(int codigo) {
		if ( codigo > 0 ) {
			this.codigo = codigo;
			return true;
		}
		return false;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
