package Tema_4;
import java.util.Scanner;

public class T4EJ24_A {
	
	static final int CIFRAS = 8;
	static final int V_MAX  = 99999999;	
	static Scanner kb = new Scanner(System.in);
	
	public static void main (String[] args) {
		
		System.out.print("Introduce un numero menor a "+CIFRAS+" cifras: ");
		int n=rellenar();
		kb.close();
		
		int cant_cifras = descomponer_numero(n);
		
		System.out.print("\nSe ha introducido el numero: "+n+".\nTiene "+cant_cifras+ " cifras.");

	}
	
	static int descomponer_numero(int n){
		int longitud=0;
		int aux, copia_n=n;
		
		for(int x=CIFRAS-1; x>=0; x--){
			longitud+=1;	
			if(copia_n/10<1)
				break;
			copia_n/=10;
		}
		
		for(int x=longitud-1; x>=0; x--){
			aux = n/(int)Math.pow(10, x);
			System.out.print(aux%10+"\t");
		}
		return longitud;
	}
	
	static int rellenar(){
        int v;

		do{
            v=kb.nextInt();
            if(v<0 || v>V_MAX) System.out.print("ERROR || Prueba un valor real positivo (menor a "+V_MAX+"): ");
        }while(v<0 || v>V_MAX);

        return v;
    }
	
}

