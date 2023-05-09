package t9ej1;
import java.util.Scanner;
import java.util.Stack;

public class T9ej1 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Introduce una frase a invertir: ");
		String frase = kb.nextLine();
		kb.close();
		System.out.println("La frase invertida es: "+ invertir(frase));
	}
	
	/**
	 * Invierte un String con pila.
	 * @param frase String a invertir.
	 * @return frase String invertido.
	 */
	static String invertir(String frase) {
		
		Stack<Character> inv = new Stack<Character>();
		
		for (int i = 0; i < frase.length(); i++) {
			inv.push(frase.charAt(i));
		}
		
		frase = "";
		
		while(inv.size() != 0)
			frase += inv.pop();
		
		return frase;
	}
}