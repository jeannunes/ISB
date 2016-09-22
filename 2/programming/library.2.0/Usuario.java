import java.util.ArrayList;

public class Usuario {

	private int id;
	private String nome, senha;
	private ArrayList livrosEmprestados;
	private static final int MAXLIVROS = 3;
	
	public Usuario(int id, String nome, String senha){
		setId(id);
		setNome(nome);
		setSenha(senha);
	}
	
	public int getId() {
		return id;
	}
	protected boolean setId(int nId) {
		if (nId > 0) {
			id = nId;
			return true;
		}
		return false;
	}
	public String getNome() {
		return nome;
	}
	public boolean setNome(String nNome) {
		if (nNome.length() > 0 && nNome.length() < 255) {
			nome = nNome;
			return true;
		}
		return false;
	}
	public String getSenha() {
		return senha;
	}
	public boolean setSenha(String nSenha) {
		if (nSenha.length() > 0 && nSenha.length() <= 6) {
			senha = nSenha;
			return true;
		}
		return false;
	}
	
	public boolean emprestarLivro(Livro nLivro) {
		if(livrosEmprestados.size() < MAXLIVROS){
			if(nLivro != null){
				livrosEmprestados.add(nLivro);
			return true;
			}
		}
		return false;
	}
	
}
