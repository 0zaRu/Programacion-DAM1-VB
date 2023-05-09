import java.util.Scanner;

//Pedir valor entero en decimal y enseñar su binario, octal y hexadecimal

public class EJ30 {
    public static void main(String[] args){
        Scanner kb= new Scanner(System.in);

        System.out.print("Introduce un valor entero decimal: ");
        int n=kb.nextInt();
        kb.close();

        String binario = Integer.toBinaryString(n);
        System.out.println("El numero decimal "+n+" en binario es "+binario);
        String octal = Integer.toOctalString(n);
        System.out.println("El numero decimal "+n+" en octal es "+octal);
        String hexa = Integer.toHexString(n);
        System.out.println("El numero decimal "+n+" en hexadecimal es "+hexa);

    }    
}
