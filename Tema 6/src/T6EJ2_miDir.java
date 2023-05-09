import java.io.File;

/**
 * Esta clase representa un programa que muestra el contenido de un directorio.
 * Fue creada por Alberto Rodríguez el a principios del segundo trimestres.
 * @version 1.0
 */
public class T6EJ2_miDir {
	
	/**
	 * Este método es el punto de entrada del programa.
	 * @param args Los argumentos de línea de comandos. Si se proporciona "-r", se mostrará el contenido del directorio de forma recursiva. Si se proporciona una ruta, se mostrará el contenido del directorio especificado. Si no se proporcionan argumentos, se mostrará el contenido del directorio actual.
	 */
	public static void main(String[] args) {
		
		File ruta;
		boolean recursiva = false;

		if(args.length == 0)
			ruta = new File(".");
		
		else if(args.length == 1) {
			
			if(args[0] == "-r") {
				recursiva = true;
				ruta = new File(".");
			
			}else {
				ruta = new File(args[0]);
			} 
		
		}else if(args.length == 2 && args[0].equalsIgnoreCase("-r")) {
			recursiva = true;
			ruta = new File(args[1]);
		
		}else {
			System.err.println("Parametros incorrectos\nUso: <java T6EJ1 [-r] [dirección]>");
			return;
		}
		
		if(!ruta.isDirectory()) {
			System.err.println("Parametros incorrectos\nUso: <java T6EJ1 [-r] [dirección]>");
			return;
		}
		
		try {
			
			simulated_dir(ruta, recursiva, 0);
			
		}catch(java.lang.NullPointerException e){
			System.err.println("La ruta especificada no es correcta.\nUso: <java T6EJ1 [-r] [dirección]>");
			return;
		}
	}	
	
	/**
	 * Este método muestra el contenido de un directorio de forma simulada.
	 * @param ruta La ruta del directorio a mostrar.
	 * @param recursiva Indica si se debe mostrar el contenido del directorio de forma recursiva.
	 * @param tab El número de tabulaciones a utilizar para la salida.
     * @throws NullPointerException Si la ruta especificada no es correcta.
     * @return no es necesario porque no devuelve nada
     * @since creación del código
     */
	static void simulated_dir(File ruta, boolean recursiva, int tab) throws NullPointerException{
		
		File[] archivos = ruta.listFiles();
	
		for (int x = 0; x < archivos.length; x++) {
			for (int y = 0; y < tab; y++) 
				System.out.print("\t");
		
			if(archivos[x].isDirectory()) {
				System.out.println("-\t<DIR>\t\t"+archivos[x].getName());
				
				if(recursiva) {
					simulated_dir(archivos[x], recursiva, tab+1);
					System.out.println();
				}
			
			}else System.out.println("-\t"+archivos[x].length()/8+"\tKB\t"+archivos[x].getName());	
		}
    }
}


