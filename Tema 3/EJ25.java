import java.util.Scanner;

//Menú de 4 opciones (tabla, producto por suma, num comprendido y salir)
//1-2 son los ejercicios anteriores      3 es mostrar valores comprendidos entre n1 y n2
//4 salir

public class EJ25 {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("|        Elige una opción         |");
        System.out.println("|=================================|");
        System.out.println("| 1. Tabla de multiplicar         |");
        System.out.println("| 2. Producto de sumas            |");
        System.out.println("| 3. Mostrar números comprendidos |");
        System.out.println("| 4. Salir                        |");
        System.out.println("===================================");
        System.out.print("\nOpción: ");
        int opcion;
        
        do{
        opcion = kb.nextInt();
        if(opcion<1 || opcion>4) System.out.print("ERROR\nIntroduce un valor válido: ");
        }while(opcion<1 || opcion>4);

        switch(opcion){
        case 1:
            System.out.print("\nIntroduce un número para saber su tabla de multiplicar: ");
            int n=kb.nextInt();
            kb.close();
    
            for(int x=1; x<=10; x++)  
            System.out.println(n+" x "+x+"= "+ n*x);

            break;
        
        case 2:
            System.out.print("\nIntroduce un primer valor a multiplicar:  ");
            int n1=kb.nextInt();

            System.out.print("Introduce un segundo valor a multiplicar: ");
            int n2=kb.nextInt();
            kb.close();

            int resultado=0;
            for(int x=0; x<n2; x++)
                resultado+=n1;

            System.out.println("El resultado de "+ n1 +" x "+ n2 +" es "+ resultado);
                
            break;

        case 3:
            System.out.print("\nIntroduce un primer valor: ");
            int v1=kb.nextInt();
            System.out.print("Introduce un segundo valor: ");
            int v2=kb.nextInt();
            
            int save;
            if (v2>v1){
                save=v1;
                v1=v2;
                v2=save;
            }

            for(int x=v2+1; x<v1; x++)
                System.out.print(x+"\t");
            
            break;

        case 4:
            break;
        }
    }
}
