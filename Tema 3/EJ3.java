import java.util.Scanner;

public class EJ3 {
	public static void main (String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Introduce los coeficientes de una ecuación de 2º grado (Ax^2 + Bx + C): ");
		System.out.print("\nCoeficiente A: ");
			float a = kb.nextInt();
			
		System.out.print("\nCoeficiente B: ");
			float b = kb.nextInt();		
			
		System.out.print("\nCoeficiente C: ");
			float c = kb.nextInt();
		kb.close();	
			
		float dis=(float)Math.pow(b, 2)-4 * a * c;

		if (dis<0)
			System.out.println("El discriminante es negativo\nNo existen raices reales.");
		else{
			double r1 = (-b + Math.sqrt(dis)) / 2 * a;
			double r2 = (-b - Math.sqrt(dis)) / 2 * a;
		
			System.out.print("la primera raiz es: "+r1+"\nLa segunda raiz es: "+r2);
		}
	}
}

