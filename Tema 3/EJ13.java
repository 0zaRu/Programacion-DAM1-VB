import java.util.Scanner;

//Calcular factorial

public class EJ13 {
    public static void main(String[] args){
        Scanner kb=new Scanner(System.in);

        System.out.print("Introduce un numero real para calcular su factorial: ");
        int n=kb.nextInt();
        kb.close();

        int f=1;
        for(int x=2; x<=n; x++)
            f*=x;

            System.out.println(n+"! = "+f);
    }
}
