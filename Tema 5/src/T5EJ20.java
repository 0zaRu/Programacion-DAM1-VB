import java.util.Scanner;

//comprobar extensión de un archivo, entre 1 y 3 caracteres con un solo punto

public class T5EJ20 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Introduce el nombre de un archivo y su extensión: ");
		String archivo = kb.nextLine();
		kb.close();
		
		String ext = archivo.substring(archivo.indexOf('.')+1, archivo.length());
		boolean valido=true;
		
		if(ext.length()>3 || ext.length()<1) 
			valido=false;

		else
			for(int x=0; x<ext.length(); x++)
				if(ext.charAt(x)=='.')
					valido=false;

		if(valido)System.out.println("Extenión válida.");
		else      System.out.println("Extensión o nombre no válidos. Tamaño o caracteres incorrectos.");
	}
}