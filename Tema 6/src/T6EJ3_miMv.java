import java.io.File;

public class T6EJ3_miMv {

	public static void main(String[] args) {
		
		File rutaOrigin, rutaFin;		
		
		//Comprobación inicial de parámetros pasados
		if(args.length == 2) {
			rutaOrigin = new File(args[0]);
			rutaFin    = new File(args[1]);
		}else{
			System.err.println("Parametros incorrectos\nUso: <java T6EJ1 [ruta+archivo] [ruta+NombreNuevo]>");
			return;
		}
		
		if(rutaOrigin.isFile()) {
			rutaOrigin.renameTo(rutaFin);
			System.out.println("El archivo: "+rutaOrigin.getName()+", se ha renombrado a "+rutaFin.getName());
		
		}else
			System.err.println("No has introducido un archivo\nUso: <java T6EJ1 [ruta+archivo] [ruta+NombreNuevo]>");
	}
}
