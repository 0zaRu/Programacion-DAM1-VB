import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Cumple{
	String nombre ="";
	String fecha = "";
}

public class T6EJ7 {
	
	static final byte AÑADIR = 1;
	static final byte LEER   = 2;
	static final byte SALIR  = 3;
	static final int LINEAS = 30;
	
	static Scanner kb = new Scanner (System.in);
	
	public static void main(String[] args) {

		File archivotxt = null;
		String ruta = "";
			
		boolean salir = false;
		
		do {
			System.out.print("Introduce la ruta de la agenda que vas a utlizar: ");
			ruta = kb.nextLine();
			
			archivotxt = new File (ruta);
			if(!archivotxt.exists()) System.err.println("Ruta especificada no válida\n\n");
			
		}while(!archivotxt.exists());
		
		
		while(!salir) {
			switch(menu_ej7()) {
				case AÑADIR:
					Cumple nuevo = new Cumple();
					
					System.out.print("Introduzca el nombre del cumpleañero de la nueva fecha: ");
					nuevo.nombre = kb.nextLine();

					
					System.out.print("\nIntroduce la fecha de cumpleaños (dd/mm/aaaa): ");
					nuevo.fecha = kb.nextLine();
					
					String[] fecha_separada = nuevo.fecha.split("/");
						if(fecha_separada[0].length() > 2 || fecha_separada[1].length() > 2 || fecha_separada[2].length() > 4) {
							System.err.println("Se ha introducio la fecha con un formato erroneo. Vuelva a intentarlo ...");
							break;
						}
					
					newCumple(nuevo, archivotxt);
					break;
				
				case LEER:
					consulCumple(archivotxt);
					break;
					
				case SALIR:
					salir = true;
					break;
				
				default:
					System.out.println("Opción introducida no válida, elige un número del menú ...");
			}
			kb.nextLine();
			limpiar_pantalla();
		}
		
		System.out.println("Se ha salido del programa. Pulse una tecla para continuar ...");
		kb.nextLine();
		
		kb.close();
		
	}
	
	static byte menu_ej7() {
		System.out.println("          ELIGE UNA OPCIÓN           ");
		System.out.println("=====================================");
		System.out.println();
		System.out.println("\t"+AÑADIR+". Nuevo cumpleaños");
		System.out.println("\t"+LEER+". Consultar cumpleaños");
		System.out.println("\t"+SALIR+". Salir");
		System.out.println("=====================================");
		System.out.print("Opción: ");
		byte opcion = kb.nextByte();
		kb.nextLine();
		
		return opcion;
	}

	static void newCumple(Cumple cumple, File ruta) {

		PrintWriter escribe = null;
		
		try {
		escribe = new PrintWriter(new FileWriter(ruta, true));
			
			escribe.print(cumple.nombre +"\n"+ cumple.fecha +"\n");
		//	escribe.close();	
			
		} catch (IOException e) {
			System.err.println("Ha habido un error durante la escritura: "+e.getMessage()+e.getCause());
		}
		finally {
			escribe.close();
		}
	}
	
	static void consulCumple(File ruta) {
		
		String linea ="";
		BufferedReader leer = null;
				
		try {
			 leer = new BufferedReader(new FileReader(ruta));
			
			while((linea = leer.readLine()) != null) {
				System.out.print("\nEl cumpleaños de "+linea+" es el día ");
			
				String[] cumple = leer.readLine().split("/");
				System.out.print(cumple[0] + " del " + cumple[1] + " (nació en el año "+cumple[2]+")\n");
			}
			
		}catch(IOException e) {
			System.err.println("Ha habido un error durante la lectura: "+e.getMessage());
		}finally {
			try {
				leer.close();
			} catch (IOException e) {
				e.getMessage();
			}
		}
	}
	
	static void limpiar_pantalla() {
		for (int i = 0; i < LINEAS; i++) 
			System.out.println();
	}
}
