import java.io.File;
import java.util.Scanner;

public class T6EJ4_miRm {
	
	static Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) {

		File ruta = null;
		boolean preguntar = true;
		boolean arg_valido = false;

		// Comprobación de argumentos enviados
		if (args.length == 1) {
			
			ruta = new File(args[0]);
			if (ruta.isFile()) arg_valido = true;

		} else if (args.length == 2 && args[0].equalsIgnoreCase("-r")) {
		
			ruta = new File(args[1]);
			if (ruta.isDirectory()) arg_valido = true;
		}
		
		
		//Si se ha considerado en las pruebas anteriores, que los argumentos no son correctos, controlamos el error.
		if (!arg_valido) {
			System.err.println("Error. Parámetros o ruta no válidos\nUso: <java T6EJ4_miRm fichero>\nUso: <java T6EJ4_miRm -r directorio>");
			return;
		}
		
		//Si se ha pasado una ruta, se pregunta si se quiere confirmar antes de borrar cada archivo
		if(ruta.isDirectory()) {
			System.out.print("Desea confirmar antes de eliminar todos los ficheros? (S/N): ");
			char respuesta = Character.toUpperCase(kb.nextLine().charAt(0));
			
			if(respuesta == 'N') preguntar = false;
		}
		
		//Con todas las comprobaciones, se envía la ruta a procesar, si es un fichero o directorio, y si se quiere confirmar la eliminación de los ficheros
		simulated_Rm(ruta, ruta.isFile(), preguntar);
		kb.close();
	}
	
	static void simulated_Rm(File ruta, boolean esFichero, boolean confirmación) {

		//En caso de ser un fichero (o una ruta vacía)
		if(esFichero) {
			//En caso de que se quiera confirmar antes de eliminar, preguntamos
			if(confirmación) {
				System.out.print("Estás seguro de que quieres eliminar el fichero "+ruta.getName()+"? (S/N): ");
				char comprobar = Character.toUpperCase(kb.nextLine().charAt(0));
				
				//Si se quiere eliminar definitivamente (S) lo mostramos, else decimos que se ha cancelado
				if(comprobar == 'S') {
					System.out.println("Se ha eliminado el fichero "+ruta.getName());
					ruta.delete();
				
				}else System.out.println("No se ha eliminado el fichero.");
			
			//Si no se quiso confirmación, simplemente lo borramos
			}else {
				System.out.println("Se ha eliminado el fichero "+ruta.getName());
				ruta.delete();
			}
			
		//Si es una ruta (no es un fichero) listamos su contenido y lo enviamos de forma recursiva marcando si es otra ruta o un fichero
		}else {
			
			File[] listado = ruta.listFiles();

			for (int x = 0; x < listado.length; x++) {
				if(listado[x].isFile()) simulated_Rm(listado[x], true, confirmación);
				else                    simulated_Rm(listado[x], false, confirmación);
			}
			
			//Una vez se ha borrado todos los archivos internos, se pasa a procesar la propia ruta, enviándola como un fichero (pues debería estar vacío)
			if (ruta.listFiles().length == 0) simulated_Rm(ruta, true, confirmación);
		}
	}
}
