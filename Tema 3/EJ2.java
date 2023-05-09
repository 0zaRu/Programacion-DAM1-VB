import java.util.Scanner;

public class EJ2 {
	
	public static void main (String[] args) {
	
	Scanner kb = new Scanner(System.in);
	
	System.out.print("Escribe el radio de tu circunferencia: ");
	float r = kb.nextFloat();
	kb.close();
	
	System.out.println("\nEl radio introducido es "+r);
	System.out.println("La longuitud de la circunferencia es: "+ 2*Math.PI*r);
	System.out.println("El area de la circunferencia es: "+ Math.PI*Math.pow(r, 2));
	}
}

