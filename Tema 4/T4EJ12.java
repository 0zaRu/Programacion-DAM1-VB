package Tema_4;
import java.util.Scanner;

//producto por sumas

public class T4EJ12{

	static Scanner kb=new Scanner(System.in);

	public static void main(String[] args){
		
		System.out.print("Introduce el primer valor a multiplicar: ");
		int v1=rellenar();
		
		System.out.print("Introduce el segundo valor a multiplicar: ");
		int v2=rellenar();
		kb.close();
		
		System.out.println("El producto de " + v1 + " x " + v2 + " es: " + producto_sumas(v1, v2));
	}
	
	static int producto_sumas(int n1, int n2){
		int producto=0;
		
		for(int x=0; x<n2; x++)
			producto+=n1;
		
		return producto;
	}
	
    static int rellenar(){
		int v;
        
        do{
            v=kb.nextInt();
            if(v<1) System.out.print("ERROR || Prueba un valor entero positivo: ");
        }while(v<1);

        return v;
    }


}
