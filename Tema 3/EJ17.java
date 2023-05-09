import java.util.Scanner;

// Saber si el caracter introducido es letra, numero o caracter especial

public class EJ17 {
    public static void main(String[] args){
        Scanner kb=new Scanner(System.in);
        kb.useDelimiter(System.getProperty("line.separator"));

        System.out.print("Introduce un caracter: ");
        char c=kb.next().charAt(0);
        kb.close();

        if((int)c>64 && (int)c<=90 || (int)c>96 && (int)c<=122)
            System.out.println("El caracter '"+c+"' es una letra");
      
        else if((int)c>47 && (int)c<=57)
            System.out.println("El caracter '"+c+"' es un número");
        
        else
            System.out.println("El caracter '"+c+"' es un caracter especial");
    }
}