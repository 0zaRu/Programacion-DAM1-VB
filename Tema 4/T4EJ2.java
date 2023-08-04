package Tema_4;
import java.util.Scanner;

public class T4EJ2 {
    public static void main (String[] args) {
	
        Scanner kb = new Scanner(System.in);
        
        System.out.print("Escribe el radio de tu circunferencia: ");
        float radio = kb.nextFloat();
        kb.close();
        
        System.out.println("\nEl radio introducido es "+radio);
        System.out.println("La longuitud de la circunferencia es:\t"+ longuitud(radio));
        System.out.println("El area de la circunferencia es:\t"+ area(radio));
    }

    static double longuitud(float r){
        return 2*Math.PI*r;
    }

    static double area(float r){
        return Math.PI*Math.pow(r, 2);
    }
}
