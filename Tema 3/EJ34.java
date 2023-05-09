import java.util.Scanner;

public class EJ34 {
    static final int COL=144;
    public static void main(String[] args) throws InterruptedException{
        Scanner kb=new Scanner(System.in);
        kb.useDelimiter(System.getProperty("line.separator"));

//=========================================================DECLARACIÓN DE DATOS===================================================================================
        int abajo=54, arriba=0, izquierda=0; //derecha=COL-2;
        char mov;

        
/*==================================JUEGO BÁSICO SIN VECTORES===================================

            for(int x=1; x>0; x++){    
//            Thread.sleep(800);
                for(int y=0; y<COL; y++)
            System.out.print("=");

            System.out.println();

            System.out.println("W A S D para moverte");

            for(int y=0; y<arriba;y++){
                for(int z=0; z<COL-1;z++)
                    System.out.print(".");
                System.out.println();
            }
            
            for(int y=0; y<izquierda; y++)
                System.out.print(".");

            System.out.print("X");

            for(int y=0; y<derecha; y++)
                System.out.print(".");

            System.out.println();
            
            for(int y=0; y<abajo; y++){
                for(int z=0; z<COL-1;z++)
                    System.out.print(".");
                System.out.println();
            }
 */

//==================================RELLENAR VECTORES===========================================
            for(int x=0; x<COL; x++){}



//====================================================================INPUT TECLADO===============================================================================

            for(int y=0; y<COL; y++)
            System.out.print("=");

            System.out.println();

            mov=kb.next().charAt(0);
            if((mov=='W' || mov=='w') && arriba!=0) {
                arriba-=1;
                abajo +=1;
            }
            else if((mov=='A' || mov=='a') && izquierda!=0) {
                izquierda-=1;
            }
            else if((mov=='D' || mov=='d') && izquierda<=COL) {
                izquierda+=1;
                //derecha-=1;
            }
            else if((mov=='S' || mov=='s') && abajo !=0) {
                arriba+=1;
                abajo -=1;
            }
            else {
                kb.close();
//              break;
//            }
        }
    }
}
