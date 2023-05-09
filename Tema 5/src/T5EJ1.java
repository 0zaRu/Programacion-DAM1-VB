
import java.util.Scanner;

public class T5EJ1 {
	
	static Scanner kb = new Scanner(System.in);
	
	public static void main (String[] args) {
		int n_mes[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int dias_mes[] = new int[12];
		
		System.out.println("Introduzca los dias de cada mes del año: ");
		rellenar_arrays(n_mes, dias_mes);
		
		System.out.println("\nSe van a mostrar los meses y sus días: ");
		mostrar_arrays(n_mes, dias_mes);
	}
	
	
	static void rellenar_arrays(int mes[], int dias[]){
		
		for(int i=0; i<mes.length; i++){
			System.out.print("\nMes "+(i+1)+":\t");
			dias[i]=kb.nextInt();
		}
	}
	
	static void mostrar_arrays(int mes[], int dias[]){
		
		for(int i=0; i<mes.length; i++)
			System.out.println("El mes "+mes[i]+" tiene "+dias[i]+" dias.");
	}
}

