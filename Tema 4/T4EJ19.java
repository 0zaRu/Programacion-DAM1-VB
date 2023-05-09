package Tema_4;
import java.util.Scanner;

public class T4EJ19 {

	static Scanner kb= new Scanner(System.in);

    public static void main(String[] args){

		System.out.print("Introduce una base: ");
		int b=rellenar();
		System.out.print("Introduce un exponente: ");
		int e=rellenar();
		kb.close();
		
		System.out.println("El resultado de elevar "+ b +"^"+e+" es: "+elevar_recursivo(b, e));
	}
	
	static int elevar_recursivo(int base, int exponente){

		if(exponente==0) return 1;
		
		return base*elevar_recursivo(base, exponente-1);		
	}
	
	static int rellenar(){
		int v;

		do{
			v=kb.nextInt();
			if(v<0) System.out.print("ERROR || Prueba un valor entero no negativo: ");
		}while(v<0);

		return v;
	}
}
