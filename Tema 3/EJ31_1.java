import java.util.Scanner;

//Juego de adivinanza de n entre 0 y 999. 10 intentos
//El programa dice si está por debajo o por arriba
//Decir si ha ganado o perdido

//Usar constante para el numero
public class EJ31_1 {
    
    static final int VALOR=777;
    static final int INTENTOS=10;
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        System.out.println("Vamos a intentar adivinar el número: ");

        for(int x=0, n; x<=INTENTOS; x++){
            if(x==INTENTOS){
                System.out.println("HAS SUPERADO LA CANTIDAD DE INTENTOS, HAS PERDIDO");
                kb.close();
                break;
            }

            System.out.print("Intento "+ (x+1) +": ");
            n=kb.nextInt();

            
            if(n<VALOR && x<INTENTOS-1)         System.out.println("El numero a adivinar es mayor.");
            else if(n>VALOR && x<INTENTOS-1)    System.out.println("El numero a adivinar es menor.");
            else if(n==VALOR) {
                System.out.println("ENHORABUENA, HAS ACERTADO!!");
                kb.close();
                break;
            }
        }
    }    
}