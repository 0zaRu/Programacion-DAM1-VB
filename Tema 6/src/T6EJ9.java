import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class T6EJ9 {
	public static void main(String[] args) {
		
		File ruta = null;
		String linea ="";
		int cont = 0;
		
		if(args.length==1) ruta = new File(args[0]);
		
		if(args.length != 1) {
			System.err.println("Numero de parámetros erroneos.\t<java T6EJ9 \"ruta\">");
			return;
		
		}else if(!ruta.isFile()) {
			System.err.println("Información de parámetros erroneos.\t<java T6EJ9 \"ruta\">");
			return;
		}
		
		BufferedReader leer = null;
		try {
			leer = new BufferedReader(new FileReader(ruta));
			
			while((linea = leer.readLine()) != null) {
				String[] palabras = linea.split("[ ]");
				cont += palabras.length;
				
				for(int x=0; x<palabras.length; x++)
					if(palabras[x].contains("[\t]")) cont++;
			}
			
			System.out.println("\nEl archivo tiene "+cont+" palabras.");
				
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			try {
				leer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
}
