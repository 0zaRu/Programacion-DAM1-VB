package Tema_4;
import java.util.Scanner;

public class T4EJ3 {
    
    static Scanner kb=new Scanner(System.in);

    public static void main(String[] args){
        
        System.out.print("Introduce el primer valor (entero positivo): ");
        int v1=rellenar();
        
        System.out.print("Introduce el segundo valor (entero positivo): ");
        int v2=rellenar();
        kb.close();

        System.out.println("\nEl valor mayor es "+maximo(v1, v2));
    }

    static int maximo(int a, int b){
    
        if(a>b) return a;
        return b;
        
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
