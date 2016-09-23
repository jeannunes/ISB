public class Tabuleiro {

	private Peca[][] campos; 
	
	public Tabuleiro(){
		campos = new Peca[3][3];
	}

	public boolean adicionarPeca(Peca p, int linha, int coluna){
		linha--;
		coluna--;
		
		if ( (linha >= 0 && linha < campos.length) && (coluna > 0 && coluna < campos[linha].length) ) {
			
			if (campos[linha][coluna] == null) {
				campos[linha][coluna] = p;
				return true;
			}
			
		}
		
		return false;
	}
	
	public void mostrarTabuleiro(){
		
	}
	
}
