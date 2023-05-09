import java.util.Scanner;

//Suma de impares de 0 a n introducido por teclado

public class EJ11 {
    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);

        System.out.print("Introduce el numero tope hasta el que se va a sumar los impares: ");
        int tope = kb.nextInt();
        kb.close();

        int s=0;
        for(int x=1; x<=tope; x+=2)
            s+=x;

        System.out.println("La suma de los n impares hasta el "+tope+" es: "+s);
    }
}
