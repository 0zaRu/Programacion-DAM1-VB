package Tema_4;
import java.util.Scanner;

public class T4EJ7 {
	
	public static void main (String[] args) {
		Scanner kb=new Scanner(System.in);
		
		System.out.print("Introduce un numero para saber si es primo: ");
		int n=kb.nextInt();
		kb.close();
		
		if(primo(n))System.out.println("El valor "+n+" es primo");
		else 		System.out.println("El valor "+n+" NO es primo");
	}
	
	static boolean primo(int n){
		
		boolean esprimo=true;
		
		for(int x=2; x<n/2; x++)
			if(n%x==0) esprimo=false;
		
		return esprimo;
	}
}

