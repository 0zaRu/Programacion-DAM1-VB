package Tema_4;
import java.util.Scanner;

//base y exponente metodo

public class T4EJ13{

	static Scanner kb=new Scanner(System.in);

	public static void main(String[] args){
		
		System.out.print("Introduce la base: ");
		int base=rellenar();
		
		System.out.print("Introduce el exponente: ");
		int exponente=rellenar();
		kb.close();
		
		System.out.println("El resultado de elevar " + base + " a " + exponente + " es: " + elevar(base, exponente));
	}
	
	static int elevar(int b, int e){
		int resultado=1;
		
		for(int x=0; x<e; x++)
			resultado*=b;
		
		return resultado;
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

