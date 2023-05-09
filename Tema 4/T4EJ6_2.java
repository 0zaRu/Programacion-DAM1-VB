package Tema_4;
import java.util.Scanner;

public class T4EJ6_2{
	public static void main(String[] args){
		Scanner kb=new Scanner(System.in);
		
		System.out.print("Introduce un numero para calcular su factorial: ");
		int n=kb.nextInt();
		kb.close();
		
		System.out.println("El factorial de "+ n + " es " + factorial(n));
	}
		
	static long factorial(int n){
		System.out.println("Estoy en el metodo recursivo usando\t n = "+n);
		long devolver = 0;
		if(n==0)
			devolver= 1;
		else
			devolver= n*factorial(n-1);
		
		System.out.println("Estoy devolviendo "+devolver+"\t usando el valor n = "+n);
		return devolver;
	}
}
