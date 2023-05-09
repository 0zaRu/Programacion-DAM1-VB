import java.util.Arrays;
import java.util.Scanner;

public class T5EJ6 {
    static final int NUM_FIL = 4;
    static final int NUM_COL = 3;

    static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {

        //Aunque podría hacer "matriz" una fila y columna mas grande para guardar ahí las sumas,
        //haré 2 vectores por separado que lo amacenen para seguir más de cerca lo propuesto por el enunciado
        int matriz[][] = new int[NUM_FIL][NUM_COL];
        
        int suma_fil[] = new int[NUM_FIL];
        Arrays.fill(suma_fil, 0);
        
        int suma_col[] = new int[NUM_COL];
        Arrays.fill(suma_col, 0);
        
        System.out.println("Rellene la matriz de tamaño "+NUM_FIL+" x "+NUM_COL+": ");
        rellenar_matriz(matriz);
        kb.close();

        sumar_fil_col(matriz, suma_fil, suma_col);
        
        mostrar_matriz(matriz);
        mostrar_suma(suma_fil, suma_col);
    }
    
    
    //*Rellenar una matriz dada desde el main */
    static void rellenar_matriz(int[][] matriz){
        
        for(int x=0; x<matriz.length; x++)
            for(int y=0; y<matriz[x].length; y++){

                System.out.print("P["+(x+1)+"]["+(y+1)+"]: ");
                matriz[x][y]=kb.nextInt();
            }

    }
    
    //*Sumar las filas y las columnas de una matriz dada en 2 vectores diferentes también dados */
    static void sumar_fil_col(int[][] matriz, int[] suma_fil, int[] suma_col){
        
        for(int x=0; x<matriz.length; x++){
            for(int y=0; y<matriz[x].length; y++){
                suma_fil[x]+=matriz[x][y];
                suma_col[y]+=matriz[x][y];
            }
        }
    }
    
    //*Mostrar una matriz dada desde el main */
    static void mostrar_matriz(int[][] matriz){

        System.out.println("\n\nLa matriz introducida es: ");
        System.out.println("=========================\n");

        for(int x=0; x<matriz.length; x++){
            for(int y=0; y<matriz[x].length; y++)
                System.out.print("   "+matriz[x][y]+"\t||");
        
            System.out.println();
        }
        System.out.println("\n\n");
    }
    
    //*Mostrar 2 vectores dados desde el main */
    static void mostrar_suma(int[] suma_fil, int[] suma_col){
    
        System.out.println("La suma de las filas es: ");
        for(int x=0; x<suma_fil.length; x++)
            System.out.print("F"+(x+1)+": "+suma_fil[x]+"\t");

        System.out.println("\n\nLa suma de las columnas es: ");
        for(int x=0; x<suma_col.length; x++)
            System.out.print("C"+(x+1)+": "+suma_col[x]+"\t");    
    
        System.out.println();
    }
}