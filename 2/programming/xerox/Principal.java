package xerox;

import java.util.ArrayList;

public class Principal {
	
	public static void main(String[] args) {

		Company controller;
		Card card;
		Printer printer;
		String message;
		
		controller = new Company();
		printer = new Printer(1, 3);
		card = new Card(1, 2);
		
		if (controller.copy(2, card, printer)) 
		{
			System.out.println("Copias efetuadas com sucesso!");
			switch(card.getCredits()){
			case 0:
				message = "Voc� n�o tem mais cr�ditos. Recarregue agora mesmo!";
				break;
			case 1:
				message = "Voc� s� tem mais um cr�dito restante. Considere fazer uma recarga!";
				break;
				default:
					message = "Voc� tem " + card.getCredits() +  "cr�ditos restantes!";
					break;
			}
			System.out.println(message);
		}

		if (controller.copy(1, card, printer)) 
		{
			System.out.println("Copias efetuadas com sucesso!");
			System.out.println(card.getCredits() + " cr�ditos restantes!");
		}
		
		if (controller.copy(1, card, printer)) 
		{
			System.out.println("Copias efetuadas com sucesso!");
			System.out.println(card.getCredits() + " cr�ditos restantes!");
		}
		
	}

}
