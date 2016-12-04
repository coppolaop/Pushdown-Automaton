package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Palindromo extends Palavra {
	
	
	public Palindromo(String palavra) {
		super(palavra);
		verifica();
	}
	
	public Palindromo(String palavra, Stack<Character> pilha,
			List<Character> lista) {
		super(palavra,pilha,lista);
		verifica();
	}

	public void encheLista(){
		List<Character> list = new ArrayList<Character>();
		
		if(getPalavra().length()%2 == 0){
			System.out.println("a palavra foi adicionada na lista com # marcando seu meio");
			for(int i = 0; i<getPalavra().length()/2;i++){
				list.add(getPalavra().charAt(i));
			}
			list.add('#');
			for(int i = getPalavra().length()/2; i<getPalavra().length();i++){
				list.add(getPalavra().charAt(i));
			}
		}
		else{
			System.out.println("a palavra foi adicionada na lista com # substituindo a letra do meio");
			for(int i = 0; i<(getPalavra().length()-1)/2;i++){
				list.add(getPalavra().charAt(i));
			}
			list.add('#');
			for(int i = (getPalavra().length()+1)/2; i<getPalavra().length();i++){
				list.add(getPalavra().charAt(i));
			}
		}
		setLista(list);
	}
	
	public boolean verifica(){
		setPalavra(getPalavra().toLowerCase());
		encheLista();
		Stack<Character> stack = new Stack();
		List<Character> list = getLista();
		boolean meio = false;
		for(Character c : list){
			if(c == '#'){
				meio = true;
				System.out.println("alcançou o meio");
			}else if(meio == false){
				stack.push(c);
				System.out.println("adicionou "+c+" na pilha");
			}else{
				Character letra = stack.pop();
				System.out.println("Removeu "+letra+" da pilha");
				if(!letra.equals(c)){
					System.out.println("o proximo valor da lista era "+c+", porem o valor na pilha era "+letra);
					System.out.println("A Palavra nao e um Palindromo!");
					return false;
				}
			}
		}
		if(stack.isEmpty()){
			System.out.println("A Palavra e um Palindromo!");
			setPilha(stack);
			setLista(list);
			return true;
		}else{
			System.out.println("A lista continua cheia e nao ha mais entrada");
			System.out.println("A Palavra nao e um Palindromo!");
			setPilha(stack);
			setLista(list);
			return false;
		}
		
	}

	public static void main(String[] args) {
		Palindromo p = new Palindromo("Arara",null,null);
		p.setPalavra("arara");
		p.verifica();
	}
}
