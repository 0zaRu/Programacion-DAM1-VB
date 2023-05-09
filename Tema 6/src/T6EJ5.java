import java.util.Scanner;
import java.io.*;

public class T6EJ5 {
	
	static Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) {
		String ruta = "./Archivos de ejercicios/documento_EJ5.txt";
		File archivotxt = new File(ruta.replace('/', File.separatorChar));
		
		byte eleccion=0;
		
		eleccion = menu_ej5();

		if(eleccion == 1)
			escribir_caracter(archivotxt);
		
		else if(eleccion == 2)
			leer_caracter(archivotxt);
		
		else {
			System.out.println("Se ha salido del programa sin hacer nada. \nPulse cualquier tecla ...");
			kb.next();
		}
		kb.close();
	}
	
	static byte menu_ej5() {
		System.out.println("          ELIGE UNA OPCIÓN           ");
		System.out.println("=====================================");
		System.out.println();
		System.out.println("1. Escribir un carácter en el archivo");
		System.out.println("2. Leer un carácter del archivo");
		System.out.println("3. Salir");
		System.out.println("=====================================");
		System.out.print("Opción: ");
		return kb.nextByte();
	}
	
	static void escribir_caracter(File ruta) {
		
		PrintWriter fSalir = null;
		
		try {
				
			fSalir= new PrintWriter (new FileWriter (ruta, true));
			
			System.out.print("\n\nIntroduce el caracter que quieres escribir: ");
			fSalir.print(kb.next().charAt(0));
			System.out.println("Escritura realizada correctamente.");
			
		}catch(IOException e) {
			System.err.println("Ha ocurrido un error durante la escritura: "+e.getMessage());
		
		}finally {
		fSalir.close();
		}
	}
	
	static void leer_caracter(File ruta) {
		
		DataInputStream lectura = null;
		
		try {
		
			lectura = new DataInputStream( new FileInputStream(ruta));
			System.out.println("El primer caracter del archivo es: "+(char)lectura.read());
		
		}catch(IOException e) {
			System.out.println("Fallo en la lectura de un caracter: "+e.getMessage());
		}
	}
}
