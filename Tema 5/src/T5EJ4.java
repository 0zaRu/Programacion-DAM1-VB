import java.util.Random;

public class T5EJ4 {
    static final int CANT_VECT= 20;
    static final int NUM_MAX = 100;
    public static void main(String[] args){
        Random rand = new Random();        
        int vector[]= new int[rand.nextInt(CANT_VECT-5)+5];
        
        for(int x=0; x<vector.length; x++)
        vector[x]=rand.nextInt(NUM_MAX);

        System.out.println("\n");
        posicion_mayor(vector);
    }    

    static void posicion_mayor(int vector[]){
        int posicion=0;
        
        for(int x=1; x<vector.length; x++){
            
            if(vector[x] > vector[posicion])
                posicion=x;
        }
        
        System.out.println("Los valores que se habían cargado son:");
        
        for(int x=0, cont=0; x<vector.length; x++, cont++){
            System.out.print("P"+x+"= "+vector[x]+"  ||  ");
            
            if(cont==5){
                System.out.println();
                cont=0;
            }
        }

        System.out.println("\n\nEl valor mayor es "+vector[posicion]+", en la posición "+posicion+" del vector.");
    }
}
