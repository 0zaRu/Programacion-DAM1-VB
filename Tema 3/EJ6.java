import java.util.Scanner;

//Dada la nota del alumno, imprima esta considerando <5 Sus   5-7 A   7-9 N   9-<10 Sobre   10 M
//Detectar valor incorrecto introducido

public class EJ6 {
    static final float MAX=10;
    static final float MIN=0;
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        
        System.out.print("Introduce la nota del alumno: ");
        
        float nota;
        do{ nota = kb.nextFloat();
        if (nota<MIN || nota>MAX) System.out.print("\nERROR, introduce una nota entre 0 y 10: ");
        }while(nota<MIN || nota>MAX);
        kb.close();

        System.out.println("\nLa nota del alumno es: "+ nota);
        if(nota<5) System.out.println("SUSPENSO");
        else if (nota>=5 && nota<7) System.out.println("APROBADO");
        else if (nota>=7 && nota<9) System.out.println("NOTABLE");
        else if (nota>=9 && nota<10) System.out.println("SOBERSALIENTE");
        else System.out.println("MATRÍCULA DE HONOR");

    }
}
