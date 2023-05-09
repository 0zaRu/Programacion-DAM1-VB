import java.util.Scanner;

public class T5EJ13 {
	public static void main(String[] args) {
		Scanner kb=new Scanner(System.in);
		
		System.out.print("Introduce una frase: ");
		String frase=kb.nextLine();
		kb.close();
		
		if(palindromo(frase)) System.out.print("La frase introducida es un palíndromo");
		else                  System.out.print("La frase introducida NO es un palíndromo");
	}
	
	//**Método que comprueba si una frase es un palíndromo o no sin tener en cuenta mayus y minus*/
	static boolean palindromo (String frase) {
		
		String limpia="";
		
		for(int x=0; x<frase.length(); x++) {
			if ((frase.charAt(x)>='a' && frase.charAt(x)<='z') || (frase.charAt(x)>='A' && frase.charAt(x)<='Z'))
				limpia+=frase.charAt(x);
		}
		for(int x=0, y=limpia.length()-1; x<limpia.length()/2; x++, y--)
			if(Character.toLowerCase(limpia.charAt(x)) != Character.toLowerCase(limpia.charAt(y))) return false;
		
		return true;
	}
}