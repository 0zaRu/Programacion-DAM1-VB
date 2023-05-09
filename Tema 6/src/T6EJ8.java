import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class T6EJ8 {
	public static void main(String[] args) {
		
		File ruta = null;
		String linea ="";
		
		if(args.length==2) ruta = new File(args[1]);
		
		if(args.length != 2) {
			System.err.println("Numero de parámetros erroneos.\t<java T6EJ8 \"c\" \"ruta\">");
			return;
		
		}else if(!Character.isLetter(args[0].charAt(0)) && !ruta.isFile()) {
			System.err.println("Información de parámetros erroneos.\t<java T6EJ8 \"c\" \"ruta\">");
			return;
		}
		
		BufferedReader leer = null;
		try {
			leer = new BufferedReader(new FileReader(ruta));
			for(int lin = 1; (linea = leer.readLine()) != null; lin++) 	
				if(linea.toUpperCase().contains(args[0].toUpperCase()))System.out.println(lin +". "+linea);
				
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
