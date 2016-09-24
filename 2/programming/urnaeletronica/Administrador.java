public class Administrador {
	
	private int codigo;
	private String senha, nome;
	
	public Administrador(int codigo, String nome, String senha){
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
	public String getSenha() {
		return senha;
	}
	public boolean setSenha(String senha) {
		if ( senha.length() == 6 ) {
			this.senha = senha;
			return true;
		}
		return false;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
