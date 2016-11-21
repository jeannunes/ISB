package trabalho_final;

import java.util.ArrayList;

public class JPool {

	private ArrayList<Pergunta> perguntas;
	
	public boolean addPergunta(Pergunta pergunta){
		return this.perguntas.add(pergunta);
	}
	
	public boolean conferirResposta(int perguntaId, int respostaId){
		Pergunta pergunta;
		pergunta = this.getPerguntaById(perguntaId);
		if (pergunta.getRespostaCorreta() == respostaId) {
			return true;
		}
		return false;
	}
	
	public Pergunta getPerguntaById(int id){
		Pergunta pergunta;
		for(int i = 0; i < perguntas.size(); i++){
			pergunta = perguntas.get(i);
			if (pergunta.getId() == id) {
				return pergunta;
			}
		}
		return null;
	}
	
}