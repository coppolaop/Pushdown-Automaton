package entity;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Anb2n extends Palavra{
	
	public Anb2n() {
		verifica();
	}
	
	public Anb2n(String palavra) {
		super(palavra);
		verifica();
	}
	
	public Anb2n(String palavra, Stack<Character> pilha,
			List<Character> lista) {
		super(palavra,pilha,lista);
	}
	
	public boolean empilhar(){
		List<Character> list = new ArrayList<>();
		Stack<Character> stack = new Stack<>();
		int i;
		for(i = 0; i<getPalavra().length();i++){
			if(getPalavra().charAt(i) == 'a'){
				stack.push(getPalavra().charAt(i));
				System.out.println("a foi adicionado a pilha");
			}else if(getPalavra().charAt(i) == 'b'){
				break;
			}else{
				return false;
			}
		}
		for(int j=i;j<getPalavra().length();j++){
			if(getPalavra().charAt(j)=='a'){
				break;
			}else if(getPalavra().charAt(j)=='b'){
				list.add('b');
			}else{
				return false;
			}
		}
		setPilha(stack);
		setLista(list);
		return true;
	}
	
	public boolean verifica(){
		boolean ok = empilhar();
		if(ok == true){
			Stack<Character> stack = getPilha();
			List<Character> list = getLista();
			int aux = 0;
			boolean par = false;
			Character letra;
			for(Character c : list){
				if(par==false){
					try{
						letra = stack.pop();
						System.out.println(letra+ " foi removido da pilha");
						par = true;	
					}catch(EmptyStackException ex){
						stack.add('a');
					}
				}else{
					par = false;
				}
				aux++;
			}
			list.clear();
			if(par==true){
				list.add('b');
			}
			setPilha(stack);
			setLista(list);
			//System.out.println(getPilha().isEmpty()+ " "+getLista().isEmpty());//teste
			if(getPilha().isEmpty()&&getLista().isEmpty()){
				System.out.println("a Palavra e um AnB2n");
				return true;
			}else{
				System.out.println("a Palavra nao e um AnB2n");
				return false;
			}
		}else{
			System.out.println("a Palavra nao e um AnB2n");
			return false;
		}
	}
	
	public static void main(String[] args) {
		Anb2n a = new Anb2n("aaabbbbbb");
		a.verifica();
	}
}