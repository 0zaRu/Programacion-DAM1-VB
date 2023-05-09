import java.util.Scanner;

//Medio rombo de numeros correspondientes a su posición de altura pedida por teclado
//1234321

public class EJ28{
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

            
            for(int z=0, valor=0; z<=texto; z++){

                if(z<=texto/2)valor++;
                else valor--;
                System.out.print(valor);
            }
        
            System.out.print("\n");
            blanco-=1;
            texto+=2;
        }
    }
}
