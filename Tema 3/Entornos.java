import java.util.Scanner;

public class Entornos{
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int x, y;
        System.out.print("Introduce un numero entero para descomponerlo en unidades:");
        x = kb.nextInt();
        kb.close();
        y=x;
        System.out.print("Tu numero descompuesto es:\n");
    
        System.out.print("Millar: " + y/1000);
        y=y%1000;
        System.out.print("\nCentena: " + y/100);
        y=y%100;
        System.out.print("\nDecena: " + y/10);
        y=y%10;
        System.out.print("\nUnidad: " + y);
    }
}