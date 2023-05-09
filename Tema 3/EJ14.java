import java.util.Scanner;

//Suma hasta n>200 y post suma hasta el 0. Contemplar posibilidad de 0 antes que n>200

public class EJ14 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce valores aleatorios (200 para pasar y 0 para salir): ");
        System.out.print("\nV1: ");
        int n=teclado.nextInt();

        int x, s1, s2;
        boolean bandera=false;
        s1=s2=0;

        for(x=0; n!=0; x++){

            if(bandera==false && n>200) {
                bandera=true;
                s2-=n;
                x--;
                System.out.println("||El numero introducido es mayor a 200, se cambia a la segunda suma||");
            }
            
            if(bandera==false) s1+=n; 
            else s2+=n;

            System.out.print("V"+(x+2)+": ");   
            n=teclado.nextInt();
            if(n==0) teclado.close();
        }
        
        if(s2==0)System.out.println("Se ha introducido 0 antes de n>200:\nNumeros introducidos: "+x+"\nSuma: "+s1);
        else System.out.println("Numeros introducidos: "+x+"\nSuma antes de n>200: "+s1+"\nSuma después de n>200: "+s2);

    }
}
