import java.util.Arrays;

public class Calendario {

	private int [] dias;
	
	public Calendario(){
		this.dias = new int[30];
	}

	public Calendario(int total){
		this.dias = new int[total];
	}
	
	public void addDia(int index, int temperatura){
		this.dias[index-1] = temperatura;
	}
	
	public int getDia(int dia){
		return this.dias[dia-1];
	}
	
	public void mostrarCalendario(){
		int i;
		for(i = 0; i < dias.length; i++){
			System.out.println( (i+1) + " = " + dias[i]);
		}
	}
	
	public void mostrarCalendario(boolean ordenado){
		int i;
		int [] temp;
		temp = new int[dias.length];
		System.arraycopy(dias, 0, temp, 0, dias.length);
		Arrays.sort(temp);
		for(i = 0; i < temp.length; i++){
			System.out.println( (i+1) + " = " + dias[i]);
		}
	}
	
	public float getMedia(){
		int i;
		float soma = 0;
		for(i = 0; i < dias.length; i++){
			soma += dias[i];
		}
		return (soma/dias.length);
	}
	
}
