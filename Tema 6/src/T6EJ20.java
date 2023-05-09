import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class T6EJ20 {
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Introduce el fichero de salida: ");
		String file = kb.nextLine();
		File ruta = new File(file);
		
		if(!ruta.exists())
			try {
				ruta.createNewFile();
			} catch (IOException e1) {
				System.err.println("No se ha podido crear el archivo");
				kb.close();
				return;
			}
		
		boolean escribaserrores = true;
		int cont = 0;
		
		try {
			PrintStream ps = new PrintStream(new FileOutputStream(ruta, true));
			System.setErr(ps);
			while(escribaserrores) {
				try {
					cont++;
					System.out.print("Introduce un numero entero (si lo haces termina): ");
					cont = kb.nextInt();
					
					System.out.println();
					
					System.out.println("Has metido un entero, muy mal.");
					escribaserrores = false;
					
				}catch(InputMismatchException e) {
					System.err.println("Muy bien, no era un entero. Cantidad de errores seguidos: "+cont);
					kb.nextLine();
				}
			}
				
		} catch (FileNotFoundException e) {

		}
		
		kb.close();
	}
}
