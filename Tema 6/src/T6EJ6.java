import java.util.Scanner;
import java.io.*;

public class T6EJ6 {
	
	static Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) {
		String ruta = "./Archivos de ejercicios/documento_EJ6.txt";
		File archivotxt = new File(ruta.replace('/', File.separatorChar));
		
		byte eleccion=0;
		boolean salir = false;
		
		do {
			eleccion = menu_ej6();
			kb.nextLine();
			
			if(eleccion == 1)
				escribir_cadena(archivotxt);
			
			else if(eleccion == 2)	
				leer_cadenas(archivotxt);

			else 
				salir = true;
			
			kb.nextLine();
			limpiar_pantalla();
			
		}while(!salir);
		
		System.out.println("Se ha salido del programa sin hacer nada. \nPulse cualquier tecla ...");
		kb.nextLine();
		kb.close();
	}
	
	static byte menu_ej6() {
		System.out.println("          ELIGE UNA OPCIÓN           ");
		System.out.println("===========================================");
		System.out.println();
		System.out.println("1. Escribir una cadena en el archivo");
		System.out.println("2. Leer una cantidad de cadenas del archivo");
		System.out.println("3. Salir");
		System.out.println("===========================================");
		System.out.print("Opción: ");
		return kb.nextByte();
	}
	
	static void escribir_cadena(File ruta) {

		System.out.print("\n\nIntroduce la cadena que quieres escribir: ");
		String salida = kb.nextLine();

		PrintWriter fSalir = null;
		
		try {
				
			fSalir= new PrintWriter (new FileWriter (ruta, true));
			
			fSalir.print("\n"+ salida);
			System.out.println("Escritura realizada correctamente.");
			
		}catch(IOException e) {
			System.err.println("Ha ocurrido un error durante la escritura: "+e.getMessage());
		
		}finally {
		fSalir.close();
		}
	}
	
	static void leer_cadenas(File ruta) {
		
		System.out.print("Cuántas líneas quieres leer?: ");
		int nLinMax = kb.nextInt();
		
		int nLin = 0;
		BufferedReader leer = null;
		
		try {
			leer = new BufferedReader(new FileReader(ruta));
			
			String linea = "";
			while((linea = leer.readLine()) != null && nLin < nLinMax) {
				System.out.println("Línea "+ (nLin+1) + ": " +linea);
				nLin++;
			}
			
			if(nLin < nLinMax)System.out.println("No hay más líneas");
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		kb.nextLine();
	}
	
	static void limpiar_pantalla() {
		for (int i = 0; i < 30; i++) 
			System.out.println();
	}
}