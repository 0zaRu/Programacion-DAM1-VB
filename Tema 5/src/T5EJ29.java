//import java.util.Arrays;
import java.util.Scanner;
/*
Cree una versión reducida de un guerra barcos, en el que un jugador tratará de hundir los 
barcos previamente colocados por otro jugador. Se dispondrá de un tablero clásico de guerra 
barcos, con 8 filas (identificadas por números) y 8 columnas (identificadas por letras). El primer 
jugador colocará en el un barco de cuatro casillas, otro de tres, otro de dos, y otro de una 
casilla, siguiendo las reglas conocidas del juego. Una vez colocados, el segundo jugador 
dispondrá de un número N de intentos (por ejemplo 20), para hundir los barcos. Ante una 
propuesta (por ejemplo C - 6), el juego responderá diciendo SI Agua, Tocado o Hundido, e irá 
llevando la cuenta de los barcos y piezas hundidas. Si al final el segundo jugador consigue 
hundir toda la flota del primero, habrá ganado la partida; en otro caso, la habrá perdido. 
NOTA: Amplíe dicho programa tanto como le permita su imaginación y conocimientos (permita 
un "contraataque" del primer jugador, haciendo que tras disparar el segundo, pueda disparar 
el primero, amplíe el número de barcos.
 */
public class T5EJ29
{
	static final int MAX_BARCO=4;
	
	static Scanner kb=new Scanner(System.in);
	
	public static void main(String[] args)
	{		
		//Creamos el tablero, que estará cargado a 0 (agua) y el valor de la casilla se pondrá a 1 si hay un barco.
		int[][] tablero = new int[8][8];
//		Arrays.fill(tablero, 0);

		//Lo siguiente será rellenar el mapa con los barcos con la horientación del barco que el jugador quiera
		int tam_barco=MAX_BARCO;
		
		do
		{
			//Llamamos a una función para que coloque el barco sobre el mapa.
			rellenar_mapa(tablero, tam_barco--);	
			
		} while(tam_barco>0);
	}
	
	static void rellenar_mapa(int[][] tablero, int tam)
	{
		mostrar_barcos(tablero);
		System.out.print("\nIntroduce la casilla donde irá la primera posición del barco de "+tam+" casillas además de su horientación (V o H)(EJ: D4H | D4V):");
		String comand = kb.nextLine();
		
		int col=(int)(Character.toUpperCase(comand.charAt(0))-65);
		int fil=Integer.parseInt(Character.toString(comand.charAt(1)-1));
		int horient=Character.toUpperCase(comand.charAt(2));
		
		for(int y=0; y<tam; y++) {
			System.out.println(fil+" "+col);
			if(horient == 'H') {
				tablero[fil][col+y] = 1;
			}
		}
	}
	
	
    //*Mostrar una matriz dada desde la invocación */
    static void mostrar_barcos(int[][] matriz){

        System.out.println("\n\nEl tablero es: ");
        System.out.println("=========================\n");

        System.out.print(" ");
        
        for(int x=0; x<matriz.length; x++)
        	System.out.print(" "+(char)('A'+ x));
        
        System.out.println();
        
        for(int x=0; x<matriz.length; x++){
        	System.out.print(x+1);
            for(int y=0; y<matriz[x].length; y++)
                if(matriz[x][y] == 0) System.out.print(" .");
                else				  System.out.print("[]");
        
            System.out.println();
        }
        System.out.println("\n\n");
    }
}
