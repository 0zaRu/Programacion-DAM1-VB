package Tema_4;
import java.util.Scanner;

public class T4EJ24_B {
	
	static final int CIFRAS = 8;
	static final int V_MAX  = 99999999;	
	static Scanner kb = new Scanner(System.in);
	
	public static void main (String[] args) {
		
		System.out.print("Introduce un numero menor a "+CIFRAS+" cifras: ");
		int n=rellenar();
		kb.close();
		
		int[] valores = new int[CIFRAS];
		int cant_cifras = descomponer_numero(n, valores);
		
		System.out.print("\nSe ha introducido el numero: "+n+".\nTiene "+cant_cifras+ " cifras.\nSeparadas son:\t");
		for(int x=CIFRAS-cant_cifras; x<=CIFRAS-1; x++)
			System.out.print(valores[x]+"\t");
	}
	
	static int descomponer_numero(int n, int[] valores){
		int longitud=0;
			
		for(int x=CIFRAS-1; x>=0; x--){
			valores[x] = n%10;
			longitud+=1;	
			
			if(n/10<1)
				break;
				
			n/=10;
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

