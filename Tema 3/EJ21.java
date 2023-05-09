import java.util.Scanner;

//Hacer versión: OPTIMIZABLE COMPROBANDO EL NUMERO MAYOR PARA HACER EL BUCLE MENOR VECES

//Hacer una multiplicacion con sumas

public class EJ21 {
    public static void main(String[] args){
        Scanner kb=new Scanner(System.in);
        
        System.out.print("Introduce un primer valor a multiplicar:  ");
        int n1=kb.nextInt();

        System.out.print("Introduce un segundo valor a multiplicar: ");
        int n2=kb.nextInt();
        kb.close();

        int resultado=0;
        for(int x=0; x<n2; x++)
            resultado+=n1;

        System.out.println("El resultado de "+ n1 +" x "+ n2 +" es "+ resultado);
    }
}