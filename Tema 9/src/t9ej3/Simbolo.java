package t9ej3;

import java.util.ArrayList;

public class Simbolo {
	private char abrir;
	private char cerrar;
	
	Simbolo(char abrir, char cerrar){
		this.abrir = abrir;
		this.cerrar = cerrar;
	}
	
	public static ArrayList<Simbolo> ALSimbolosDef(){
		
		ArrayList<Simbolo> simbolos = new ArrayList<Simbolo>();
		simbolos.add(new Simbolo('(', ')'));
		simbolos.add(new Simbolo('[', ']'));
		simbolos.add(new Simbolo('{', '}'));
		
		return simbolos;
	}	
	
	public static boolean esApertura(char c, ArrayList<Simbolo> simbolos) {
		for (int i = 0; i < simbolos.size(); i++) 
			if(simbolos.get(i).getAbrir() == c)
				return true;
		
		return false;
	}
	
	public static boolean esCierre(char c, ArrayList<Simbolo> simbolos) {
		for (int i = 0; i < simbolos.size(); i++) 
			if(simbolos.get(i).getCerrar() == c)
				return true;
		
		return false;
	}
	
	public static boolean compruebaPareja(Simbolo comprobar, ArrayList<Simbolo> simbolos){
		
		for (int i = 0; i < simbolos.size(); i++) {
			if(simbolos.get(i).getAbrir() == comprobar.getAbrir() && simbolos.get(i).getCerrar() == comprobar.getCerrar())
				return true;
		}
		
		return false;
	}
	
	public char getCerrar() {
		return cerrar;
	}
	public char getAbrir() {
		return abrir;
	}
}
