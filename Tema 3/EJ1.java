import java.util.Scanner;

public class EJ1 {
	public static void main (String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce el primer sumando: ");
		int v1 = teclado.nextInt();
		System.out.print("Introduce el primer sumando: ");
		int v2 = teclado.nextInt();	
		teclado.close();
		
		System.out.println("\nLa suma de "+v1+" y "+v2+" es: "+ (v1+v2));
	}
}

