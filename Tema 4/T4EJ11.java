package Tema_4;
import java.util.Scanner;

//metodo "tabla" recibe entero y muestra tabla de multiplicar.
//Usar ese metodo para mostrar las 10 primeras tablas

public class T4EJ11{
	public static void main(String[] args){
		Scanner kb=new Scanner(System.in);
		kb.useDelimiter(System.getProperty("line.separator"));
		
		System.out.print("Introduce un valor entero: ");
		int numero = kb.nextInt();
		
		mostrar_tabla(numero);
		
		System.out.println("\nQuieres ver todas las tablas de multiplicar hasta el 10? (Y/N): ");
		char flag=kb.next().charAt(0);
		kb.close();
		
		if(flag=='Y' || flag=='y')
			for(int x=1; x<=10; x++)
				mostrar_tabla(x);
	
	}

	static void mostrar_tabla(int n){
		
		System.out.println();
		for(int x=1; x<=10; x++)
			System.out.println(n + " x " + x + " = " + n*x);
	}
}
