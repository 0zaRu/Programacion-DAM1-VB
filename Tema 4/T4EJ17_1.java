package Tema_4;
import java.util.Scanner;

public class T4EJ17_1 {
	
	static Scanner kb = new Scanner(System.in);
	
	public static void main (String[] args) {
		
		System.out.print("Introuce A (Ax^2 + Bx + C): ");
		int a=rellenar();
		System.out.print("Introuce B (Ax^2 + Bx + C): ");
		int b=rellenar();
		System.out.print("Introuce C (Ax^2 + Bx + C): ");
		int c=rellenar();
		kb.close();		
		
		Raiz_boolean raices = new Raiz_boolean(); 
		raices=raices(a, b, c);
		
		if(raices.raiz_real)
			System.out.print("la primera raiz es: "+raices.r1+"\nLa segunda raiz es: "+raices.r2);
		else
			System.out.println("El discriminante es negativo\nNo existen raices reales.");
	}
	
	static Raiz_boolean raices(int a, int b, int c){
		Raiz_boolean raiz = new Raiz_boolean();

		double dis=Math.pow(b, 2)-4 * a * c;

		if (dis<0)
			raiz.raiz_real=false;
		else{
			raiz.r1 = (-b + Math.sqrt(dis)) / 2 * a;
			raiz.r2 = (-b - Math.sqrt(dis)) / 2 * a;
		}
		return raiz;
	}
	
	static int rellenar(){
	int v;

		v=kb.nextInt();

	return v;
    }
}

class Raiz_boolean{
	double r1;
	double r2;
	boolean raiz_real=true;
}
