import java.util.Scanner;

public class T5EJ12 {
	public static void main(String[] args) {
		Scanner kb=new Scanner(System.in);
		
		System.out.print("Introduce una frase: ");
		String frase=kb.nextLine();
		kb.close();
		
		System.out.println("\n" + invertir(frase));
	}
	/**Método para mayus por minus, minu por mayus y digitos por puntos*/
	static String invertir(String frase) {
		String invertido="";
		
		for(int x=0; x<frase.length(); x++) {
			
			if (frase.charAt(x)>='a' && frase.charAt(x)<='z')     invertido += (char)(frase.charAt(x)-32);
			else if(frase.charAt(x)>='A' && frase.charAt(x)<='Z') invertido += (char)(frase.charAt(x)+32);
			else if(frase.charAt(x)>='0' && frase.charAt(x)<='9') invertido += '.';
			else												  invertido += frase.charAt(x);
		}
		
		return invertido;
	}
}
