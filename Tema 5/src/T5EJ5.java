import java.util.Random;

public class T5EJ5 {
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
        int suma=0, num=0;
        float media;
        
        for(int x=0; x<vector.length; x+=2, num++)
            suma+=vector[x];

        media=(float)suma/num;

        System.out.println("Los valores que se habían cargado son:");
        
        for(int x=0, cont=0; x<vector.length; x++, cont++){
            System.out.print("P"+x+"= "+vector[x]+"\t||  ");
            
            if(cont==5){
                System.out.println();
                cont=-1;
            }
        }
        System.out.println("\n\nLa media de las posiciones pares es: "+media);
    }
}
