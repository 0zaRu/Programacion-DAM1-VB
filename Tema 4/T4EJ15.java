package Tema_4;
import java.util.Scanner;

//cambiar de minus a mayus y viceversa

public class T4EJ15{
	public static void main(String[] args){
		Scanner kb=new Scanner(System.in);
		
		System.out.print("Introduce una letra: ");
		char letra=kb.nextLine().charAt(0);
		kb.close();
		
		System.out.println("El contrario de "+ letra + " es: "+ mayus_minus(letra));
	}
	
	static char mayus_minus(char l){
	
	if(l<='Z')l+=32;
		else  l-=32;
		
	return l;
	}
	
	
}
