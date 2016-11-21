package xerox;

public class OutOfInkException extends Exception{

	private String msg;
	
	OutOfInkException(String msg){
		this.msg = msg;
	}
	
	public String getError(){
		return this.msg;
	}
	
}