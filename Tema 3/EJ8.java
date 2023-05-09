import java.util.Scanner;

//Imprimir "Prometo prestar atención en clase" 100 veces con while do while y for

public class EJ8 {
    static int TOPE=100;
    public static void main(String[] args){
        int tipo, x=0;

        Scanner kb = new Scanner(System.in);
            
        System.out.print("Quieres imprimir el texto con while(1), do-while(2) o con for(3): ");
        do{
            tipo=kb.nextInt();
            if(tipo<1||tipo>3) System.out.print("\nERROR Introduce un valor valido: ");
        }while(tipo<1 || tipo>3);
        
            kb.close();

        if (tipo==1){
//===============================================   WHILE   ===================================================
            while(x<TOPE){
                System.out.println((x+1)+". Prometo prestar atención en clase");
                x++;
            }

        }else if (tipo==2){
// ==============================================   DO WHILE    ===============================================
            do{
                System.out.println((x+1)+". Prometo prestar atención en clase");
                x++;
            }while(x<TOPE);

        }else{
//===============================================   FOR   =====================================================
            for(x=0; x<TOPE; x++)
                System.out.println((x+1)+". Prometo prestar atención en clase");
        }
    }
}
