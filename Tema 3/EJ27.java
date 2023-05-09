import java.util.Scanner;

//Medio rombo de asteriscos de altura pedida por teclado

public class EJ27{
    public static void main (String[] args){
        Scanner kb=new Scanner(System.in);

        System.out.print("Introduce la cantidad de líneas del rombo: ");
        int altura=kb.nextInt();
        kb.close();
        int blanco=altura;
        int texto=0;

        for(int x=0; x<altura; x++){
        
            for(int y=0; y<=blanco; y++)
                System.out.print(" ");    

            for(int z=0; z<=texto; z++)
                System.out.print("*");
        
            System.out.print("\n");
            blanco-=1;
            texto+=2;
        }
    }
}