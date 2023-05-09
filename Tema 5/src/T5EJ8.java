import java.util.Scanner;

public class T5EJ8 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.print("Introduce la altura del triángulo que quieres: ");
        int altura = kb.nextInt();
        kb.close();

        int tri[][] = new int[altura][];

        instanciar_triangulo(tri);
        rellenar_triangulo(tri);
        mostrar_matriz(tri);
    }

    //*Método para instanciar una matriz con forma triangular de 2 elementos más por línea */
    static void instanciar_triangulo(int[][] tri){
        
        for(int x=0, y=1; x<tri.length; x++, y+=2)
            tri[x] = new int[y];
    }

    //*Método para rellenar una matriz con forma triangular de 2 elementos más por línea */
    static void rellenar_triangulo(int[][] tri){
            
        for(int x=0; x<tri.length; x++)
            for(int y=0, n=1; y<tri[x].length; y++){

                tri[x][y]=n;
                if(y<tri[x].length/2) n++;
                else                  n--;                    
            }
    }

    //*Método para mostrar una matriz de columnas irregulares */
    static void mostrar_matriz(int[][] matriz){

        System.out.println("\nLa matriz resultante es: ");
        System.out.println("========================\n");

        for(int x=0; x<matriz.length; x++){
            for(int y=0; y<matriz[x].length; y++)
                System.out.print(matriz[x][y]);
        
            System.out.println();
        }
        System.out.println("\n\n");

    }
}