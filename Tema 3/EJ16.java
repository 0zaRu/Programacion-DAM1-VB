import java.util.Scanner;

//Introducir un numero y decir si es primo

public class EJ16 {
    public static void main(String[] args){
        Scanner kb=new Scanner(System.in);

        System.out.print("Introduce un numero para saber si es primo: ");
        int n=kb.nextInt();
        
        boolean flag=false;
        for(int x=2; x<n/2 && flag==false; x++)
        if(n%x == 0) flag=true;
        
        if(flag) System.out.println(n+" no es un numero primo");
        else System.out.println(n+" es un numero primo");

        kb.close();
    }
}