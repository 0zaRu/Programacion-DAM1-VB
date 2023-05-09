import java.util.Scanner;

public class PEJ1 {
	
	public static void main (String[] args) {
		Scanner teclado = new Scanner(System.in);
		teclado.useDelimiter(System.getProperty("line.separator"));

		int v1, v2;
		char x;
		boolean flag=false;
		do{

		System.out.print("Introduce el primer sumando (numero real): ");
		v1 = teclado.nextInt();

		System.out.print("Introduce el primer sumando (numero real): ");
		v2 = teclado.nextInt();	
		
		
		System.out.println("\nLa suma de "+v1+" y "+v2+" es: "+ (v1+v2));

		System.out.println("¿Quieres introducir otra suma? Y/N: ");
		x=teclado.next().charAt(0);
		
		if(x=='n' || x=='N') flag=true;
		}while(!flag);
		teclado.close();
	}
}