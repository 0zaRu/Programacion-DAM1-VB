package Tema_4;
import java.util.Scanner;

public class T4EJ23 {
	
	static final int ESTABA_ORDENADO =    1;
	static final int NO_ESTABA_ORDENADO = 0;
	
	public static void main (String[] args) {
		Scanner kb= new Scanner(System.in);
		int[] n = new int[4];
	
		System.out.print("Introduce el primer valor: ");
		n[0] = kb.nextInt();	
		System.out.print("Introduce el segundo valor: ");
		n[1] = kb.nextInt();
		System.out.print("Introduce el tercer valor: ");
		n[2] = kb.nextInt();
		kb.close();

		//No se muy bien que se pide con "devolver valores" porque si fuesen boolean serñia redundante tener
		//un final para ello, por lo que para darle un uso (que se me ocurra) significante, utilizo un valor
		//del vector exclusivamente para marcar si se ha ordenado o no la cadena.
		
		n[3] = ESTABA_ORDENADO;
		ordena(n);
		
		if (n[3]==ESTABA_ORDENADO) System.out.println("Los numeros ya setaban ordenados de entrada.");
		else 		   System.out.println("Los numeros se han tenido que ordenar.");
		
		System.out.println("Los numeros en orden de mayor a menor son: "+n[0] +" > "+n[1]+" > "+n[2]+".");
				
	}
	
	static void ordena(int[] n){
		
		int aux;
		
		if(n[0]<n[1]){
			aux  = n[0];
			n[0] = n[1];
			n[1] = aux;
			
			n[3] = NO_ESTABA_ORDENADO;
		}
		if(n[0]<n[2]){
			aux  = n[0];
			n[0] = n[2];
			n[2] = aux;
			
			n[3] = NO_ESTABA_ORDENADO;
		}
		if(n[1]<n[2]){
			aux  = n[1];
			n[1] = n[2];
			n[2] = aux;
			
			n[3] = NO_ESTABA_ORDENADO;
			
		}
	}

}
