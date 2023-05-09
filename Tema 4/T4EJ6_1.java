package Tema_4;
import java.util.Scanner;

public class T4EJ6_1{
	public static void main(String[] args){
		Scanner kb=new Scanner(System.in);
		
		System.out.print("Introduce un numero para calcular su factorial: ");
		int n=kb.nextInt();
		kb.close();
		
		System.out.println("El factorial de "+ n + " es " + factorial(n));
	}
		
	static int factorial(int n){
		int ret=1;
		
		for(int x=2; x<=n; x++)
			ret*=x;
		
		return ret;
	}
}
