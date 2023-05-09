package Tema_4;
import java.util.Scanner;

//Un nombre, el número de horas semanales que se imparten, el nombre del profesor,
//la calificación obtenida en ella y una letra que la identifique

public class T4EJ10{
	
	static Scanner kb=new Scanner (System.in);

	
	public static void main (String[] args) {
		kb.useDelimiter(System.getProperty("line.separator"));
		
		Asignatura a1=new Asignatura();
		
		a1=rellenar_asignatura(a1);
		kb.close();
		
		mostrar_asignatura(a1);
	}

	static Asignatura rellenar_asignatura(Asignatura n1){
			
		System.out.print("Introduce el nombre de la asignatura: ");
		n1.nombre=kb.next();
		
		System.out.print("Introduce la cantidad de horas que tiene: ");
		n1.horas=kb.nextInt();
	
		System.out.print("Introduce el nombre del profesor: ");
		n1.profesor=kb.next();
		
		System.out.print("Introduce tu nota de la asignatura: ");
		n1.nota=kb.nextFloat();
		
		System.out.print("Introduce una letra que la identifique: ");
		n1.letra=kb.next().charAt(0);
		
		return n1;
	}
	
	static void mostrar_asignatura(Asignatura a1){
		System.out.println("===================================================");
		System.out.println("El nombre de la asignatura es "+a1.nombre);
		System.out.println("La cantidad de horas es "+a1.horas);
		System.out.println("El nombre del profesor es "+a1.profesor);
		System.out.println("Tu nota en la asignatura es "+a1.nota);
		System.out.println("La letra que identica la asignatura es "+a1.letra);
		System.out.println("===================================================");
	}
}

class Asignatura{

	String nombre;
	int horas;
	String profesor;
	float nota;
	char letra;
}

