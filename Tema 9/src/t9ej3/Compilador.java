package t9ej3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class Compilador {
	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.err.println("Error de ejecución. Incluye un archivo de texto como parámetro.");
			return;
		}
		
		ArrayList<Simbolo> simbolos = Simbolo.ALSimbolosDef();
		BufferedReader leer = null;
		
		try {
			String linea = "";
			int cont = 0;
			
			leer= new BufferedReader(new FileReader(args[0]));
			
			while((linea = leer.readLine()) != null) {
				cont++;
				
				if(!compruebaSignos(linea, simbolos))
					System.out.println("Error de compilación en la línea "+cont);
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("Error. Archivo no encontrado."+ e.getMessage());
		} catch (IOException e) {
			System.out.println("Se ha terminado la lectura de forma correcta.");
		} finally {
			try {
				leer.close();
			} catch (IOException e) {
				System.err.println("Error al cerrar BufferedReader"+e.getMessage());
			}
		}
	}
	
	static boolean compruebaSignos(String linea, ArrayList<Simbolo> simbolos) {
		Stack<Character> compi = new Stack<Character>();
		
		try {
			for (int i = 0; i < linea.length(); i++) {
				
				if(Simbolo.esApertura(linea.charAt(i), simbolos))
					compi.add(linea.charAt(i));
				
				else if(Simbolo.esCierre(linea.charAt(i), simbolos))
					if(!Simbolo.compruebaPareja(new Simbolo(compi.pop(), linea.charAt(i)), simbolos)) {
						System.out.print("Error de compensación. ");
						return false;
					}
			}
			
		} catch(EmptyStackException e) {
			System.out.print("Cierre sin apertura. ");
			return false;
		}

		if(!compi.isEmpty()) {
			System.out.print("Quedan símbolos abiertos. ");
			return false;
		}
		
		return true;
	}
	
}
