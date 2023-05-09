// Generar enteros de 3 en 3 desde 2 y hasta un valor maximo<20 muestre sus sumas.
// Al final mostrar la suma de numeros que sean divisibles por 5.

public class EJ20 {
    static int TOPE=20;
    public static void main(String[] args){

        int x, acumulador, s; 

        for(x=2, acumulador=1, s=0; x<TOPE; x++, acumulador++){

            s+=x;
            if(acumulador==3){
                System.out. println((x-2)+"+"+(x-1)+"+"+x+" = "+s);
                s=acumulador=0;
            }
        }

        System.out.println("======================");

        for(x-=acumulador, s=0; x>2; x--){          
//pongo x-=acumulador porque si se editase el tope a otro número, pidiendo usar solo numeros generados,
//se crean varias x más hasta llegar al tope que no se usan, coincidiendo con el valor del acumulador.

            if(x%5==0) s+=x;
        }
        System.out.println("La suma de los números divisibles entre 5 es: "+s);
    }
}
