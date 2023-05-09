import java.util.Scanner;

//Leer entero positivo t determinar si es perfecto (suma de divisores sin contarle = a el mismo)

public class EJ23{
    public static void main(String[] args){
        Scanner kb=new Scanner(System.in);

        System.out.print("Introduce un valor entero positivo: ");
        int v, s=0;
        do{ v=kb.nextInt();     
            if(v<1) System.out.print("ERROR\nIntroduce un valor entero positivo:");
        }while(v<1);
        kb.close();

        for(int x=1; x<v; x++)
            if(v%x==0) s+=x;

        if(v==s) System.out.println("El numero "+ v +" es un número perfecto");
        else     System.out.println("El numero "+ v +" NO es un número perfecto");
    }
}