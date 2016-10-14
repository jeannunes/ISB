public class Principal {

	
	public static void main(String[] args) {

			Calendario dias;
			dias = new Calendario(5);
			
			// Adicionar dias ao calendário
			dias.addDia(5, 10);
			dias.addDia(1, 6);
			dias.addDia(3, 4);
			dias.addDia(2, 10);
			dias.addDia(4, 19);
			
			// Exibir a média
			System.out.println("Media: " + dias.getMedia());
			
			// Imprimir o calendário na tela
			System.out.println("Calendário");
			dias.mostrarCalendario();
			
			// Imprimir o calendário ordenado pela temperatura
			System.out.println("Calendário Ordenado");
			dias.mostrarCalendario(true);

	}

}
