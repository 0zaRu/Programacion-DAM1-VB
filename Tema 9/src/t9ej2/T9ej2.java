package t9ej2;
import java.util.Scanner;
import java.util.Stack;

public class T9ej2 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Introduce una frase a comprobar: ");
		String frase = kb.nextLine();
		kb.close();
		//Se ha hecho todo el proceso de adecuación en la misma línea, dentro del if
		if(esPalindromo(frase.replaceAll(" ", "").toUpperCase()))
			System.out.println("La frase introducida es un palíndromo");
		else
			System.out.println("La frase introducida NO es un palíndromo");
	}
	
	/**
	 * Determina si un String es un palíndromo.
	 * @param String a evaluar.
	 * @return true si el String palíndromo, false en otro caso.
	 */
	static boolean esPalindromo(String frase) {
		
		Stack<Character> inv = new Stack<Character>();
		
		//Se añade toda la frase a una pila
		for (int i = 0; i < frase.length(); i++)
			inv.push(frase.charAt(i));
		
		//Comparamos hasta la mitad, que coinciden los caracteres de la cima de la pila con los de la frase desde su inicio
		for(int i = 0; i < frase.length()/2; i++)
			//Si no coinciden se decuelve false
			if(inv.pop() != frase.charAt(i))
				return false;
		
		return true;
	}
}