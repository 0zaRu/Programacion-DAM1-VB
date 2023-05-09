import java.util.Scanner;

//V aleatorios hasta meter 0. Ver v introducidos, >secuencia de repes y el v repe.

public class EJ15 {
    public static void main (String[] args) {
        Scanner kb=new Scanner(System.in);

        System.out.println("Introduce valores aleatorios: (0 para salir)");        
        System.out.print("\nV1: ");
        int v=kb.nextInt();

        int cont, v_ant, n_temp=0, n_final=0, c_final=0, c_temp=0;
        v_ant=v;
        
        for(cont=0; v!=0; cont++){
            if(v==v_ant){n_temp=v; c_temp+=1;}
            else c_temp=1;

            if(c_temp>=c_final) {c_final=c_temp; n_final=n_temp;}
            v_ant=v;

            System.out.print("V"+(cont+2)+": ");
            v=kb.nextInt();

            if(v==0)kb.close();
        }
        System.out.println("Se han introducido "+ cont+
                           " numeros\nLa mayor secuencia de numeros repetidos es de "+ c_final +
                           " numeros\nEl numero más veces repetido es el "+n_final);
    }
}