package Tema_4;
import java.util.Scanner;

public class T4EJ21 {

	static Scanner kb= new Scanner(System.in);

    public static void main(String[] args){

		System.out.print("Introduce que posición de Fibonacci quieres ver (empezando en 0): ");
		int n=rellenar();
		kb.close();
		
		System.out.println("El valor de fibonacci de la posición "+n+" es: "+fibonacci_recursivo(n));
	}
	
	static long fibonacci_recursivo(int n){
		
		if(n==0) return 0;
		if(n==1) return 1;
		
		return fibonacci_recursivo(n-1) + fibonacci_recursivo(n-2);
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
