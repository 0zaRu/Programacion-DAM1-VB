package Tema_4;
import java.util.Scanner;

public class T4EJ25 {
	
	static Scanner kb = new Scanner(System.in);
	
	public static void main (String[] args) {
		System.out.print("Introduzca un numero: ");
		int numero=rellenar();
		kb.close();
		
		int primo=primo_inmediato(numero);
		if(numero == primo)
			System.out.println("El "+numero+" es un numero primo.");
		else
		System.out.println("El numero primo inmediatamente inferior de "+numero+" es: "+primo);
		
	}
	static int primo_inmediato(int n){
		
		int dev = 0;
		
		for(int x=n; x>0; x--){
			if(esPrimo(x)){
				dev=x;
				break;
			}
		}
		return dev;		
	}
	
	static boolean esPrimo(int n){
		
		boolean esprimo=true;
		
		for(int x=2; x<n/2; x++)
			if(n%x==0) esprimo=false;
		
		return esprimo;
	}

    static int rellenar(){
        int v;

        //Bucle para rellenar y obligar a que el valor sea positivo
        do{
            v=kb.nextInt();
            if(v<1) System.out.print("ERROR || Prueba un valor entero positivo: ");
        }while(v<1);

        return v;
    }

}

	
