import java.util.Scanner;

public class T5EJ7 {
    static Scanner kb=new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Considerando dos matrices, N x M y M x P:");
        System.out.print("Introduce N: ");
        int n = kb.nextInt();
        System.out.print("Introduce M: ");
        int m = kb.nextInt();
        System.out.print("Introduce P: ");
        int p = kb.nextInt();

        int m1[][] = new int[n][m];
        int m2[][] = new int[m][p];
        int m3[][] = new int[n][p];	//Matriz resultado
        
        System.out.println("\n\nIntroduce los datos de la primera matriz: ");
        rellenar_matriz(m1);
        System.out.println("\n\nIntroduce los valores de la segunda matriz: ");
        rellenar_matriz(m2);
        kb.close();

        multiplicar_matrices(m1, m2, m3);

        System.out.println("\n\nEl resultado de la multiplicación es: ");
        System.out.println("=====================================\n");
        mostrar_matriz(m3);
    }
    
    //*Rellenar por teclado una matriz dada desde el main */
    static void rellenar_matriz(int[][] matriz){

        for(int x=0; x<matriz.length; x++)
            for(int y=0; y<matriz[x].length; y++){

                System.out.print("P["+(x+1)+"]["+(y+1)+"]: ");
                matriz[x][y]=kb.nextInt();
            }

    }

    //*Módulo para multiplicar 2 matrices no necesariamente cuadradas, m1, m2 y m_resultado */
    static void multiplicar_matrices(int[][] m1, int[][] m2, int[][] m3){

        for(int x=0; x<m3.length; x++)             //con este for nos movemos por las filas de matriz a rellenar
            for(int y=0; y<m3[x].length; y++)      //con este for nos movemos por las columnas de la matriz a rellenar
                for(int z=0; z<m2.length; z++)     //con este for nos movemos en F[i] de m1 y C[j] de m2 por los valores a multiplicar
                    m3[x][y] += m1[x][z]*m2[z][y]; //x marca la fila que multiplicamos, y la columna, y z el valor de cada
                                                   //de las fil. y col. de las matrices que vamos multiplicando
    }

    //*Mostrar una matriz dada desde el main */
    static void mostrar_matriz(int[][] matriz){

        for(int x=0; x<matriz.length; x++){
            for(int y=0; y<matriz[x].length; y++)
                System.out.print("  "+matriz[x][y]+"\t||");
        
            System.out.println();
        }
        System.out.println("\n\n");
    }
}