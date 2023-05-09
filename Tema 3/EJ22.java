import java.util.Scanner;

//Pedir valores (salir con 999) Mostrar la media de los numeros sin contar el valor de escape.

public class EJ22{
    public static void main(String[] args){
        Scanner kb=new Scanner(System.in);

        System.out.println("Introduce valores para hacer su media (999 para salir): ");
        float s=0;
        for(int x=0, v=0; v!=999; x++){

            System.out.print("V"+(x+1)+": ");
            v=kb.nextInt();

            if(v!=999)
                s+=v;
            else{
                System.out.println("La media de los números introducidos es: "+s/x);
                kb.close();
            }
        }
    }
}