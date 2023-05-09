import java.util.Scanner;

//Tabla de multiplicar de un numero

public class EJ18 {
    public static void main(String[] args){
        Scanner kb=new Scanner(System.in);

        System.out.print("Introduce un número para saber su tabla de multiplicar: ");
        int n=kb.nextInt();
        kb.close();

        for(int x=1; x<=10; x++)
            System.out.println(n+"x"+x+"= "+ n*x);
    }
}