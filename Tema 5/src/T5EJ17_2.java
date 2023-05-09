//Contar cuantas veces se repite cada letra de un parámetro introducido
//La frase se recibe por parámetros a args[0]

public class T5EJ17_2{
	public static void main(String[] args) {
		
		for(int x=0, cont=0; x<args[0].length(); x++, cont=0) {
		boolean ya_contado=false;
		
			//Bucle para comprobar que la letra no ha sido contada antes
			for(int y=0; y<x; y++) 
				if(Character.toUpperCase(args[0].charAt(y)) == Character.toUpperCase(args[0].charAt(x)) && !ya_contado)
					ya_contado=true;
			
			//Si no se ha contado antes, y no es un espacio, pasamos a contar cuantas veces está en el programa y a imprimirlo
			if(!ya_contado && args[0].charAt(x) != ' ') {
				
				System.out.print("El carácter "+ Character.toUpperCase(args[0].charAt(x))+" se repite:");
				for(int y=x; y<args[0].length(); y++) {
					
					if(Character.toUpperCase(args[0].charAt(x)) == Character.toUpperCase(args[0].charAt(y))) cont++;
				
				}
				System.out.print(cont + " veces.\nSiendo la cadena de "+args[0].length()+" caracteres, conforma el "+((float)cont/args[0].length()*100)+"% de la frase.\n\n");
			}
		}
	}
}