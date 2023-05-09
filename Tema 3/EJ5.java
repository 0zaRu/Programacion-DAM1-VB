import java.util.Scanner;
//Nota mínima de 5 en T. Si aprueba, el 70% final será Teoría 30% Práctica

public class EJ5 {
    static final int NMIN=5;

    public static void main (String[] args){
        Scanner kb = new Scanner (System.in);
        
        System.out.print("Introduce tu nota teórica: ");
        float t = kb.nextFloat();
        if(t<NMIN) System.out.println("Tu nota teórica es menor a 5\nSUSPENSO");
        else{
            System.out.print("\nItroduce tu nota práctica: ");
            float p =kb.nextFloat();
            
            System.out.println("Siendo tu nota teórica "+t+" y practica "+p+"\nTu nota final es: "+ (t*0.7+p*0.3));
        }
        kb.close();
    }
}
