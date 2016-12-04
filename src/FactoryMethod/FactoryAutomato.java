package FactoryMethod;

import entity.Anb2n;
import entity.Palavra;
import entity.Palindromo;

public class FactoryAutomato {

	public Palavra getPalavra(String palavra, String tipo){
		
		if(tipo.equalsIgnoreCase("palindromo")){
			return new Palindromo(palavra);
		}
		if(tipo.equalsIgnoreCase("anb2n")){
			return new Anb2n(palavra);
		}
		return null;
	}
}
