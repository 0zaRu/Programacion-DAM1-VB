import java.util.Scanner;

public class T5EJ9 {
    public static void main(String[] args){
        Scanner kb=new Scanner(System.in);

        System.out.print("Introduce una cadena de caracteres (frase): ");
        String cadena=kb.nextLine();
        kb.close();

        System.out.println("\n");

        for(int x=0; x<cadena.length(); x++)
            System.out.print(cadena.charAt(x)+" ");
    }    
}