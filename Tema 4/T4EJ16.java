package Tema_4;
import java.util.Scanner;



public class T4EJ16{
	
	static Scanner kb=new Scanner(System.in);
	
	public static void main (String[] args) {
	
	System.out.print("Introduce la posición x de la esquina superior izquierda: ");
	int x1=rellenar();
	System.out.print("Introduce la posición y de la esquina superior izquierda: ");
	int y1=rellenar();
	System.out.print("Introduce la posición x de la esquina inferior derecha: ");
	
	int x2;
	do{
		x2=rellenar();
		if(x2<=x1) System.out.print("ERROR||\nIntroduce una posición x mayor a la de x1="+x1+": ");

	}while(x2<=x1);
	System.out.print("Introduce la posición y de la esquina inferior derecha: ");
	
	int y2;
	do{
		y2=rellenar();
		if(y2>=y1) System.out.print("ERROR||\nIntroduce una posición y menor a la de y1="+y1+": ");
	}while(y2>=y1);
	kb.close();
	
	System.out.println();
	
	cuadro(x1, y1, x2, y2);
	}
	
	static void cuadro(int x1, int y1, int x2, int y2){
		
		for(int x=y1; x>=y2; x--){
			
			if(x1!=0)
				System.out.print("|");
			
			for(int y=1; y<x1; y++)
				
				if(x==y1)System.out.print(".");
				else     System.out.print(" ");
				
			System.out.print("|");

			for (int y=x1+1; y<x2; y++)

				if(x==y1 || x==y2)System.out.print("=");
				else              System.out.print(" ");
			
			System.out.print("|\n");
		}
		
		for (int x=y2-1; x>=0; x--){
			if (x==0){ 
				System.out.print("0");
				for(int y=1; y<=x2;y++)
					System.out.print("-");
			}
			else{
				System.out.print("|");

				for(int y=1; y<x2; y++)
					System.out.print(" ");
				
				System.out.print(".\n");
			}
		}
		
		System.out.println("\n\nPosición superior izquierda: ("+x1+", "+y1+")\nPosición inferior derecha:   ("+x2+", "+y2+")");
	}
	
	static int rellenar(){
	int v;

	//Bucle para rellenar y obligar a que el valor sea positivo
	do{
		v=kb.nextInt();
		if(v<0) System.out.print("ERROR || Prueba un valor entero positivo: ");
	}while(v<0);

	return v;
    }
}

