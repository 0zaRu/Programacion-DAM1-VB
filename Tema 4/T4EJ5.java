package Tema_4;
import java.util.Scanner;

public class T4EJ5 {
	
	static Scanner kb=new Scanner(System.in);
	
	public static void main (String[] args) {
		
		System.out.print("Introduce el primer valor (entero positivo): ");
        int v1=rellenar();
        
        System.out.print("Introduce el segundo valor (entero positivo): ");
        int v2=rellenar();
        
        System.out.print("Introduce el tercer valor (entero positivo): ");
        int v3=rellenar();
        kb.close();
        
        System.out.println(orden(v1, v2, v3));
	}
	
	
	static String orden(int n1, int n2, int n3){
	
		if(n1>=n2 && n2>=n3) return "Los valores están ordenados";
		return "Los valores NO están ordenados";
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

