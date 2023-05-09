import java.util.Scanner;
//REHACER CON ARRAYS
//Ordenar 3 valores introducidos

public class EJ12 {
    public static void main(String[] args){
        Scanner kb=new Scanner(System.in);

        System.out.print("Introduce el primer valor a comparar: ");
        int n1=kb.nextInt();
        System.out.print("Introduce el segundo valor a comparar: ");
        int n2=kb.nextInt();
        System.out.print("Introduce el tercer valor a comparar: ");
        int n3=kb.nextInt();
        kb.close();

        int save;
        if(n1<n2){
            save=n1;
            n1=n2;
            n2=save;
        }
        if(n1<n3){
            save=n1;
            n1=n3;
            n3=save;
        }
        if(n2<n3){
            save=n2;
            n2=n3;
            n3=save;
        }
    
        System.out.println(n1+" > "+n2+" > "+n3);
    }
}
