package Tema_4;
import java.util.Scanner;

public class prueba {
	
	static final int COL=237;
	static final int FIL=62;
	static final int FIL_MENU=55;

//	static final int SALIR=
	
	static Scanner kb= new Scanner(System.in);
	
	public static void main (String[] args) {
		kb.useDelimiter(System.getProperty("line.separator"));
		char[][] px = new char[FIL][COL];
		rellenar_arrays(px);
		Posicion_Inicial avatar = new Posicion_Inicial();
			px[0][0]='X';

		Posicion_Inicial edit = new Posicion_Inicial();
			px[FIL_MENU-1][COL-1]='O';
			edit.espacio_abajo=0;
			edit.espacio_arriba=FIL_MENU-1;
			edit.espacio_derecha=0;
			edit.espacio_izquierda=COL-1;
		
		imprimir_arrays(px);
		
		boolean SALIR=false;
		do{
			SALIR = accion(avatar, edit, px);
			imprimir_arrays(px);
		}while(!SALIR);
		
	}
	
	static boolean accion(Posicion_Inicial avatar, Posicion_Inicial edit, char[][] px){
		boolean SALIR = false;
		System.out.print("UTILIZA: W Arriba || A Derecha || D Izquierda || S Abajo || M Menú || E Salir: ");
		switch(Character.toUpperCase(kb.next().charAt(0))){
			case 'S':
				if(avatar.espacio_abajo!=0){
					px[avatar.espacio_arriba][avatar.espacio_izquierda]=' ';
					avatar.espacio_arriba++;
					avatar.espacio_abajo--;
					px[avatar.espacio_arriba][avatar.espacio_izquierda]='X';				
				}
				break;
			
			case 'W':
				if(avatar.espacio_arriba!=0){
					px[avatar.espacio_arriba][avatar.espacio_izquierda]=' ';
					avatar.espacio_arriba--;
					avatar.espacio_abajo++;
					px[avatar.espacio_arriba][avatar.espacio_izquierda]='X';
				}
				break;
				
			case 'D':
				if(avatar.espacio_derecha!=0){
					px[avatar.espacio_arriba][avatar.espacio_izquierda]=' ';
					avatar.espacio_izquierda++;
					avatar.espacio_derecha--;
					px[avatar.espacio_arriba][avatar.espacio_izquierda]='X';
				}
				break;
				
			case 'A':
				if(avatar.espacio_izquierda!=0){
					px[avatar.espacio_arriba][avatar.espacio_izquierda]=' ';
					avatar.espacio_izquierda--;
					avatar.espacio_derecha++;
					px[avatar.espacio_arriba][avatar.espacio_izquierda]='X';
				}
				break;
				
			case 'E': SALIR=true; break;
			case 'M': edicion(avatar, edit, px);
		}
		return SALIR;
	}
	
	static void edicion(Posicion_Inicial avatar, Posicion_Inicial edit, char[][] px){
		char opcion, dire, distancia;
		String intro;
		do{
			imprimir_arrays_edicion(px);
			menu();
			intro = kb.next();
			opcion =  intro.charAt(0);
			dire   =  intro.charAt(1);
			distancia=intro.charAt(2);
			
			switch(opcion){
				case 'A':
//					accion_edicion(avatar.edit, px, dire, distancia);
					break;
				case 'B':
					break;
				case 'S':
					break;
			}
			
		}while(opcion!='S');
	}
	
	
	
	
/*		static boolean accion_edicion(Posicion_Inicial avatar, Posicion_Inicial edit, char[][] px, dire, distancia){
		boolean SALIR = false;
		System.out.print("UTILIZA: W Arriba || A Derecha || D Izquierda || S Abajo || M Menú || E Salir: ");
		switch(Character.toUpperCase(kb.next().charAt(0))){
			case 'S':
				if(avatar.espacio_abajo!=0){
					px[avatar.espacio_arriba][avatar.espacio_izquierda]=' ';
					avatar.espacio_arriba++;
					avatar.espacio_abajo--;
					px[avatar.espacio_arriba][avatar.espacio_izquierda]='X';				
				}
				break;
			
			case 'W':
				if(avatar.espacio_arriba!=0){
					px[avatar.espacio_arriba][avatar.espacio_izquierda]=' ';
					avatar.espacio_arriba--;
					avatar.espacio_abajo++;
					px[avatar.espacio_arriba][avatar.espacio_izquierda]='X';
				}
				break;
				
			case 'D':
				if(avatar.espacio_derecha!=0){
					px[avatar.espacio_arriba][avatar.espacio_izquierda]=' ';
					avatar.espacio_izquierda++;
					avatar.espacio_derecha--;
					px[avatar.espacio_arriba][avatar.espacio_izquierda]='X';
				}
				break;
				
			case 'A':
				if(avatar.espacio_izquierda!=0){
					px[avatar.espacio_arriba][avatar.espacio_izquierda]=' ';
					avatar.espacio_izquierda--;
					avatar.espacio_derecha++;
					px[avatar.espacio_arriba][avatar.espacio_izquierda]='X';
				}
				break;
				
			case 'E': SALIR=true; break;
			case 'M': edicion(px);
		}
		return SALIR;
	}
	
	
	*/
	
	static void menu(){
		System.out.println("\tELIGE UNA OPCION");
		System.out.println("\t================");
		System.out.println();
		System.out.println("A. Dirección(WASD). Casillas. (EJ:AS3)");
		System.out.println("B. Árbol.");
		System.out.println("S. Salir.");
		System.out.println();
		System.out.print("\tElige una opcion: ");
	}

	static void imprimir_arrays(char[][] px){

		for(int x=0; x<FIL; x++)
			for(int y=0; y<COL; y++)
				System.out.print(px[x][y]);
	}

	static void rellenar_arrays(char[][] px){
		for(int x=0; x<FIL; x++)	
			for(int y=0; y<COL; y++)
				px[x][y]=' ';	
	}

	static void imprimir_arrays_edicion(char[][] px){
		for(int x=0; x<FIL_MENU; x++)
			for(int y=0; y<COL; y++)
				System.out.print(px[x][y]);
	}
}

class Posicion_Inicial{
	int espacio_arriba=0;
	int espacio_izquierda=0;
	int espacio_derecha=prueba.COL-1;
	int espacio_abajo=prueba.FIL-1;
}
