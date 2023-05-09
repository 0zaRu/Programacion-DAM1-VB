import java.util.Scanner;
import java.util.Random;

//Juego de adivinanza de n entre 0 y 999. 10 intentos
//El programa dice si está por debajo o por arriba
//Decir si ha ganado o perdido

//Usar random
public class EJ31_2 {
       
    static final int INTENTOS=10;
    static final int MAX=999;
    static final int MIN=0;

    public static void main(String[] args){

        Random aleatorio = new Random();
        Scanner kb = new Scanner(System.in);

        int valor = aleatorio.nextInt(MAX-MIN+1)+MIN;

        System.out.println("Vamos a intentar adivinar el número: ");

        for(int x=0, n; x<=INTENTOS; x++){
            if(x==INTENTOS){
                System.out.println("HAS SUPERADO LA CANTIDAD DE INTENTOS, HAS PERDIDO\nEl número era "+ valor);
                kb.close();
                break;
            }

            System.out.print("Intento "+ (x+1) +": ");
            n=kb.nextInt();

            
            if(n<valor && x<INTENTOS-1)         System.out.println("El numero a adivinar es mayor.");
            else if(n>valor && x<INTENTOS-1)    System.out.println("El numero a adivinar es menor.");
            else if(n==valor) {
                System.out.println("ENHORABUENA, HAS ACERTADO!!");
                kb.close();
                break;
            }
        }
    }    
}