package xerox;

public class OutOfCreditsException extends Exception{

	private String msg;
	
	OutOfCreditsException(String msg){
		this.msg = msg;
	}
	
	public String getError(){
		return this.msg;
	}
	
}
