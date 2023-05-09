
import java.util.Scanner;

public class T5EJ2{
	
	public static void main (String[] args) {
		Scanner kb=new Scanner(System.in);
		System.out.println("Introduce el numero del mes y sus días: ");
		
		int meses[][]=new int[12][2];
		
		for(int x=0; x<meses.length; x++){

			System.out.print("Nº de mes: ");
			meses[x][0]=kb.nextInt();
			System.out.print("\tNº de dias: ");
			meses[x][1]=kb.nextInt();
		}
		kb.close();
		for(int x=0; x<meses.length; x++)
			System.out.println("El mes "+meses[x][0]+" tiene "+meses[x][1]+" días");
	}
}

