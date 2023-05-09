import java.util.Scanner;

public class T5EJ15 {
    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);

        System.out.print("Introduce una frase: ");
        String frase=kb.nextLine();
        kb.close();
        
        for(int x=0; x<frase.length(); x++)
        	if(frase.charAt(x)==' ') System.out.println();
        	else 					 System.out.print(frase.charAt(x));
    }    
}
