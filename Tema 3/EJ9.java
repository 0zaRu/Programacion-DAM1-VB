import java.util.Scanner;

//Introducir 2 numeros y decir cual es mayor

public class EJ9 {
    public static void main(String[] args){
        Scanner kb=new Scanner(System.in);
        
        System.out.print("Introduzca el primer numero:  ");
        int n1=kb.nextInt();
        
        System.out.print("Introduzca el segundo numero: ");
        int n2=kb.nextInt();
        kb.close();

        if(n1>n2) System.out.println("El numero "+n1+" es mayor que el "+ n2);
        else if(n1<n2) System.out.println("El numero "+n2+" es mayor que el "+ n1);
        else System.out.println("Los 2 numeros son iguales");
    }
}
