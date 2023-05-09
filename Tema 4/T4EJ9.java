package Tema_4;
import java.util.Scanner;

public class T4EJ9{
	public static void main(String[] args){
		Scanner kb=new Scanner(System.in);
		
		System.out.print("Introduce el mensaje que quieres que salga por pantalla: ");
		String mensaje = kb.nextLine();
		
		System.out.print("Introduce la cantidad de veces que quieres que salga: ");
		int cantidad = kb.nextInt();
		kb.close();
		
		repes_mensaje(mensaje, cantidad);
	}
	static void repes_mensaje(String txt, int veces){
		
		for(int x=0; x<veces; x++)
			System.out.println((x+1)+". "+ txt);
	}
}
