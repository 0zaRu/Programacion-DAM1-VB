package Tema_4;
import java.util.Scanner;

public class T4EJ8{

	static final char MAYUSMIN='A';
	static final char MAYUSMAX='Z';
	static final char MINUSMIN='a';
	static final char MINUSMAX='z';
	static final char NUMMIN=  '0';
	static final char NUMMAX=  '9';
	
	public static void main(String[] args){
		Scanner kb=new Scanner(System.in);
			
		System.out.print("Introduce cualquier carácter del teclado para clasificarlo: ");
		char c=kb.nextLine().charAt(0);
		kb.close();
			
		System.out.println("El caracter '"+ c + "' es un/a " + ascii(c));
		
	}
	static String ascii(char c){
			
	if(c>=NUMMIN && c<=NUMMAX) return "número";
	else if ((c>=MAYUSMIN && c<=MAYUSMAX) || (c>=MINUSMIN && c<=MINUSMAX)) return "letra";
	else return "carácter especial";
		
	}
}
