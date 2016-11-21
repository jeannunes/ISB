package aula_20_10_2016;

public class Loja {

	public static void main(String[] args) {
		
		Estoque estoque = new Estoque(30);
		BicicletaCarga bCarga;
		BicicletaPasseio bPasseio;
		
		bCarga = new BicicletaCarga(1814, 6, 1, 2, "Caloi", 300);
		estoque.addEstoque(bCarga);
		
		bCarga = new BicicletaCarga(2244, 6, 1, 2, "Biciclo", 300);
		estoque.addEstoque(bCarga);
		
		bPasseio = new BicicletaPasseio(5634, 12, 2, 16, 0, true, "Biciclo", 450);
		estoque.addEstoque(bPasseio);
		
		bPasseio = new BicicletaPasseio(2876, 6, 1, 12, 1, true, "Caloi", 450);
		estoque.addEstoque(bPasseio);

	}

}
