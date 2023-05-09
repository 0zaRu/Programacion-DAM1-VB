package Tema_4;
import java.util.Scanner;

public class T4EJ17_3 {
	
	static Scanner kb = new Scanner(System.in);
	
	public static void main (String[] args) {
		
		System.out.print("Introuce A (Ax^2 + Bx + C): ");
		int a=rellenar();
		System.out.print("Introuce B (Ax^2 + Bx + C): ");
		int b=rellenar();
		System.out.print("Introuce C (Ax^2 + Bx + C): ");
		int c=rellenar();
		kb.close();		
		
		Raiz raices = new Raiz(); 

		if(raices(a, b, c, raices))
			System.out.print("la primera raiz es: "+raices.r1+"\nLa segunda raiz es: "+raices.r2);
		else
			System.out.println("El discriminante es negativo\nNo existen raices reales.");
	}
	
	static boolean raices(int a, int b, int c, Raiz raiz){
		boolean devolver=true;
		double dis=Math.pow(b, 2)-4 * a * c;

		if (dis<0)
			devolver=false;
		else{
			raiz.r1 = (-b + Math.sqrt(dis)) / 2 * a;
			raiz.r2 = (-b - Math.sqrt(dis)) / 2 * a;
		}
		return devolver;
	}
	
	static int rellenar(){
	int v;

		v=kb.nextInt();

	return v;
    }
}

class Raiz{
	double r1;
	double r2;
}

