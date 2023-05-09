package Tema_4;
import java.util.Scanner;
import java.util.Random;

//7 o 11 gana
//2, 3 o 12 pierde
//4, 5, 6, 8, 9 o 10 se sigue. Numero igual al primero se gana. 7 se pierde.
//Enter para seguir los pasos
//Módulo para seguir jugando y otro para tirar los dados
//Numero de partidas jugadas, ganas y perdidas.

public class T4EJ18 {
	
	static final int MAX=12;
	static final int MIN=2;
	static final int LIMPIAR=50;
	
	static Scanner kb=new Scanner(System.in);
	static Random rand=new Random();
	
	public static void main (String[] args) {
		
		boolean seguir=true, salir=false;
		int valor;
		int rondas=0, ganadas=0, perdidas=0;
		int valor1;
		
		do{
			System.out.println("Tira los dados con enter.");
			kb.nextLine();
			
			valor=tirar();
			rondas+=1;
			
			if (valor==7 || valor==11){
				System.out.println("HAS GANADO!!\nHas sacado un "+valor);
				ganadas+=1;
				seguir=jugar(rondas, ganadas, perdidas);
			}
			else if (valor==2 || valor==3 || valor==12){
				System.out.println("HAS PERDIDO!!\nHas sacado un "+valor);
				perdidas+=1;
				seguir=jugar(rondas, ganadas, perdidas);
			}
			else{
System.out.println();
				valor1=valor;
				do{
					System.out.println("Has sacado un "+valor+", vuelve a tirar.");
					kb.nextLine();
								
					valor=tirar();
					
					if(valor==valor1){
						System.out.println("HAS GANADO!!\n Has sacado un "+valor);
						ganadas+=1;
						seguir=jugar(rondas, ganadas, perdidas);
						salir=true;
					}
					else if(valor==7){
						System.out.println("HAS PERDIDO!!\n Has sacado un "+valor);		
						perdidas+=1;
						seguir=jugar(rondas, ganadas, perdidas);
						salir=true;
					}	
				}while(!salir);
			}

		if(!seguir)	kb.close();
			else salir=false;
		
		}while(seguir);		
	}
	
	
	
	static int tirar(){
	
	int valor = rand.nextInt(MAX-MIN+1)+MIN;
	return valor;
	}
	


	static boolean jugar(int rondas, int ganadas, int perdidas){
		
		System.out.println("\n\nSe han jugado: "+ rondas + " rondas.");
		System.out.println("Se han ganado: "+ ganadas + " rondas.");
		System.out.println("Se han perdido: "+ perdidas + " rondas.");
		
		System.out.println("Quieres seguir jugando? Y/N: ");
		int flag=kb.nextLine().charAt(0);
		
		if(flag=='Y' || flag=='y'){ 
			for(int x=0; x<LIMPIAR; x++)
				System.out.println();

			return true;}
		return false;
	}
}

