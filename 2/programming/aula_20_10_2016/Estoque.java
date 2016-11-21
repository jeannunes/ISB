package aula_20_10_2016;

import java.util.ArrayList;

public class Estoque {

	private int capacidade;
	private ArrayList<BicicletaPasseio> bPasseio;
	private ArrayList<BicicletaCarga> bCarga;
	
	public Estoque(int capacidade){
		this.capacidade = capacidade;
		bPasseio = new ArrayList<BicicletaPasseio>();
		bCarga = new ArrayList<BicicletaCarga>();
	}
	
	public boolean addEstoque(BicicletaCarga bicicleta){
		if (this.bCarga.size() < this.capacidade) {
			this.bCarga.add(bicicleta);
			return true;
		}
		return false;
	}
	
	public boolean addEstoque(BicicletaPasseio bicicleta){
		if (this.bPasseio.size() < this.capacidade) {
			this.bPasseio.add(bicicleta);
			return true;
		}
		return false;
	}
	
	public ArrayList<BicicletaCarga> mostrarEstoque(){
		return this.bCarga;
	}
	
}
