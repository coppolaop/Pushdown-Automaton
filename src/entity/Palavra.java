package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Palavra {

	private String palavra;
	private Stack<Character> pilha = new Stack<>();
	private List<Character> lista = new ArrayList<>();
	
	public Palavra() {
		
	}

	public Palavra(String palavra) {
		super();
		this.palavra = palavra;
	}



	public Palavra(String palavra, Stack<Character> pilha, List<Character> lista) {
		super();
		this.palavra = palavra;
		this.pilha = pilha;
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Palavra [palavra=" + palavra + ", pilha=" + pilha + ", lista="
				+ lista + "]";
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public Stack<Character> getPilha() {
		return pilha;
	}

	public void setPilha(Stack<Character> pilha) {
		this.pilha = pilha;
	}

	public List<Character> getLista() {
		return lista;
	}

	public void setLista(List<Character> lista) {
		this.lista = lista;
	}
}
