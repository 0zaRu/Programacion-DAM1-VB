import java.util.Scanner;

//Mostrar numeros pares entre 0 y valor por teclado

public class EJ10 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.print("Introduce el numuero hasta el que se va a llegar: ");
        int tope=kb.nextInt();
        kb.close();

        for(int x=0; x<=tope; x+=2)
            System.out.println(x);
    }
}
