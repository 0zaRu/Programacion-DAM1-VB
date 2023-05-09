package t8ej9;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Introduce el numero de pisos del edificio: ");
		if(kb.nextInt() < Instituto.nMinPisos) {
			System.out.println("Tu edificio no cumple los requisitos para ser un instituto ...");
			kb.close();
			return;
		}
		
		System.out.print("Introduce el numero de aulas del edificio: ");
		if(kb.nextInt() < Instituto.nMinAulas) {
			System.out.println("Tu edificio no cumple los requisitos para ser un instituto ...");
			kb.close();
			return;
		}
		
		System.out.print("Introduce el numero de pisos del edificio: ");
		if(kb.nextInt() < Instituto.nMinPisos) {
			System.out.println("Tu edificio no cumple los requisitos para ser un instituto ...");
			kb.close();
			return;
		}
		kb.close();
		
		System.out.println("\nEnhorabuena, tu edificio cumple los requisitos mínimos para ser un instituto.");
		System.out.println("Vamos a proceder a introducir automaticamente un array de notas para probar la funcionalidad del instituto.");
		
		//float notas[] = {0.1f, 2.3f, 4.5f, 7.7f, 8.9f, 10f, 4.9f};
		/*Crear objeto de instituto para su correcto funcionamiento, de paso añadimos a
		 * Instituto las variables para el numero e cosas y lo almacenamosn en las comprobaciones anteriores
		 * para tener un objeto completo*/
		System.out.println("La cantidad de suspensos es de: "/*+ Instituto.getAprobados(notas)*/);
	}
}
