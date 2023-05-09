import java.util.Scanner;

//Sucesión de n numeros de fibonacci

public class EJ24 {
    public static void main(String[] args){
        Scanner kb=new Scanner(System.in);

        System.out.print("Introduce la cantidad de numeros de la serie que quieres ver: ");
        int v, f, n_ant=0, n=1;

        do{ v=kb.nextInt();     
            if(v<1) System.out.print("ERROR\nIntroduce un valor entero positivo >0: ");
        }while(v<1);
        kb.close();
        
        if(v>=1) System.out.print("\n" + n_ant + "\t");
        if(v>=2) System.out.print(n + "\t");
       
        for(int x=2; x<v && v>2; x++){

            f=n_ant+n;
            n_ant=n;
            n=f;
            
            System.out.print(f + "\t");
        }
    }
}
