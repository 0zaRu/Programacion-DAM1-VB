package Tema_4;
import java.util.Scanner;

public class T4EJ20 {

	static Scanner kb= new Scanner(System.in);

    public static void main(String[] args){

		System.out.print("Introduce el primer valor:  ");
		int n=rellenar();
		System.out.print("Introduce el segundo valor: ");
		int m=rellenar();
		kb.close();
		
		System.out.println("El MCD entre "+n+" y "+m+" es: "+mcd(n, m));
	}
	
	static int mcd(int n, int m){
		
		if(m==0) return n;
		
		return mcd(m, n%m);
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
