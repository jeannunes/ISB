package xerox;

public class Card {
	
	private int code, credits, copies;
	
	Card(int code, int credits){
		this.code = code;
		this.credits = credits;
	}
	
	public int getCode(){
		return this.code;
	}
	
	public int getCredits(){
		return this.credits;
	}
	
	public int getCopies(){
		return this.copies;
	}
	
	public void addCredits(int credits){
		this.credits += credits;
	}
	
	public boolean useCredits(int credits) throws OutOfCreditsException {
		if (this.credits >= credits) {
			this.credits -= credits;
			this.copies += credits;
		} else {
			throw new OutOfCreditsException("Você não tem saldo suficiente para realizar esta operação!");
		}
		return true;
	}

}
