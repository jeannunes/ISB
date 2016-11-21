package trabalho_final;

import java.util.ArrayList;

public class Pergunta {
	
	private int id;
	private String pergunta;
	private ArrayList<Resposta> respostas;
	
	public int getId(){
		return this.id;
	}
	
	public String getPergunta(){
		return this.pergunta;
	}
	
	public ArrayList<Resposta> getRespostas(){
		return this.respostas;
	}
	
	public int getRespostaCorreta(){
		Resposta resposta;
		for(int i = 0; i < respostas.size(); i++){
			resposta = respostas.get(i);
			if (resposta.getCorreta()) {
				return resposta.getId();
			}
		}
		return -1;
	}

}
