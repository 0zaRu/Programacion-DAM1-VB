package Tema_4;
import java.util.Scanner;

public class T4EJ17_4 {
	
	static Scanner kb = new Scanner(System.in);
	
	public static void main (String[] args) {
		
		System.out.print("Introuce A (Ax^2 + Bx + C): ");
		int a=rellenar();
		System.out.print("Introuce B (Ax^2 + Bx + C): ");
		int b=rellenar();
		System.out.print("Introuce C (Ax^2 + Bx + C): ");
		int c=rellenar();
		kb.close();		
		
		Raiz r1 = new Raiz();
		Raiz r2 = new Raiz(); 

		if(raices(a, b, c, r1, r2))
			System.out.print("la primera raiz es: "+r1.valor+"\nLa segunda raiz es: "+r2.valor);
		else
			System.out.println("El discriminante es negativo\nNo existen raices reales.");
	}
	
	static boolean raices(int a, int b, int c, Raiz r1, Raiz r2){
		boolean devolver=true;
		double dis=Math.pow(b, 2)-4 * a * c;

		if (dis<0)
			devolver=false;
		else{
			r1.valor = (-b + Math.sqrt(dis)) / 2 * a;
			r2.valor = (-b - Math.sqrt(dis)) / 2 * a;
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
	double valor;
}
