package t9ej4;

public class Vecino {
	private String nombre;
	private String apellidos;
	private int piso;
	private char letra;

	Vecino(String nombre, String apellidos, int piso, char letra){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.piso = piso;
		this.letra = letra;
	}
	
	Vecino(String nombre){
		this.nombre = nombre;
		this.apellidos = "";
		this.piso = 0;
		this.letra = 0;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public char getLetra() {
		return letra;
	}
	public int getPiso() {
		return piso;
	}
	
	public String toString() {
		return this.nombre + " " + this.apellidos + " " + this.piso+"º "+this.letra;
	}
}
