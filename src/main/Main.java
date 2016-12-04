package main;

import java.util.Scanner;

import FactoryMethod.FactoryAutomato;

public class Main {

	public static void main(String[] args) {
		
		FactoryAutomato factory = new FactoryAutomato();
		Scanner ler = new Scanner(System.in);
		boolean acabou=false;
		while(acabou==false){
			System.out.println("------------------------------------------------------------");
			System.out.println("informe a Palavra:");
			String palavra = ler.nextLine();
			System.out.println("------------------------------AnB2n------------------------------");
			String tipo = "anb2n";
			factory.getPalavra(palavra, tipo);
			System.out.println("------------------------------Palindromo------------------------------");
			tipo = "palindromo";
			factory.getPalavra(palavra, tipo);
			System.out.println("------------------------------------------------------------");
			System.out.println("Deseja Testar outra palavra? Caso nao deseje, digite n:");
			if(ler.nextLine().equals("n")){
				acabou=true;
			}
		}
		System.out.println("------------------------------------------------------------");
		ler.close();
		
	}
}
