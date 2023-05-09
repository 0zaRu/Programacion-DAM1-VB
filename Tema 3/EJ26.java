import java.util.Scanner;

//Solicita base y exponente y calcularlo sin usar pow

public class EJ26 {
    public static void main(String[] args){
        Scanner kb=new Scanner(System.in);

        System.out.print("Introduce la base: ");
        int b=kb.nextInt();
        System.out.print("Introduce la potencia: ");
        int p=kb.nextInt();
        kb.close();

        int r=1;
        for(int x=1; x<=p; x++)
            r*=b;

        System.out.println(b+"^"+p+" = "+r);
    }
}
