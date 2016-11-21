package xerox;

import java.util.ArrayList;

public class Company {
	
	private ArrayList<Card> cards;
	private ArrayList<Printer> printers;

	public void addPrinter(Printer printer){
		this.printers.add(printer);
	}
	
	public void addCard(Card card){
		this.cards.add(card);
	}
	
	public boolean copy(int total, Card card, Printer printer){
		try {
				card.useCredits(total);
				printer.copy(total);
		} catch(OutOfCreditsException error){
			System.out.print(error.getError());
			return false;
		} catch(OutOfInkException error){
			System.out.print(error.getError());
			return false;
		}
		return true;
	}

}