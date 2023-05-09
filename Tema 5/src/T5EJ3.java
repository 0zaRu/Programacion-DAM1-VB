import java.util.Scanner;

public class T5EJ3 {
    static final int MESES = 12;
    static Scanner kb = new Scanner(System.in);
    public static void main(String[] args) {
        Mes anho[] = new Mes[MESES];

        for(int x=0; x<MESES; x++){
            anho[x]=new Mes();
            rellenar(anho[x], x);
        }

        limpiar_pantalla();

        for(int x=0; x<MESES; x++)
            imprimir(anho[x], x);
        
        kb.close();
    }

    static void rellenar(Mes anho, int x){
        System.out.println("Rellene los datos del mes nº "+(x+1)+": ");
        System.out.println("===============================");
        
        System.out.print("Nombre:\t\t\t");
        anho.nombre=kb.nextLine();

        System.out.print("Nº del mes:\t\t");
        anho.n_mes=kb.nextInt();

        System.out.print("Nº de días:\t\t");
        anho.dias=kb.nextInt();

        System.out.print("Temperatura media:\t");
        anho.temp_media=kb.nextFloat();
        kb.nextLine();
        System.out.println("\n");
    }

    static void imprimir(Mes anho, int x){
        System.out.println("Datos del mes nº "+(x+1)+": ");
        System.out.println("===================");
        
        System.out.println("Nombre:\t\t\t"+anho.nombre);
        System.out.println("Nº del mes:\t\t"+anho.n_mes);
        System.out.println("Nº de días:\t\t"+anho.dias);
        System.out.println("Temperatura media:\t"+anho.temp_media+"\n\n");
    }

    static void limpiar_pantalla(){
        for(int x=0; x<25; x++)
            System.out.println();
    }
}

class Mes{
    String nombre;
    int n_mes;
    int dias;
    float temp_media;
}
