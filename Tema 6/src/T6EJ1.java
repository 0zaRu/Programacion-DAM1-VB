import java.io.File;

public class T6EJ1 {
	public static void main(String[] args) {
		
		//Comprobación inicial de parámetros pasados
		if(args.length > 1) {
			System.err.println("Parametros incorrectos\nUso: <java T6EJ1 [dirección]>");
			return;
		}
		
		File ruta;
			
		//Creación de la ruta. Ruta en la que estamos si no se ha pasado ninguna, la pasada si se ha enviado
		if(args.length == 0) ruta = new File(".");
		else                 ruta = new File(args[0]);

		//Comprobar que se ha pasado un directorio
		if(!ruta.isDirectory()) {
			System.err.println("Parametros incorrectos\nUso: <java T6EJ1 [dirección]>");
			return;
		}
		
		//Invocación de método que simula un DIR.
		try {
			simulated_dir(ruta);
		}catch(java.lang.NullPointerException e){
			System.err.println("La ruta especificada no es correcta.\nUso: <java T6EJ1 [dirección]>");
			return;
		}
	}
	
	/** Método void que recibe una ruta tipo File que simula el comandos DIR */
	static void simulated_dir(File ruta) throws NullPointerException{
		File[] archivos = ruta.listFiles();
		
		for (int x = 0; x < archivos.length; x++) {
			if(archivos[x].isDirectory())
				System.out.println("\t-\t<DIR>\t\t"+archivos[x].getName());
			else
				System.out.println("\t-\t"+archivos[x].length()/8+"KB\t\t"+archivos[x].getName());		
		}
	}
}