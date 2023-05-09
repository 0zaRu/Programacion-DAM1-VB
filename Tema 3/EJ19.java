import java.util.Scanner;

//Tabla de multiplicar de un numero pero bien hasta el 10

public class EJ19 {
    public static void main(String[] args){
        Scanner kb=new Scanner(System.in);

        System.out.print("Introduce un número para saber su tabla de multiplicar: ");
        int n=kb.nextInt();
        kb.close();

        for(int x=1; x<=20; x++){
            
            if(x<=10) System.out.println(n+" x "+x+"= "+ n*x);
            else System.out.println(n*x);
            
        }
    }
}