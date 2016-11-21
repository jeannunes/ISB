package xerox;

import java.util.ArrayList;

public class Printer {

	private int totalCopies, id, capacity;
	
	Printer(int id, int capacity){
		this.id = id;
		this.totalCopies = 0;
		this.capacity = capacity;
	}
	
	public int getId(){
		return this.id;
	}
	
	public int getCapacityLeft(){
		return (this.capacity - this.totalCopies);
	}
	
	public boolean copy(int total) throws OutOfInkException {
		if (this.totalCopies + total > capacity) {
			throw new OutOfInkException("A impressora está sem tinta. Contate o administrador ou procure outro equipamento!");
		} else {
			this.totalCopies += total;
		}
		return true;
	}

}
